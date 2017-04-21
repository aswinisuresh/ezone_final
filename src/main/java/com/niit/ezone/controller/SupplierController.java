package com.niit.ezone.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.niit.ezone.dao.SupplierDAO;
import com.niit.ezone.model.Supplier;
@Controller
public class SupplierController {

	@Autowired
	private SupplierDAO supplierDAO;
	
	//@Transactional
	@RequestMapping("/selAddSupplier")
	public ModelAndView clickedAddSupplier()
	{
		ModelAndView mv= new ModelAndView("/AddSupplier", "command", new Supplier());
		return mv;
	}
	
	//@Transactional
	@RequestMapping(value="/validateAddSupplier",method=RequestMethod.POST)
	public ModelAndView showAddSupplierPage(@ModelAttribute Supplier supplier)
	{	
		
		supplierDAO.saveSupplier(supplier);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("success","supplieradded");
		return mv;
	}
	
	//@Transactional
	@RequestMapping("/selEditSupplier")
	public ModelAndView showSupplierEdit(Map<String, Object> map)
	{
		List<Supplier> suppList=supplierDAO.getAllSupplier();
		map.put("supList", suppList );
		ModelAndView mv=new ModelAndView("/EditSupplier",map);
		return mv;
	}
	
	//@Transactional
	@RequestMapping("/findSupplier")
	public ModelAndView findCategory(@RequestParam("suppid") int suppid, Map<String, Object> map)
	{
		Supplier supp=supplierDAO.getSupplierByID(suppid);
		ModelAndView mv=new ModelAndView("/EditSupplier1","command", new Supplier() );
		mv.addObject("suppFound", supp);
		return mv;
	}
	
	//@Transactional
	@RequestMapping(value="/EditSupplier",  method = RequestMethod.POST)
	public ModelAndView editSupplierFunction(@ModelAttribute Supplier supplier)
	{
		System.out.println("Inside Edit Supplier");
		supplierDAO.updateSupplier(supplier);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Supplier Edited");
		return mv;
	}
	

	//@Transactional
	@RequestMapping("/selDeleteSupplier")
	public ModelAndView deleteSupplierFunction(Map<String, Object> map)
	{	List<Supplier> suppList=supplierDAO.getAllSupplier();
		map.put("supList",suppList );
		ModelAndView mv=new ModelAndView("/DeleteSupplier");
		return mv;
	}
	
	//@Transactional
	@RequestMapping("/DeleteSupplier")
	public ModelAndView deleteSupplier(@RequestParam("suppid") int suppid)
	{
		supplierDAO.deleteSupplier(suppid);
		ModelAndView mv=new ModelAndView("/Admin");
		return mv;
	}
	
}