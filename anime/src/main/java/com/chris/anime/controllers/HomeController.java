package com.chris.anime.controllers;

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

import com.chris.anime.models.Anime;
import com.chris.anime.models.User;
import com.chris.anime.services.AnimeService;
import com.chris.anime.services.UserService;
import com.chris.anime.validators.UserValidator;

@Controller
public class HomeController {
	@Autowired
	private AnimeService aService;
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
		validator.validate(user,result);
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
	public String index(Model viewModel, HttpSession session) {
		if(session.getAttribute("user__id")== null) {
			return "redirect:/";
		}
		viewModel.addAttribute("user", this.uService.getOneUser((Long)session.getAttribute("user__id")));
		viewModel.addAttribute("allAnimes", this.aService.getAllAnimes());
		return "index.jsp";
	}
	
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id")Long id, HttpSession session) {
		User userToLikeAnime = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Anime animeToLike = this.aService.getOneAnime(id);
		this.aService.likeAnime(userToLikeAnime, animeToLike);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id")Long id, HttpSession session) {
		User userToLikeAnime = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		Anime animeToUnlike = this.aService.getOneAnime(id);
		this.aService.unlikeAnime(userToLikeAnime, animeToUnlike);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/new")
	public String add(@ModelAttribute("anime")Anime anime, HttpSession session, Model viewModel) {
		viewModel.addAttribute("userID",(Long)session.getAttribute("user__id"));
		return "add.jsp";
	}
	
	@PostMapping("/new")
	public String addAnime(@Valid @ModelAttribute("anime")Anime anime, BindingResult result, HttpSession session) {
		User user = this.uService.getOneUser((Long)session.getAttribute("user__id"));
		anime.setOwner(user);
		if(result.hasErrors()) {
			return "add.jsp";
		}
		this.aService.createAnime(anime);
		return "redirect:/dashboard";
	}
	@GetMapping("/edit/{id}")
	public String editAnime(@PathVariable("id")Long id, @ModelAttribute("anime")Anime anime, Model viewModel) {
		viewModel.addAttribute("anime", this.aService.getOneAnime(id));
		return "edit.jsp";
	}
	@PostMapping("/edit/{id}")
	public String edit(@Valid @ModelAttribute("anime") Anime anime, BindingResult result, @PathVariable("id")Long id, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("anime", this.aService.getOneAnime(id));
			return "edit.jsp";
		}
		this.aService.editAnime(anime);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/details/{id}")
	public String show(@PathVariable("id")Long id, Model viewModel, HttpSession session) {
		viewModel.addAttribute("animeDetails", this.aService.getOneAnime(id));
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		viewModel.addAttribute("loggedInUser", (Long)session.getAttribute("user__id"));
		return "show.jsp";
	}
	
	@PostMapping("/htmladd")
	public String htmladd(@RequestParam("animeTitle")String anime, @RequestParam("animeDescr")String description, @RequestParam("numberOfEpis")Integer numberOfEpis) {
		Anime animeToSave = new Anime(anime, description, numberOfEpis);
		this.aService.createAnime(animeToSave);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/profile/{id}")
	public String userProfile(@PathVariable("id")Long id, Model viewModel, HttpSession session){
		viewModel.addAttribute("userDetails", this.uService.getOneUser(id));
		viewModel.addAttribute("user", this.uService.getOneUser(id));
		return "/user/profile.jsp";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id")Long id) {
		this.aService.deleteAnime(id);
		return "redirect:/dashboard";
	}
}
