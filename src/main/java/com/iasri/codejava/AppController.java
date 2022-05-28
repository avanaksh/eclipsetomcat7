package com.iasri.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {
   @Autowired
   private UserRepository repo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	//@GetMapping("/login")
	//public String showLoginForm(Model model) {
	//	Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
	//	if(authentication==null|| authentication instanceof AnonymousAuthenticationToken) {
	//		return "login";
	//	}
	//	return "redirect:/";
	//}
	
	@GetMapping("/register")
	public String showSignupForm(Model model) {
		model.addAttribute("user", new User());
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
	    String encodedPassword=passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
		repo.save(user);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers=repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	
}
