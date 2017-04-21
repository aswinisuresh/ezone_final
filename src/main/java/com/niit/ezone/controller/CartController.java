package com.niit.ezone.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ezone.dao.CartDAO;
import com.niit.ezone.dao.ProductDAO;
import com.niit.ezone.dao.impl.ProductDAOImpl;
import com.niit.ezone.model.MyCart;
import com.niit.ezone.model.Product;
import com.niit.ezone.model.User;

@Controller
public class CartController {
	
	@Autowired
	private HttpSession session;
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private UserController userController;
	
	@Autowired
	private MyCart myCart;
	
	@Autowired
	private Product product;
	

	@Autowired
	private CartDAO cartDAO;
	
	@Transactional
	@RequestMapping(value="/MyCart")
	public ModelAndView showMyCart()
	{
		ModelAndView mv = new ModelAndView("/MyCart");
		String uid = userController.getLogid();
		System.out.println(uid);
		
	List<MyCart> showcartlist=cartDAO.getAllCartDetails(uid);
	System.out.println(showcartlist);
		mv.addObject("showcartlist", showcartlist );
		mv.addObject("myCart",myCart);
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="/validate_add_cart")
	public ModelAndView validateAddToCart(@RequestParam("prodname")String prodname,@ModelAttribute MyCart myCart)
	{
		ModelAndView mv;
		String id = userController.getLogid();
		if(id==null)
		{
			mv = new ModelAndView("/validatelogin","command",new User());
			return mv;
		}
		else
		{
			mv = new ModelAndView("redirect:/MyCart");
			long d = System.currentTimeMillis();
			Date today = new Date(d);
			Product product = productDAO.getProductByName(prodname);
			myCart.setCartid(ThreadLocalRandom.current().nextInt(100,1000000+1));
			myCart.setStatus("N");
			myCart.setProdquan(1);
			myCart.setDateadded(today);
			myCart.setProdname(prodname);
			myCart.setProdcost(product.getProdcost());
			myCart.setId(id);
			myCart.setSum(cartDAO.getProductSum((int) myCart.getProdcost(),myCart.getProdquan()));
			cartDAO.save( myCart);
			return mv;
		}
	}
	
	@Transactional
	@RequestMapping(value="increasequantity/{id}")
	public ModelAndView validateEditCartAdd(@PathVariable("id")int id,@ModelAttribute MyCart myCart)
	{
		ModelAndView mv = new ModelAndView("redirect:/MyCart");
		myCart = cartDAO.getMyCartById(id);
		int qty = myCart.getProdquan();
		qty++;
		myCart.setProdquan(qty);
		myCart.setSum(cartDAO.getProductSum((int) myCart.getProdcost(), qty));
		cartDAO.update(myCart);
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="decreasequantity/{id}")
	public ModelAndView validateEditCartLess(@PathVariable("id")int id,@ModelAttribute MyCart myCart)
	{
		ModelAndView mv = new ModelAndView("redirect:/MyCart");
		myCart = cartDAO.getMyCartById(id);
		int qty = myCart.getProdquan();
		if(qty<=1)
		{
			myCart.setProdquan(qty);
		}
		else
		{
			qty--;
			myCart.setProdquan(qty);
		}
		myCart.setSum(cartDAO.getProductSum((int) myCart.getProdcost(), qty));
		cartDAO.update(myCart);
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="/deletecart")
	public ModelAndView validateDeleteCart(@RequestParam("id")int id)
	{
		ModelAndView mv = new ModelAndView("redirect:/MyCart");
		MyCart myCart = cartDAO.getMyCartById(id);
		cartDAO.delete(myCart);
		return mv;
	}
	
 

}