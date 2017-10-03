package ril.com.onlineshopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ril.com.onlineshopping.exception.ProductNotFoundException;
import ril.com.shoppingbackend.dao.CategoryDAO;
import ril.com.shoppingbackend.dao.ProductDAO;
import ril.com.shoppingbackend.dto.Category;
import ril.com.shoppingbackend.dto.Product;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index", "/onlineshopping/", "/onlineshopping" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		logger.info("Inside page controller index method this is for Info");
		logger.debug("Inside page controller index method this is fordebug");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickHome", true);
		return mv;

	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "About");
		mv.addObject("userClickAbout", true);
		return mv;

	}
	@RequestMapping(value = "/login")
	public ModelAndView login(@RequestParam(name="error",required=false)String error) {
		ModelAndView mv = new ModelAndView("login");
		
		if(error!=null)
		{
			mv.addObject("message", "Invalid Login");
		}
		mv.addObject("title", "Login");
		return mv;

	}

	@RequestMapping(value = "/view")
	public ModelAndView listproduct() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "ListProducts");
		mv.addObject("userClickView", true);
		return mv;

	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Contact");
		mv.addObject("userClickContact", true);
		return mv;

	}

	/*
	 * Methods to load all the products based on the category...
	 */
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");
		mv.addObject("categories", categoryDAO.list());
		mv.addObject("userClickAllProducts", true);
		return mv;

	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		// CategoryDAO to fetch single category
		Category category = null;
		category = categoryDAO.get(id);
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", category.getName());
		// passing the all category
		mv.addObject("categories", categoryDAO.list());
		// passing the sigle category.
		mv.addObject("category", category);
		mv.addObject("userClickCategoryProducts", true);
		return mv;

	}

	/*
	 * 
	 * Viewing a single product...
	 */
	@RequestMapping(value = "/show/{id}/product")
	public ModelAndView showSinglProduct(@PathVariable("id") int id) throws ProductNotFoundException {

		ModelAndView mv = new ModelAndView("page");
		Product product = productDAO.get(id);
		if (product == null)
			throw new ProductNotFoundException();
		mv.addObject(product);

		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		// --------------------------
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("userClickShowProduct", true);
		return mv;
	}
	
	
	
	@RequestMapping(value = "/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("title", "403 - Access Denied ");
		mv.addObject("errorTitle", " Aha ! Caught You. ");
		mv.addObject("errroDescription", "You Are not Authorized to view this page ");
		
		return mv;

	}


}
