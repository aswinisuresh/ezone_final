package com.niit.ezone.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.niit.ezone.dao.ProductDAO;
import com.niit.ezone.model.Product;


@Controller
public class ProductController {
	private static final Logger log=LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductDAO productDAO;
	
	@Transactional
	@RequestMapping("/selAddProduct")
	public ModelAndView clickedAddProduct()
	{
		ModelAndView mv= new ModelAndView("/AddProduct", "command", new Product());
		return mv;
	}
	
//@Transactional
	@RequestMapping(name="/validateAddProduct",method=RequestMethod.POST)
	public ModelAndView addProductFunction(@ModelAttribute Product product,HttpServletRequest request)
	{
	
		productDAO.saveProduct(product);
		
		String path="C:\\DevOps software\\Mars-workspace\\FinalDevProject\\ezone\\src\\main\\webapp\\resources\\images\\";
		path=path+String.valueOf(product.getProdid())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=product.getPimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		
		ModelAndView mv = new ModelAndView("/Admin");
		mv.addObject("msg","Product Added");
		return mv;
	}
	
//	@Transactional
	@RequestMapping("/selEditProduct")
	public ModelAndView showProductEdit(Map<String, Object> map)
	{
		List<Product> prodList=productDAO.getAllProduct();
		map.put("prList", prodList );
		ModelAndView mv=new ModelAndView("/EditProduct",map);
		return mv;
	}
	
//	@Transactional
	@RequestMapping("/findProduct")
	public ModelAndView findProduct(@RequestParam("prodid") int prodid, Map<String, Object> map)
	{
		Product pr=productDAO.getProductByID(prodid);
		ModelAndView mv=new ModelAndView("/EditProduct1","command", new Product() );
		mv.addObject("prFound", pr);
		return mv;
	}
	
	//@Transactional
	@RequestMapping(value="/EditProduct",  method = RequestMethod.POST)
	public ModelAndView editProductFunction(@ModelAttribute Product product)
	{
		System.out.println("Inside Edit Product");
		productDAO.updateProduct(product);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Product Edited");
		return mv;
	}
	
	//@Transactional
	@RequestMapping("/selDeleteProduct")
	public ModelAndView showProductDelete(Map<String, Object> map)
	{
		List<Product> prodList=productDAO.getAllProduct();
		map.put("prList", prodList );
		ModelAndView mv=new ModelAndView("/DeleteProduct",map);
		return mv;
	}
	
	
		
	//@Transactional
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam("prodid") int prodid)
	{
		productDAO.deleteProduct(prodid);
		ModelAndView mv=new ModelAndView("/Admin","command", new Product());
		return mv;
	}
	
@RequestMapping("/selProductView")
	public ModelAndView viewProduct(Map<String, Object> map)
	{	String path="C:\\DevOps software\\Mars-workspace\\FinalDevProject\\ezone\\src\\main\\webapp\\resources\\images\\";
		List<Product> prodList=productDAO.getAllProduct();
		map.put("prList", prodList );
		map.put("path", path);
		ModelAndView mv=new ModelAndView("/ProductView",map);
		return mv;
	}
	

	
	
	
}
