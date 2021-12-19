package com.chris.ideas.controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chris.ideas.models.Idea;
import com.chris.ideas.models.User;
import com.chris.ideas.services.IdeaService;
import com.chris.ideas.services.UserService;
import com.chris.ideas.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private IdeaService iService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	@GetMapping("/")
	public String landing(@ModelAttribute("user")User user) {
		return "landing.jsp";
	}
	
	@PostMapping("/registerUser")
	public String register(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "landing.jsp";
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
	public String dashboard(Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id")== null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		viewModel.addAttribute("allIdeas", this.iService.getAllIdeas());
		return "dashboard.jsp";
	}
	
	@GetMapping("/new")
	public String add(@ModelAttribute("idea")Idea idea, HttpSession session, Model viewModel) {
		viewModel.addAttribute("userID",(Long)session.getAttribute("user__id"));
		return "/idea/addIdea.jsp";
	}
	@PostMapping("/new")
	public String addIdea(@Valid @ModelAttribute("idea")Idea idea, BindingResult result, HttpSession session) {
		User user = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		idea.setOwner(user);
		if(result.hasErrors()) {
			return "/idea/addIdea.jsp";
		}
		this.iService.createIdea(idea);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/details/{id}")
	public String show(@PathVariable("id")Long id, Model viewModel, HttpSession session) {
		viewModel.addAttribute("ideaDetails", this.iService.getOneIdea(id));
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		viewModel.addAttribute("loggedInUser", (Long)session.getAttribute("user__id"));
		return "/idea/showIdea.jsp";
	}
	
	@GetMapping("/profile/{id}")
	public String userProfile(@PathVariable("id")Long id, Model viewModel, HttpSession session){
		viewModel.addAttribute("userDetails", this.uService.getOneUser(id));
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		return "/user/profile.jsp";
	}
	
	@GetMapping("/edit/{id}")
	public String editIdea(@PathVariable("id")Long id, @ModelAttribute("idea")Idea idea, Model viewModel) {
		viewModel.addAttribute("idea", this.iService.getOneIdea(id));
		return "/idea/editIdea.jsp";
	}
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("idea") Idea idea, BindingResult result, @PathVariable("id")Long id, Model viewModel, HttpSession session) {
		if(result.hasErrors()) {
			viewModel.addAttribute("anime", this.iService.getOneIdea(id));
			return "/idea/editIdea.jsp";
		}
		this.iService.editIdea(idea);
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		return "redirect:/dashboard";
	}
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id")Long id, HttpSession session) {
		User userToLikeIdea = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Idea ideasToLike = this.iService.getOneIdea(id);
		this.iService.likeIdea(userToLikeIdea, ideasToLike);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id")Long id, HttpSession session) {
		User userToUnlikeIdea = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Idea ideaToUnlike = this.iService.getOneIdea(id);
		this.iService.unlikeIdea(userToUnlikeIdea, ideaToUnlike);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		this.iService.deleteIdea(id);
		return "redirect:/dashboard";
	}
}
