package ril.com.shoppingbackend.dao;

import java.util.List;

import ril.com.shoppingbackend.dto.Address;
import ril.com.shoppingbackend.dto.Cart;
import ril.com.shoppingbackend.dto.User;

public interface UserDAO {
//add an user
	boolean addUser(User user);
	// user get by email
	User getByEmail(String email);
	//add an Address
	boolean addAddress(Address address);
	
	Address getBillingAddress(User user);
	List<Address>listShippingAddress(User user);
	
	//update cart
	boolean updateCart(Cart cart);
}
