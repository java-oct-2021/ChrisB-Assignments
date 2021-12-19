package com.chris.plusultra.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chris.plusultra.models.Share;
import com.chris.plusultra.models.User;
import com.chris.plusultra.services.PictureService;
import com.chris.plusultra.services.ShareService;
import com.chris.plusultra.services.UserService;
import com.chris.plusultra.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private ShareService sService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	@Autowired
	private PictureService pService;
	
	private static String UPLOADED_FOLDER = "src/main/resources/static/images/";
	
	@GetMapping("/")
	public String landing(@ModelAttribute("user")User user) {
		return "/share/landing.jsp";
	}
	
	@PostMapping("/registerUser")
	public String register(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "/share/landing.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("lemail")String email, @RequestParam("lpassword")String password, RedirectAttributes redirectAttr) {
		if(!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User userToBeLoggedIn = this.uService.getUserByEmail(email);
		session.setAttribute("user__id", userToBeLoggedIn.getId());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/dashboard")
	public String dashboard(@ModelAttribute("share")Share share, Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user__id");
		User user = uService.find(userId);
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
//		viewModel.addAttribute("loggedInUser", (Long)session.getAttribute("user__id"));
//		viewModel.addAttribute("shareDetails", this.sService.getOneShare(id));
		viewModel.addAttribute("allShares", this.sService.getAllShares());
		viewModel.addAttribute("currentUser", user);
		return "/share/dashboard.jsp";
	}
	@GetMapping("/profile/{id}")
	public String userProfile(@PathVariable("id")Long id, Model viewModel, HttpSession session){
		User user = uService.find(id);
		viewModel.addAttribute("userDetails", this.uService.getOneUser(id));
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		viewModel.addAttribute("pictures", this.pService.userPictures(user));
		viewModel.addAttribute("shareDetails", this.sService.getOneShare(id));
		viewModel.addAttribute("loggedInUser", (Long)session.getAttribute("user__id"));
		return "/user/profile.jsp";
	}
	
	@GetMapping("/new")
	public String add(@ModelAttribute("share")Share share, HttpSession session, Model viewModel) {
		viewModel.addAttribute("userID",(Long)session.getAttribute("user__id"));
		return "/share/dashboard.jsp";
	}
	
	@PostMapping("/new")
	public String addShare(@Valid @ModelAttribute("share")Share share, BindingResult result, HttpSession session) {
		User user = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		share.setOwner(user);
		if(result.hasErrors()) {
			return "redirect:/dashboard";
		}
		this.sService.createShare(share);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id")Long id, HttpSession session) {
		User userToLikeShare = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Share sharesToLike = this.sService.getOneShare(id);
		this.sService.likeShare(userToLikeShare, sharesToLike);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id")Long id, HttpSession session) {
		User userToUnlikeShare = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Share shareToUnlike = this.sService.getOneShare(id);
		this.sService.unlikeShare(userToUnlikeShare, shareToUnlike);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/edit/{id}")
	public String editShare(@PathVariable("id")Long id, @ModelAttribute("share")Share share, Model viewModel) {
		viewModel.addAttribute("share", this.sService.getOneShare(id));
		return "/share/editShare.jsp";
	}
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("share") Share share, BindingResult result, @PathVariable("id")Long id, Model viewModel, HttpSession session) {
		if(result.hasErrors()) {
			viewModel.addAttribute("share", this.sService.getOneShare(id));
			return "/idea/editShare.jsp";
		}
		this.sService.editShare(share);
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		return "redirect:/dashboard";
	}
	
	@GetMapping("/activity/{id}")
	public String show(@PathVariable("id")Long id, Model viewModel, HttpSession session) {
		viewModel.addAttribute("shareDetails", this.sService.getOneShare(id));
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		viewModel.addAttribute("loggedInUser", (Long)session.getAttribute("user__id"));
		return "/share/activity.jsp";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		this.sService.deleteShare(id);
		return "redirect:/dashboard";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("pic")MultipartFile file, @RequestParam("description")String desc, HttpSession session, RedirectAttributes redirectAttr) {
		User user = uService.find((Long)session.getAttribute("user_id"));
		if(file.isEmpty()) {
			redirectAttr.addFlashAttribute("message", "Upload field cannot be empty");
			return "redirect:/dashboard";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			String url = "/images/" + file.getOriginalFilename();
			this.pService.uploadPic(user, url, desc);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "redirect:/dashboard";
	}
}

