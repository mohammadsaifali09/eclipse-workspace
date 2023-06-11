package org.jsp.springmvcapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	@RequestMapping("/logout")
	public ModelAndView logout(ModelAndView view, HttpSession session) {
		session.invalidate();
		view.setViewName("login.jsp");
		view.addObject("msg", "You are logged out");
		return view;
	}
}
