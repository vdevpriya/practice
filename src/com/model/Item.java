package com.model;

import com.constants.Category;

public class Item {
	protected String name;
	protected Double price=0D;
	protected Category category;
	protected String itemCode;
	
	public Item(Double price,Category cat)
	{
		this.category = cat;
		this.price = price;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	
	public void reset()
	{

	}
	
}
