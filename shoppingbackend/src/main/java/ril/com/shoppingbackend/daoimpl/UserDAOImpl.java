package ril.com.shoppingbackend.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ril.com.shoppingbackend.dao.UserDAO;
import ril.com.shoppingbackend.dto.Address;
import ril.com.shoppingbackend.dto.Cart;

import ril.com.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	public boolean addUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().persist(user);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		
		}
	
	}

	public boolean addAddress(Address address) {
		try
		{
			sessionFactory.getCurrentSession().persist(address);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		
		}
	}

	public boolean updateCart(Cart cart) {
		try
		{
			sessionFactory.getCurrentSession().update(cart);
			return true;
			
		}catch(Exception ex){
			ex.printStackTrace();
			return false;
			
		
		}
	}

	public User getByEmail(String email) {
		String selectQuery="FROM User where email= :email";
		try {
			return sessionFactory.getCurrentSession().
					createQuery(selectQuery,User.class)
					.setParameter("email", email)
					.getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Address getBillingAddress(User user) {
		try {
			String selectQuery="FROM Address WHERE user=:user AND billing=:billing";
			
			return sessionFactory.getCurrentSession()
			.createQuery(selectQuery,Address.class)
			.setParameter("user", user)
			.setParameter("billing", true)
			.getSingleResult();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
	}

	
	public List<Address> listShippingAddress(User user) {
		try {
			String selectQuery="FROM Address WHERE user=:user AND shipping=:shipping";
			
			return sessionFactory.getCurrentSession()
			.createQuery(selectQuery,Address.class)
			.setParameter("user", user)
			.setParameter("shipping", true)
			.getResultList();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	
		
	}

}
 