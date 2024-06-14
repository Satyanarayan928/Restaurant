/**
 * 
 */
package com.resturant.project;

/**
 * 
 */
public class Customer {
	
	private int custId;
	private String name;
	private String address;
	private String phone;
	
	
	
	
	public Customer(int id, String name, String address, String phone) {
		super();
		this.custId = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	 
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
	 
	
	
	
	
	

}
