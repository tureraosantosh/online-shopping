package ril.com.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.*;

@Entity 
public class Cart implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="grand_total")
	private double grandTotal;
	@Column(name="cart_line")
	private int cartLines;
	
	/*
	 * getter setter and constructor and tostring
	 * */
	
	@OneToOne

	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	public Cart() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
