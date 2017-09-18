package ril.com.shoppingbackend.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ril.com.shoppingbackend.dao.ProductDAO;
import ril.com.shoppingbackend.dto.Product;

public class ProductTestCase {
private static AnnotationConfigApplicationContext context;
private static ProductDAO productDAO;
private Product product;


@BeforeClass
public static void init()
{
	context=new AnnotationConfigApplicationContext();
	context.scan("ril.com.shoppingbackend");
	context.refresh();
	productDAO=(ProductDAO) context.getBean("productDAO");
}
/*@Test
public void testCRUDProduct()
{
	//create operation
	
	product=new Product();
	product.setName("Oppo Selfie S7");
	product.setBrand("OPPO");
	product.setDescription("This is some description of oppo mobile is the good ");
	product.setUnitPrice(29000);
	product.setActive(true);
	product.setCategoryId(3);
	product.setSupplierId(3);
	assertEquals(" Something Went Wrong while inserting a new product ! ",true,productDAO.add(product));
//reading and updating product
	product=productDAO.get(2);
	product.setName("Samsung Galaxy S7 ");
	assertEquals(" Something Went Wrong while updateing a new product ! ",true,productDAO.update(product));
	
	
	//Deleting a product 
	assertEquals(" Something Went Wrong while deleting a new product ! ",true,productDAO.delete(product));
	
	//list of products
	assertEquals(" Something Went Wrong while fetching a new product ! ",8,productDAO.list().size());
	
}*/


/*@Test
public void testListActiveProducts()
{
	assertEquals(" Something Went Wrong while fetching a new product ! ",
			7,
			productDAO.
				listActiveProducts().
					size());
}

@Test
public void testListActiveProductsByCategory()
{
	assertEquals(" Something Went Wrong while fetching a new product ! ",
			5,
			productDAO
				.listActiveProductsByCategory(3)
					.size());
				
}

@Test
public void testGetLatestProducts()
{
	assertEquals(" Something Went Wrong while fetching a new product ! ",
			3,
			productDAO
				.getLatestActiveProducts(3)
					.size());
				
}*/
}
