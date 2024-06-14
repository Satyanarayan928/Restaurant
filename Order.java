/**
 * 
 */
package com.resturant.project;

import java.util.List;

/**
 * 
 */
public class Order {
	
	private int orderId;
	private List<Item> items;
	private String orderType;
	private int amount;
	private double price;
	
	public Order(int orderId, List<Item> items, String orderType, int amount, double price) {
		super();
		this.orderId = orderId;
		this.items = items;
		this.orderType = orderType;
		this.amount = amount; 
		this.price = price;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", items=" + items + ", orderType=" + orderType + ", amount=" + amount
				+ ", price=" + price + "]";
	}
	
	
	

}
