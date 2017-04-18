package com.niit.ezone.controller;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ezone.dao.UserDAO;
import com.niit.ezone.model.Product;
import com.niit.ezone.model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class HomeController {
	
	private static final Logger log=LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private HttpSession session;
	
	@Autowired
	User user;
		
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserController userController;
	
		
	/*@RequestMapping("/")
	public ModelAndView showHome()
	{
		ModelAndView mv = new ModelAndView("/Home");		
		return mv;
		
	}*/
	

	@RequestMapping("/Home")
	public ModelAndView showHomePage()
	{
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("msg","welcome to shopping cart");
		return mv;
		
	}
	@RequestMapping("/Login")
	public ModelAndView showLoginPage()
	{
		System.out.println("Clicked on login link");
		ModelAndView mv= new ModelAndView("/Login");
		mv.addObject("isUserClickedLogin","true");
		return mv;
	}
	
	@RequestMapping("/Registration")
	public ModelAndView showRegistrationPage()
	{
		log.debug("Clicked on Registraion link");
		ModelAndView mv = new ModelAndView("/Registration","command", new User());
		return mv;
	}
	
	@RequestMapping("/AboutUs")
	public ModelAndView showAboutUsPage()
	{
		log.debug("Clicked on AboutUs link");
		ModelAndView mv = new ModelAndView("/AboutUs");
		mv.addObject("isUserClickedAboutUs","true");
		return mv;
	}
	
	@RequestMapping("/ContactUs")
	public ModelAndView showContactUsPage()
	{
		log.debug("Clicked on ContactUs link");
		ModelAndView mv = new ModelAndView("/ContactUs");
		mv.addObject("isUserClickedContactUs","true");
		return mv;
	}
	
	@RequestMapping("/Product")
	public ModelAndView showProduct_menuPage(@ModelAttribute Product product)
	{
		ModelAndView mv = new ModelAndView("/Product");
		mv.addObject("isUserClickedAddProduct","true");
		return mv;
	}
	
	
	@RequestMapping(value = "/editUser", method = RequestMethod.GET)
	@Transactional
	public ModelAndView showEditProduct(@RequestParam("editrow")String id,@ModelAttribute User user)
	{
		user=userDAO.getUserById(id);
		log.debug("In Mv Before Update");
		ModelAndView mv = new ModelAndView("/ValidateReg","command", new User());
		List<User> userList = userController.fetchUserList();
		user = userDAO.getUserById(id);
		mv.addObject("successList",userList);
		mv.addObject("L", user);
		mv.addObject("UID", id);
		mv.addObject("FNAME", user.getFname());
		mv.addObject("LNAME", user.getLname());
		mv.addObject("UMAIL", user.getEmail());
		mv.addObject("PASS", user.getPassword());
		mv.addObject("CPASS", user.getConfirmpassword());
		session.setAttribute("updateUser", "updated");
		session.removeAttribute("addUser");
		return mv;
	}
	
	@RequestMapping("/Logout")
	public ModelAndView Logout()
	{
		ModelAndView mv = new ModelAndView("/Login");
		session.removeAttribute("UID");
		return mv;
	}
	
	@RequestMapping("/ProductDescription")
	public ModelAndView showproddesc()
	{
		ModelAndView mv = new ModelAndView("/ProductDescription");		
		return mv;
		
	}
	
	@RequestMapping("/Admin")
	public ModelAndView Admin()
	{
		ModelAndView mv = new ModelAndView("/Admin");
		session.removeAttribute("UID");
		return mv;
	}
}
