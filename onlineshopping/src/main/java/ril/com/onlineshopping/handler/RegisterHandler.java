package ril.com.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ril.com.onlineshopping.model.RegisterModel;
import ril.com.shoppingbackend.dao.UserDAO;
import ril.com.shoppingbackend.dto.Address;
import ril.com.shoppingbackend.dto.Cart;
import ril.com.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	@Autowired
	private UserDAO userDAO;
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	public void addUser(RegisterModel registerModel,User user)
	{
		registerModel.setUser(user);
	}
	
	public void addBilling(RegisterModel registerModel,Address address)
	{
		registerModel.setBilling(address);
	}
	
	public String saveAll(RegisterModel registerModel)
	{
		String transitionValue="success";
		
		//fetch the user
		User user=registerModel.getUser();
		if(user.getRole().equals("USER"))
		{
			Cart cart=new Cart();
			cart.setUser(user);
			user.setCart(cart);
		}
		
		//save the user 
		userDAO.addUser(user);
		
		
	//fetch the addrsss
		
		Address billing =registerModel.getBilling();
		billing.setId(new Integer(4));
		billing.setBilling(true);
		
		//save the address
		userDAO.addAddress(billing);
		
		
		
		
		
		return transitionValue;
	}

}
