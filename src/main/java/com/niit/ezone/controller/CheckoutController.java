package com.niit.ezone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ezone.dao.CartDAO;
import com.niit.ezone.dao.CheckoutDAO;
import com.niit.ezone.model.Checkout;
import com.niit.ezone.model.MyCart;

public class CheckoutController {
	@Autowired
	Checkout checkout;
	@Autowired
	CheckoutDAO checkoutDAO;
	@Autowired
	private UserController userController;
	
	@Autowired
	MyCart mycart;
	@Autowired
	CartDAO cartdao;
//	@Transactional
	public List<Checkout> showlist()
	{
		String id= userController.getLogid();

		List<Checkout> list= new ArrayList<Checkout>();
		list.addAll(checkoutDAO.getlist(id));
		return list;
	}
	
//	@RequestMapping("/checkout")
//	public String gotoCkOut(@ModelAttribute("ckout")Checkout ckout)
//	{
//		return "checkout";
//	}
	
//	@Transactional
	@RequestMapping("/checkout")
	public ModelAndView gocheckout(@ModelAttribute("ckout")Checkout ckout)
	{
		
		String id= userController.getLogid();
		checkout.setUser_id(id);

		String idresult=checkoutDAO.checktableforempty(id);
		if(idresult=="0")
		{
			ModelAndView mv1= new ModelAndView("/checkout","command", new Checkout());
			return mv1;
		}
		else
		{
			ModelAndView mv=new ModelAndView("/checkoutdetails","command",new Checkout());
			List<Checkout> list=showlist();
			mv.addObject("printdetails", list);
			return mv;
			
		}
			
		
	}
//	@Transactional
	@RequestMapping("/finalcheckout")
	public ModelAndView gotoaddcheckout(@ModelAttribute Checkout checkout)
	{
		String id= userController.getLogid();
		checkout.setUser_id(id);
		checkout.setId(ThreadLocalRandom.current().nextInt(100, 1000000 + 1));
		checkoutDAO.Save(checkout);
		ModelAndView mv=new ModelAndView("/checkoutdetails","command",new Checkout());
		List<Checkout> list=showlist();
		mv.addObject("printdetails", list);
		return mv;
	}

//	@Transactional
	@RequestMapping("/generatebill")
	public ModelAndView generatebill()
	{
		String id= userController.getLogid();
		boolean b=checkoutDAO.execute(id);
		List<MyCart>list=checkoutDAO.getallcartdetails(id);
		List<Checkout> list1=checkoutDAO.getlist(id);
		ModelAndView mv= new ModelAndView("/generatebilldetails");
		mv.addObject("cartdetails",list);
		mv.addObject("checkoutdetails", list1);
		return mv;
	}
}
