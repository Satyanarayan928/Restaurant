/**
 * 
 */
package com.resturant.project;

/**
 * 
 */
public class Payment {
	
	private int paymentId;
	private String paymentMode;
	private double amount;
	private String date;
	
	public Payment(int paymentId, String paymentMode, double amount, String date) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.amount = amount;
		this.date = date;
	}  

	public Payment() {
		// TODO Auto-generated constructor stub
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", amount=" + amount + ", date="
				+ date + "]";
	}
	
	

}
