package com.payementgateway.service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.payementgateway.models.TransactionDetails;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

@Service
public class TransactionService {
	
	private static final String KEY="rzp_test_QGCGzhanY0URWT";
	private static final String SECRET="CARdBvjoLHtpav4uzRlD2sjm";
	private static final String CURRENCY="INR";
	
	public TransactionDetails createTransaction(double amount) {
		
		
		
		try {
			JSONObject jsonObject= new JSONObject();
			jsonObject.put("amount", amount*100);
			jsonObject.put("currency", CURRENCY);
			
			RazorpayClient razorpayClient=new RazorpayClient(KEY, SECRET);
			Order order= razorpayClient.orders.create(jsonObject);
			
			System.out.println(order);
			return prepareTransactionDetails(order);
			
			
			
		}catch(Exception e) {
			e.getMessage();
		}	
		return null;
	}
	private TransactionDetails prepareTransactionDetails(Order order) {
		String orderId=order.get("id");
		String currency=order.get("currency");
		int amount=order.get("amount");
		
		TransactionDetails transactionDetails = 
				new TransactionDetails(orderId, currency, amount);
		return transactionDetails;
		
		
	}
	
	

}
