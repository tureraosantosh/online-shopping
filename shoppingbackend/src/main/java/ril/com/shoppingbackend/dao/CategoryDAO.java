package ril.com.shoppingbackend.dao;
import java.util.List;

import ril.com.shoppingbackend.dto.*;
public interface CategoryDAO {
	
	
	
	public Category get(int id);
	public List<Category>list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
	

}
