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
import com.niit.ezone.dao.CategoryDAO;
import com.niit.ezone.model.Category;


@Controller
public class CategoryController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Transactional
	@RequestMapping("/selAddCategory")
	public ModelAndView clickedAddCategory()
	{
		ModelAndView mv= new ModelAndView("/AddCategory", "command", new Category());
		return mv;
	}
	
	@Transactional
	@RequestMapping("/validateAddCategory")
	public ModelAndView showAddCategoryPage(@ModelAttribute Category category)
	{	
		
		categoryDAO.saveCategory(category);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("success","categoryadded");
		return mv;
	}

	@Transactional
	@RequestMapping("/selEditCategory")
	public ModelAndView showCategoryEdit(Map<String, Object> map)
	{
		List<Category> catList=categoryDAO.getAllCategory();
		map.put("caList", catList );
		ModelAndView mv=new ModelAndView("/EditCategory",map);
		return mv;
	}
	
	@Transactional
	@RequestMapping("/findCategory")
	public ModelAndView findCategory(@RequestParam("catid") int catid, Map<String, Object> map)
	{
		Category ca=categoryDAO.getCategoryByID(catid);
		ModelAndView mv=new ModelAndView("/EditCategory1","command", new Category() );
		mv.addObject("caFound", ca);
		return mv;
	}
	
	@Transactional
	@RequestMapping(value="/EditCategory",  method = RequestMethod.POST)
	public ModelAndView editCategoryFunction(@ModelAttribute Category category)
	{
		System.out.println("Inside Edit Category");
		categoryDAO.updateCategory(category);
		ModelAndView mv= new ModelAndView("/Admin");
		mv.addObject("msg", "Category Edited");
		return mv;
	}
	
	
	
	@Transactional
	@RequestMapping("/selDeleteCategory")
	public ModelAndView deleteCategoryFunction()
	{
		ModelAndView mv=new ModelAndView("/DeleteCategory");
		return mv;
	}
	
	@Transactional
	@RequestMapping("/DeleteCategory")
	public ModelAndView deleteCategory(@RequestParam("catid") int catid)
	{
		categoryDAO.deleteCategory(catid);
		ModelAndView mv=new ModelAndView("/Admin");
		return mv;
	}
}
