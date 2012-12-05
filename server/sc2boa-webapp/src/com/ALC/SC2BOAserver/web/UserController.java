package com.ALC.SC2BOAserver.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ALC.SC2BOAserver.dao.SC2BOADAO;
import com.ALC.SC2BOAserver.entities.User;
import com.ALC.SC2BOAserver.util.DEBUG;


@Controller
//@RequestMapping("/userRegistration.htm")
//@SessionAttributes("user")
public class UserController {

	private SC2BOADAO userService;

	@Autowired
	public void setSC2BOADAO(SC2BOADAO userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register(ModelMap model) {
		DEBUG.d("register new user page");
		User user = new User();
		model.addAttribute("user", user);
		return new ModelAndView("register", "user", user);
	}
	
	@RequestMapping(value="/login")
	public ModelAndView login(ModelMap model) {
		DEBUG.d("register login user page");
		User user = new User();
		model.addAttribute("user", user);
		return new ModelAndView("login", "user", user);
	}

	
	
}
