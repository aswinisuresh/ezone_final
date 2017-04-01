/*package com.niit.ezone.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ezone.dao.ProductDAO;
import com.niit.ezone.model.Product;

public class AdminController {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("/admin")
	public ModelAndView showAdminPage()
	{
		ModelAndView mv = new ModelAndView("/Admin");
		return mv;
	}
	
	@RequestMapping("/add")
	public ModelAndView showAddPage()
	{
		
		ModelAndView mv = new ModelAndView("/AddProduct","command", new Product());
		mv.addObject("isUserClickedAdd", "true");
		return mv;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	@Transactional
	public ModelAndView EditProduct(@RequestParam("edit")int id,Product product)
	{
		product = productDAO.getProductByID(id);
		System.out.println("In Mv Before Edit");
		ModelAndView mv = new ModelAndView("/EditProduct","command", new Product());
		mv.addObject("PID", id);
		mv.addObject("PNAME", product.getProdname());
		mv.addObject("PDESC", product.getProddesc());
		mv.addObject("PCOST", product.getProdcost());
		mv.addObject("PQTY", product.getProdquan());
		System.out.println(product.getProddesc());
		return mv;
	}
}
*/