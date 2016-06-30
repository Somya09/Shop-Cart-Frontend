package com.niit.shopcartfrontend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopcart.dao.SupplierDAO;
import com.niit.shopcart.model.Supplier;

@Controller
public class SupplierController {
	@Autowired
	private SupplierDAO supplierDAO;

	@RequestMapping("/getAllSuppliers")
	public ModelAndView getAllSuppliers() {

		System.out.println("getAllSuppliers");
		
		List<Supplier> supplierList = supplierDAO.list();
		
		ModelAndView mv = new ModelAndView("/supplierList");
		mv.addObject("supplierList", supplierList);

		return mv;
	}
}
