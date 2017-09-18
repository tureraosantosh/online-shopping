package ril.com.shoppingbackend.test;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import ril.com.shoppingbackend.dao.CategoryDAO;
import ril.com.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private static Category category;
	@BeforeClass 
	public static void init()
	{
		context =new AnnotationConfigApplicationContext();
		context.scan("ril.com.shoppingbackend"); 
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	
	}
	
	/*@Test
	public void testAddCategory()
	{
		category=new Category();
		category.setName("Computer");
		category.setDescription("This is some description for Computer!");
		category.setImageURL("CAT_3.png");
		assertEquals("successfully added the category ",true,categoryDAO.add(category));
		
	}*/

	
	/*@Test
	public void testGetCategory()
	{
		category=categoryDAO.get(3);
		assertEquals("successfully fetched Single Category ", "Radio",category.getName());
	}*/
	
	/*@Test
	public void testUpdateCategory()
	{
		
		category=categoryDAO.get(3);
		category.setName("TV");
		assertEquals(" Successfully updated a single category in the table ",true, categoryDAO.update(category));
	}*/
	
	
	/*@Test
	public void testDeleteCategory()
	{
		 category=categoryDAO.get(3);
		 assertEquals("Successfully deleted a single category ", true,categoryDAO.delete(category));
	}*/
	
	/*@Test
	public void  ListCategory()
	{
		assertEquals("Successfully fetched query ",3, categoryDAO.list().size());
	}*/
	
	
	@Test
	public void testCRUCDCategory()
	{
		
		//adding Category
		category=new Category();
		category.setName("Radio");
		category.setDescription("This is some description for RAdio!");
		category.setImageURL("CAT_1.png");
		assertEquals("successfully added the category ",true,categoryDAO.add(category));
		
		category=new Category();
		category.setName("Laptop");
		category.setDescription("This is some description for Laptop!");
		category.setImageURL("CAT_2.png");
		assertEquals("successfully added the category ",true,categoryDAO.add(category));
		
		
		category=new Category();
		category.setName("Television");
		category.setDescription("This is some description for Television!");
		category.setImageURL("CAT_3.png");
		assertEquals("successfully added the category ",true,categoryDAO.add(category));
		
		
		category=new Category();
		category.setName("Computer");
		category.setDescription("This is some description for Computer!");
		category.setImageURL("CAT_4.png");
		assertEquals("successfully added the category ",true,categoryDAO.add(category));
		
		//Fetching and updating category
		
		category=categoryDAO.get(3);
		category.setName("TV");
		assertEquals(" Successfully updated a single category in the table ",true, categoryDAO.update(category));
	
		
		//Delete the category
		 
		 assertEquals("Successfully deleted a single category ", true,categoryDAO.delete(category));
		 
		 
		 //Fetching the list
		 assertEquals("Successfully fetched query ",3, categoryDAO.list().size());
	
	}
	
}
