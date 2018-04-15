package com.model;

import java.util.List;

public class Receipt {
	private List<PurchasableItem> itemsPurchased;
	private Double totalTaxApplied;
	private Double totalAmount;
	public List<PurchasableItem> getItemsPurchased() {
		return itemsPurchased;
	}
	public void setItemsPurchased(List<PurchasableItem> itemsPurchased) {
		this.itemsPurchased = itemsPurchased;
	}
	public Double getTotalTaxApplied() {
		return totalTaxApplied;
	}
	public void setTotalTaxApplied(Double totalTaxApplied) {
		this.totalTaxApplied = totalTaxApplied;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public String toString()
	{
		StringBuilder r = new StringBuilder();
		for(Item i:itemsPurchased)
		{
			PurchasableItem pi = (PurchasableItem) i;
			r.append(pi.getQuantity());
			r.append(" ");
			r.append(pi.getName());
			r.append(" :");
			r.append(pi.getTotalPrice());
			r.append("\n");
		}
		r.append("Total Taxes:"+this.totalTaxApplied+"\n");
		r.append("Total Price:"+this.totalAmount);
		return r.toString();
	}
	
}
