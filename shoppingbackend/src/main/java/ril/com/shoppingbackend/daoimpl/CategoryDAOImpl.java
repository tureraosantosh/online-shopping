package ril.com.shoppingbackend.daoimpl;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ril.com.shoppingbackend.dao.CategoryDAO;
import ril.com.shoppingbackend.dto.Category;
@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO{
	
	@Autowired
public	SessionFactory sessionFactory;

	public List<Category> list() {
		String selectHql="FROM Category WHERE active=:active";
		Query query=sessionFactory.getCurrentSession().createQuery(selectHql);
		query.setParameter("active",true);
		return query.getResultList();
	}
	/*
	 * Gettting Single Category Based on Id...
	 * */
	public Category get(int id) {
		
		
		return sessionFactory.getCurrentSession().get(Category.class,Integer.valueOf(id));
	}
	
	public boolean add(Category category) {
		
		try {
			sessionFactory.getCurrentSession().persist(category);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	/*
	 * 
	 * this method for update single category..
	 * */
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	public boolean delete(Category category) {
		category.setActive(false);
		try {
			sessionFactory.getCurrentSession().update(category);
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	
}
