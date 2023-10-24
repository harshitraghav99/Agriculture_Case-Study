package com.payementgateway.models;

public class TransactionDetails {
	
	private String orderId;
	private String currency;
	private int amount;
	public TransactionDetails(String orderId, String currency, int amount) {
		super();
		this.orderId = orderId;
		this.currency = currency;
		this.amount = amount;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	

}
