package org.jsp.controller;

import org.jsp.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping(value = "/home")
	public String home(Model model) {
		model.addAttribute("user", "Saif");
		return "home.jsp";
	}

	@RequestMapping("/sum")
	public String sum(Model model, @RequestParam(name = "n1") int a, @RequestParam(name = "n2") int b) {
		model.addAttribute("result", "The sum is: " + (a + b));
		return "print.jsp";
	}

	@RequestMapping("/diff")
	public String diff(Model model, @RequestParam int n1, @RequestParam int n2) {
		model.addAttribute("result", "The difference is: " + (n1 - n2));
		return "print.jsp";
	}

	@PostMapping("/register")
	public ModelAndView register(ModelAndView view, @ModelAttribute User user) {
		view.addObject("user", user);
		view.setViewName("printUser.jsp");
		return view;
	}
}
