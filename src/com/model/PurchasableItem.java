package com.model;

import java.util.Date;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import com.constants.Category;
import com.constants.TaxUtility;

public class PurchasableItem extends Item {
	
	public ReentrantReadWriteLock writeLock = new ReentrantReadWriteLock();
	protected Double quantity = new Double(1);
	protected Date dateOfPurchase;
	protected Double totalPrice=0D;
	protected Double totalTaxApplied=0D;
	protected Double totalDiscountApplied=0D;
	
	public PurchasableItem( Double price, Category cat, Double qty) {
		super(price, cat);
		// TODO Auto-generated constructor stub
		this.quantity = qty;
		this.dateOfPurchase = new Date();
		this.totalPrice = this.getPrice()*this.quantity;
		
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totlaPrice) {
		this.totalPrice = totlaPrice;
	}

	public Double getTotalTaxApplied() {
		return totalTaxApplied;
	}

	public void setTotalTaxApplied(Double totalTaxApplied) {
		this.totalTaxApplied = totalTaxApplied;
	}

	public Double getTotalDiscountApplied() {
		return totalDiscountApplied;
	}

	public void setTotalDiscountApplied(Double totalDiscountApplied) {
		this.totalDiscountApplied = totalDiscountApplied;
	}
	
	public void reset()
	{
		super.reset();
		this.dateOfPurchase=null;
		this.quantity=0D;
		this.totalDiscountApplied=0D;
		this.totalTaxApplied=0D;
		this.totalPrice=0D;
	}
}
