package com.niit.shopcartbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shopcartbackend.dao.CategoryDAOImpl;
import com.niit.shopcartbackend.dao.ProductDAOImpl;
import com.niit.shopcartbackend.dao.SupplierDAOImpl;
import com.niit.shopcartbackend.model.Category;
import com.niit.shopcartbackend.model.Product;
import com.niit.shopcartbackend.model.Supplier;

@Controller
public class ProductController {
	@Autowired
	private ProductDAOImpl productDAOImpl;
	
	@Autowired 
	private CategoryDAOImpl categoryDAOImpl;
	
	@Autowired
	private SupplierDAOImpl supplierDAOImpl;
	
	
	@RequestMapping(value="/product", method=RequestMethod.POST)
	public String listProducts(Model model){
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productList", this.productDAOImpl.list());
		model.addAttribute("categoryList", this.categoryDAOImpl.list());
		model.addAttribute("supplierList", this.supplierDAOImpl.list());
		return "product";
	}
	
	@RequestMapping(value="product/view/all", method=RequestMethod.POST)
	public String showProducts(Model model){
		model.addAttribute("product", new Product());
		model.addAttribute("category", new Category());
		model.addAttribute("supplier", new Supplier());
		model.addAttribute("productList", this.productDAOImpl.list());
		model.addAttribute("categoryList", this.categoryDAOImpl.list());
		model.addAttribute("supplierList", this.supplierDAOImpl.list());
		return "showAllP";
	}
	
	
	@RequestMapping(value="/product/add", method=RequestMethod.POST)
    public String addProduct(@ModelAttribute("product") Product product){
		Category category = categoryDAOImpl.getByName(product.getCategory().getName());
		System.out.println("\n\n\n CID:"+category.getId());
		Supplier supplier = supplierDAOImpl.getByName(product.getSupplier().getName());
		System.out.println("\n\n\n SID:"+supplier.getId());
		product.setCategory_id(category.getId());
		product.setSupplier_id(supplier.getId());
		product.setCategory(category);
		product.setSupplier(supplier);
		productDAOImpl.saveOrUpdate(product);
		return "redirect:/product";
	}
	
	
	
	@RequestMapping(value="product/remove/{id}")
	public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception{
		try{
			productDAOImpl.delete(id);
			model.addAttribute("message", "Successfully Added");
		}
		catch(Exception e){
			model.addAttribute("message", e.getMessage());
		}
		return "redirect:/product";
	}
	
	@RequestMapping(value="product/edit/{id}")
	public String editProduct(@PathVariable("id") String id, Model model){
		System.out.println("edit product");
		model.addAttribute("product", this.productDAOImpl.get(id));
		model.addAttribute("productList", this.productDAOImpl.list());
		model.addAttribute("categoryList", this.categoryDAOImpl.list());
		model.addAttribute("supplierList", this.supplierDAOImpl.list());
		return "product";
	}
}
