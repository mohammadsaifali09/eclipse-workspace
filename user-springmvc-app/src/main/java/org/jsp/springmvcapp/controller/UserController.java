package org.jsp.springmvcapp.controller;

import org.jsp.springmvcapp.dao.UserDao;
import org.jsp.springmvcapp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(names = { "u" })
public class UserController {
	@Autowired
	private UserDao dao;

	@PostMapping(value = "/save")
	public ModelAndView saveUser(ModelAndView view, User user) {
		user = dao.saveUser(user);
		view.addObject("msg", "User saved with id: " + user.getId());
		view.setViewName("print.jsp");
		return view;
	}

	@PostMapping(value = "/update")
	public ModelAndView updateUser(ModelAndView view, User user) {
		user = dao.updateUser(user);
		view.addObject("u", user);
		view.addObject("msg", "User updated with id: " + user.getId());
		view.setViewName("print.jsp");
		return view;
	}

	@PostMapping(value = "/login")
	public ModelAndView login(ModelAndView view, @RequestParam long phone,@RequestParam String password) {
		User user = dao.verifyUser(phone, password);
		if (user!=null) {
			view.addObject("u", user);
			view.setViewName("home.jsp");
			return view;
		} else {
			view.addObject("msg", "Invalid phone or password");
			view.setViewName("login.jsp");
			return view;
		}
	}

	@GetMapping(value = "/delete")
	public ModelAndView deleteUser(ModelAndView view, @RequestParam int id) {
		boolean isDelete = dao.deleteUser(id);
		if (isDelete) {
			view.setViewName("login.jsp");
			view.addObject("msg", "Your account is deleted");
			return view;
		} else {
			view.setViewName("login.jsp");
			view.addObject("msg", "You must login to delete");
			return view;
		}
	}
	
}
