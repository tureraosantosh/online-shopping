package ril.com.shoppingbackend.dto;

public class Category {

	/*
	 * private fields....
	 * */
	private int id;
	private String name;
	private String description;
	private String imageURL;
	private boolean active=true;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int id, String name, String description, String imageURL, boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.imageURL = imageURL;
		this.active = active;
	}
	
}
