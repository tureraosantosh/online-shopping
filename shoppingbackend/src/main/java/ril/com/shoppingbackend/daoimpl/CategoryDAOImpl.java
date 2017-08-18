package ril.com.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ril.com.shoppingbackend.dao.CategoryDAO;
import ril.com.shoppingbackend.dto.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO{
private static List<Category> categories=new ArrayList<Category>();
static
{
	Category category=new Category();
	Category category1=new Category();
	Category category2=new Category();
	

	category.setId(1);
	category.setName("Television");
	category.setDescription("This is some description for television!");
	category.setImageURL("CAT_1.png");
	
	category1.setId(2);
	category1.setName("Radio");
	category1.setDescription("This is some description for Radio!");
	category1.setImageURL("CAT_2.png");
	
	category2.setId(3);
	category2.setName("Computer");
	category2.setDescription("This is some description for Computer!");
	category2.setImageURL("CAT_3.png");
	
	
	categories.add(category);
	categories.add(category1);

	categories.add(category2);

	

}
	public List<Category> list() {
		
		return categories;
	}
	public Category get(int id) {
		
		for(Category category : categories)
		{
			if(category.getId()==id) return category;
		}
		return null;
	}

}
