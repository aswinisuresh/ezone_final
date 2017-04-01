package com.niit.ezone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ezone.dao.ProductDAO;
import com.niit.ezone.dao.UserDAO;
import com.niit.ezone.model.User;
import com.niit.ezone.model.Product;
import com.niit.ezone.model.Supplier;


@Controller
public class UserController {
	
	private String logid;
	private String regid;
	
	@Autowired
	User user;
	
	
	@Autowired
	UserDAO userDAO;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	ProductDAO productDAO;
	
	/*@RequestMapping("/validateLogin")
	public ModelAndView userlogin(@RequestParam("id") String uid,@RequestParam("password") String psw)
	{
		//log.debug("Start of method userlogin");
		User user=userDAO.getUserById(uid);
		ModelAndView mv;
		String pwd=user.getPassword();
		if(pwd.equals(psw))
		{
			if(user.getRole().equals("ROLE_ADMIN"))
			{
				mv=new ModelAndView("/Home");
				session.setAttribute("AdminMsg","AdminLoggedIn");
				session.setAttribute("UserName", user.getId());
				session.setAttribute("loginMsg", null);
			}
			else
			{
				mv=new ModelAndView("/Home");
				session.setAttribute("UserName", user.getId());
				session.setAttribute("loginMsg", null);
			}
		}
		else
		{
			mv=new ModelAndView("/Home");
			session.setAttribute("loginMsg", "notloggedIn");
			mv.addObject("msg","Invlaid Login");
		}
		//log.debug("End of method userlogin");
		return mv;
		session.setAttribute("UserMsg","LoggedIn");
	}*/
		
	@Transactional
	@RequestMapping(value="/validateLogin",method=RequestMethod.POST)
	public ModelAndView validation(@ModelAttribute User user, @RequestParam("id") String uid,@RequestParam("password")String psw)
	{
		ModelAndView mv;
		user = userDAO.validateLoginCredentials(uid, psw);
		if(user==null)
		{
			mv = new ModelAndView("/validateLogin","command",new User());
			mv.addObject("compareF", "Wrong Credentials");
		}
		else
		{
			if(user.getRole().equals("Role_Admin"))
			{
				session.setAttribute("showAdmin", true);
			}
			mv = new ModelAndView("/ValidateRegister","command",new User());
			logid=uid;
			mv.addObject("compareT", "Validation Success");
			session.setAttribute("LogList", "true");
			session.setAttribute("UID", "Welcome:" +uid);
			session.setAttribute("SUCC","Done");
		}
		return mv;
	}
	
	@Transactional
	@RequestMapping("/validateregister")
	public ModelAndView validationlogin(@ModelAttribute User user,@RequestParam("password")String psw,@RequestParam("id") String uid,@RequestParam("fname") String fname,@RequestParam("lname")String lname,@RequestParam("email") String mail,@RequestParam("confirmpassword")String cpsw)
	{
		String compareEmail = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		boolean b = mail.matches(compareEmail);
		String patternPSW = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		boolean b1 = psw.matches(patternPSW);
		boolean b2 = psw.equals(cpsw);
		System.out.println(b2);
		ModelAndView mv = new ModelAndView("/ValidateRegister","command",new User());
		mv.addObject("FNAME", fname);
		mv.addObject("LNAME", lname);
		if(uid=="")
		{
			System.out.println("In if 1");
			mv.addObject("RUID","User Name Not Entered");
		}
		if(psw=="")
		{
			System.out.println("In if 2");
			mv.addObject("RPSW","Password Not Entered");
		}
		if(cpsw=="")
		{
			System.out.println("In if 3");
			mv.addObject("RCPSW","Confirm Password Not Entered");
		}
		if(mail=="")
		{
			System.out.println("In if 4");
			mv.addObject("RMAIL","Email Not Entered");
		}
		if(fname=="")
		{
			System.out.println("In if 5");
			mv.addObject("RFNAME","First Name Not Entered");
		}
		if(lname=="")
		{
			System.out.println("In if 6");
			mv.addObject("RLNAME","Last Name Not Entered");
		}
		if(fname.equals(uid))
		{
			System.out.println("In if 7");
			mv.addObject("compareUF", "First Name & User Name Must Not Be Same");
		}
		if(b2!=true)
		{
			System.out.println("In if 8");
			mv.addObject("compareP", "Password & Confirm Password Must Be Same");
		}
		if(b1!=true)
		{
			System.out.println("In if 9");
			mv.addObject("comparePSW", "Password Must Be Greater Than 8 Characters.It Should Conatin One Symbol One Capital Letter One Small Letter One Number and No Space");
		}
		if(b!=true)
		{
			System.out.println("In if 10");
			mv.addObject("compareE", "Email Is Not Properly Entered Make Sure (@) & (.) is used Example : example@abc.com");
		}
		else
		{
			System.out.println("In Else");
			mv.addObject("success", "Hi " );
			user.setRole("Role_User");
			userDAO.saveUser(user);
			List<User> userList = fetchUserList();
			mv.addObject("successList", userList);
			regid=uid;
			user = userDAO.getUserById(regid);
			mv.addObject("L", user);
			session.removeAttribute("updateUser");
			session.setAttribute("SUCC","Welcome :" + fname + " " + lname);
			session.setAttribute("UID", "Done");
			session.setAttribute("RegList", "true");
		}
		return mv;
	}

