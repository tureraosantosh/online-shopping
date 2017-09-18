package ril.com.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ril.com.shoppingbackend.dao.UserDAO;
import ril.com.shoppingbackend.dto.Address;
import ril.com.shoppingbackend.dto.Cart;
import ril.com.shoppingbackend.dto.User;

public class UserTestCase {

	private  static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user=null;
	private Cart cart=null;
	private Address address=null;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("ril.com.shoppingbackend");
		context.refresh();
		userDAO=(UserDAO) context.getBean("userDAO");
	}
	
/*	@Test
	public void testAllAddMethod()
	{
		
		user=new User();
		user.setFirstname("santosh");
		user.setLastname("turerao");
		user.setEmail("tureraosantosh@gmail.com");
		user.setPassword("123456");
		user.setRole("User");
		user.setContactNumber("9967120080");
		
		//add the user
	assertEquals("failed to user add ",true,userDAO.addUser(user));
	
		
	address=new Address();
	
	address.setAddressLineOne("sector 5");
	address.setAddressLineTwo("ghansoli navi mumbai");
	address.setCity("navi mumbai");
	address.setState("maharashtra");
	address.setCountry("india");
	address.setPostCode("400701");
	address.setBilling(true);
	//link the user with the address using user id
	address.setId(user.getId());
	
	
	// add the user address
	assertEquals("failed to add the user address",true,userDAO.addAddress(address));
	

	if(user.getRole().equals("User")) 
	{
		//create a cart for this user
		
		cart=new Cart();
		cart.setUser(user);
		//add the cart
		assertEquals("failed to add the cart",true,userDAO.addCart(cart));
		
		//add a shipping address for this user.
		address=new Address();
		
		address.setAddressLineOne("sector 5");
		address.setAddressLineTwo("ghansoli navi mumbai");
		address.setCity("navi mumbai");
		address.setState("maharashtra");
		address.setCountry("india");
		
		address.setPostCode("400701");
		address.setShipping(true);
		
		//link it to the user address
		address.setUserId(user.getId());
		
		//add the cart
				assertEquals("failed to add address",true,userDAO.addAddress(address));
		
	}
	
	
}*/
	

	/*@Test
	public void testAllAddMethod()
	{
		
		user=new User();
		user.setFirstname("santosh");
		user.setLastname("turerao");
		user.setEmail("tureraosantosh@gmail.com");
		user.setPassword("123456");
		user.setRole("User");
		user.setContactNumber("9967120080");
		
		if(user.getRole().equals("User"))
		{
			cart =new Cart();
			cart.setUser(user);
			
			//attached cart with the user
			user.setCart(cart);
		}
		//add the user
	assertEquals("failed to user add ",true,userDAO.addUser(user));
	
}
*/
		
/*
		@Test
		public void testUpdateCart()
		{
			//fetch the user by email
			
			user=userDAO.getByEmail("tureraosantosh@gmail.com");
			
			//get the cart of the user
			
			cart=user.getCart();
			cart.setGrandTotal(555);
			cart.setCartLines(2);
			assertEquals("failed to update cart", true,userDAO.updateCart(cart));
		}*/
	
/*	@Test
	public void testAddress()
	{

		//we need to add an user
		user=new User();
		user.setFirstname("santosh");
		user.setLastname("turerao");
		user.setEmail("tureraosantosh@gmail.com");
		user.setPassword("123456");
		user.setRole("User");
		user.setContactNumber("9967120080");
		
		//add the user
	assertEquals("failed to user add ",true,userDAO.addUser(user));
	
		
	//we are going to add the address
	
	address=new Address();
	
	address.setAddressLineOne("sector 5");
	address.setAddressLineTwo("ghansoli navi mumbai");
	address.setCity("navi mumbai");
	address.setState("maharashtra");
	address.setCountry("india");
	address.setPostCode("400701");
	address.setBilling(true);
	//link the user with the address using user id
	address.setUser(user);
	// add the user address
	assertEquals("failed to add the user address",true,userDAO.addAddress(address));


	// we are going to  shipping address
		
		
	//add a shipping address for this user.
			address=new Address();
			
			address.setAddressLineOne("sector 5");
			address.setAddressLineTwo("ghansoli navi mumbai");
			address.setCity("navi mumbai");
			address.setState("maharashtra");
			address.setCountry("india");
			
			address.setPostCode("400701");
			address.setShipping(true);
			
			//link it to the user address
			address.setUser(user);
			// add the user address
			assertEquals("failed to add the shipping address",true,userDAO.addAddress(address));
	
		
		
	}*/
	
	/*@Test
	public void testAddAddress()
	{
      user=userDAO.getByEmail("tureraosantosh@gmail.com");
		address=new Address();
		
		address.setAddressLineOne("ward 5");
		address.setAddressLineTwo("washim smatanager");
		address.setCity("washim");
		address.setState("maharashtra");
		address.setCountry("india");
		address.setPostCode("444505");
		address.setShipping(true);
		//link the user with the address using user id
		address.setUser(user);
		// add the user address
		assertEquals("failed to add the user address",true,userDAO.addAddress(address));

	}
		*/
	
	
	@Test
	public void testGetAddress()
	{
		 user=userDAO.getByEmail("tureraosantosh@gmail.com");
		 assertEquals("failed to fetch the user address",2,userDAO.listShippingAddress(user).size());
	
		 assertEquals("failed to fetch the user address","navi mumbai",userDAO.getBillingAddress(user).getCity());
	}
}
