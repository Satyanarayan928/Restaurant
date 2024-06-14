/**
 * 
 */
package com.resturant.project;

/**
 * 
 */
public class Item {
	
	private int itemId;
	private String item;
	private double price;
	
	public Item(int itemId, String item, double price) {
		super();
		this.itemId = itemId;
		this.item = item;
		this.price = price;
	}

	public Item() {
		// TODO Auto-generated constructor stub
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", item=" + item + ", price=" + price + "]";
	}
	
	

}
