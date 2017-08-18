package ril.com.shoppingbackend.dao;
import java.util.List;

import ril.com.shoppingbackend.dto.*;
public interface CategoryDAO {
	
	public List<Category>list();
	public Category get(int id);
	

}
