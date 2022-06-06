package com.onlinestore.model;


public class Product {
	protected int id;
	protected String name;
	protected Double price;
	
	//Constructors
	public Product() {}
	public Product(String name, Double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public Product(int id, String name, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	//Getters & Setters
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	
}