	@Transactional
	@RequestMapping("ulist")
	public ModelAndView showUserListLogin()
	{
		ModelAndView mv = new ModelAndView("/ValidateReg","command",new User());
		List<User> userList = fetchUserList();
		user = userDAO.getUserById(logid);
		mv.addObject("successList", userList);
		mv.addObject("L", user);
		session.removeAttribute("updateUser");
		return mv;
	}
	@Transactional
	@RequestMapping("ulist1")
	public ModelAndView showUserListRegister()
	{
		ModelAndView mv = new ModelAndView("/ValidateReg","command",new User());
		List<User> userList = fetchUserList();
		user = userDAO.getUserById(regid);
		mv.addObject("successList", userList);
		mv.addObject("L", user);
		session.removeAttribute("updateUser");
		return mv;
	}
	public List<User> fetchUserList()
	{
		List<User> list = new ArrayList<User>(userDAO.getAllUsers());
		System.out.println(list.get(0));
		return list;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout()
	{
		ModelAndView mv = new ModelAndView("/index");
		session.removeAttribute("UID");
		session.removeAttribute("SUCC");
		session.removeAttribute("showAdmin");
		session.removeAttribute("LogList");
		session.removeAttribute("RegList");
		return mv;
	}
	
	/*@RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
	@Transactional
	public ModelAndView validateDeleteSupplier(@RequestParam("deleterow")String id,User user)
	{
		user = userDAO.getUserById(id);
		System.out.println("In Mv Before Delete");
		ModelAndView mv = new ModelAndView("/ValidateReg","command",new Supplier());
		userDAO.deleteUser(user);
		List<User> userList = fetchUserList();
		mv.addObject("successList",userList);
		mv.addObject("successDelete", "Supplier Deleted Successfully");
		return mv;
	}*/
	
	@RequestMapping(value = "/validateUserEdit", method = RequestMethod.POST)
	@Transactional
	public ModelAndView validateEditUser(@ModelAttribute User user)
	{
		System.out.println("In Mv Before Update");
		ModelAndView mv = new ModelAndView("/ValidateReg","command", new User());
		user.setRole("Role_User");
		userDAO.updateUser(user);
		List<User> userList = fetchUserList();
		mv.addObject("successList",userList);
		mv.addObject("successUpdate", "User Updated Successfully");
		session.removeAttribute("updateUser");
		return mv;
	}
	
	@Transactional
	@RequestMapping("/ProductView")
	public ModelAndView viewproduct(Map<String, Object> map)
	{
		
		String path="C:\\DevOps software\\Mars-workspace\\FinalDevProject\\ezone\\src\\main\\webapp\\resources\\images\\";
		List<Product> prodList=productDAO.getAllProduct();
		map.put("prList", prodList );
		map.put("path", path);
		ModelAndView mv=new ModelAndView("/ProductView",map);
		mv.addObject("isUserClickedAddToCart","true");
		return mv;
	}
	
	@RequestMapping("/index")
	public ModelAndView showindex()
	{
		ModelAndView mv = new ModelAndView("ProductView");
		
		return mv;
		
	}
	
	
}
