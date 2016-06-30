package com.niit.shopcartfrontend.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopcart.dao.CategoryDAO;
import com.niit.shopcart.model.Category;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	

	@RequestMapping("/addCategory")
	public ModelAndView addCategory(@RequestParam(value = "categoryName") String name,
			@RequestParam(value = "categoryDescription") String description) {

		System.out.println("addCategory");
		String message = "Successfully created";
		ModelAndView mv = new ModelAndView("/success");
		mv.addObject("message", message);

		return mv;
	}
	@RequestMapping("/getAllCategories")
	public ModelAndView getAllCategories() {

		System.out.println("getAllCategories");
		
		List<Category> categoryList = categoryDAO.list();
		
		ModelAndView mv = new ModelAndView("/categoryList");
		mv.addObject("categoryList", categoryList);

		return mv;
	}
}
