package com.example.springsecurity.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Dealers")
public class Dealer {

	@Id
	private String dealerId;
	@Field 	//username
	private String dealerEmail;
	@Field	//password
	private String dealerPassword;
	@Field
	private String dealerName;
	@Field
	private String dealerPhone;
	
	@Field
	private String dealerLocation;
	@Field
	private String dealerAbout;
	@Field
	private String dealerBank;
	@Field
	private String dealerBranch;
	@Field
	private String dealerAccountNo;
	@Field
	private String dealerPaytmId;
	public String getId() {
		return dealerId;
	}
	public void setId(String id) {
		this.dealerId = id;
	}
	public String getDealerName() {
		return dealerName;
	}
	public void setDealerName(String name) {
		this.dealerName = name;
	}
	public String getDealerPassword() {
		return dealerPassword;
	}
	public void setDealerPassword(String password) {
		this.dealerPassword = password;
	}
	public String getDealerEmail() {
		return dealerEmail;
	}
	public void setDealerEmail(String dealerEmail) {
		this.dealerEmail = dealerEmail;
	}
	public String getDealerPhone() {
		return dealerPhone;
	}
	public void setDealerPhone(String dealerPhone) {
		this.dealerPhone = dealerPhone;
	}
	public String getDealerLocation() {
		return dealerLocation;
	}
	public void setDealerLocation(String dealerLocation) {
		this.dealerLocation = dealerLocation;
	}
	public String getDealerAbout() {
		return dealerAbout;
	}
	public void setDealerAbout(String dealerAbout) {
		this.dealerAbout = dealerAbout;
	}
	public String getDealerBank() {
		return dealerBank;
	}
	public void setDealerBank(String dealerBank) {
		this.dealerBank = dealerBank;
	}
	public String getDealerBranch() {
		return dealerBranch;
	}
	public void setDealerBranch(String dealerBranch) {
		this.dealerBranch = dealerBranch;
	}
	public String getDealerAccountNo() {
		return dealerAccountNo;
	}
	public void setDealerAccountNo(String dealerAccountNo) {
		this.dealerAccountNo = dealerAccountNo;
	}
	public String getDealerPaytmId() {
		return dealerPaytmId;
	}
	public void setDealerPaytmId(String dealerPaytmId) {
		this.dealerPaytmId = dealerPaytmId;
	}
	
	
}
