package ril.com.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ril.com.shoppingbackend.dao.CategoryDAO;
import ril.com.shoppingbackend.dto.Category;

@Controller
public class PageController {
	@Autowired 
	private CategoryDAO categoryDAO;
	@RequestMapping(value={"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Home");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;
		
	}
	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout",true);
		return mv;
		
	}
	
	@RequestMapping(value="/view")
	public ModelAndView listproduct()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "ListProducts");
		mv.addObject("userClickView",true);
		return mv;
		
	}
	
	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;
		
	}
	
	/*
	 * Methods to load all the products based on the category...
	 * */
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts()
	{
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts",true);
		return mv;
		
	}
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id")int id)
	{
		//CategoryDAO to fetch single category
				Category category=null;
				category=categoryDAO.get(id);
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title",category.getName());
		//passing the all category
		mv.addObject("categories", categoryDAO.list());
		//passing the sigle category.
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts",true);
		return mv;
		
	}

}
