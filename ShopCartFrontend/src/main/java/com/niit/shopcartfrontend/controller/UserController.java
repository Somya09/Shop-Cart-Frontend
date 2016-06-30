package com.niit.shopcartfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopcart.dao.UserDAOImpl;

@Controller
public class UserController {
	 @Autowired
		UserDAOImpl userDAO;


		@RequestMapping("/isValidUser")
		public ModelAndView showMessage(@RequestParam(value = "id") String id,
				@RequestParam(value = "password") String password,@RequestParam(value = "isAdmin") String isAdmin) {
			System.out.println("in controller");

			String message;
			ModelAndView mv ;
			if (userDAO.isValidUser(id, password, true))
			{
				message = "Valid credentials";
				 mv = new ModelAndView("adminHome");
			} else {
				message = "Invalid credentials";
				 mv = new ModelAndView("login");
			}

			//ModelAndView mv = new ModelAndView("success");
			mv.addObject("message", message);
			mv.addObject("id", id);
			// mv.addObject("password", password);
			return mv;
		}
		@RequestMapping("/")
		public ModelAndView index()
		{
			ModelAndView  mv = new ModelAndView("index");
			return mv;
		}

}
