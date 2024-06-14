package com.resturant.project;

public class OrderNameNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderNameNotFoundException(String name) {
		super(name);
	}

	
}
