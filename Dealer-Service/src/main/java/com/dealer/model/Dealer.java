package com.dealer.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;




@Document("Dealers")
public class Dealer {
	
	@Id
	private String dealerid;
	@Field 	//username
	private String dealeremail;
	@Field	//password
	private String dealerpass;
	@Field
	private String dealername;
	@Field
	private String dealerphone;
	@Field
	private String dealerimage;
	@Field
	private String dealerlocation;
	@Field
	private String dealerabout;
	@Field
	private String dealerbank;
	@Field
	private String dealerbranch;
	@Field
	private String dealeraccountno;
	@Field
	private String dealerpaytmid;

	public String getDealerid() {
		return dealerid;
	}
	public void setDealerid(String dealerid) {
		this.dealerid = dealerid;
	}
	public String getDealeremail() {
		return dealeremail;
	}
	public void setDealeremail(String dealeremail) {
		this.dealeremail = dealeremail;
	}
	public String getDealerpass() {
		return dealerpass;
	}
	public void setDealerpass(String dealerpass) {
		this.dealerpass = dealerpass;
	}
	public String getDealername() {
		return dealername;
	}
	public void setDealername(String dealername) {
		this.dealername = dealername;
	}
	public String getDealerphone() {
		return dealerphone;
	}
	public void setDealerphone(String dealerphone) {
		this.dealerphone = dealerphone;
	}
	public String getDealerimage() {
		return dealerimage;
	}
	public void setDealerimage(String dealerimage) {
		this.dealerimage = dealerimage;
	}
	public String getDealerlocation() {
		return dealerlocation;
	}
	public void setDealerlocation(String dealerlocation) {
		this.dealerlocation = dealerlocation;
	}
	public String getDealerabout() {
		return dealerabout;
	}
	public void setDealerabout(String dealerabout) {
		this.dealerabout = dealerabout;
	}
	public String getDealerbank() {
		return dealerbank;
	}
	public void setDealerbank(String dealerbank) {
		this.dealerbank = dealerbank;
	}
	public String getDealerbranch() {
		return dealerbranch;
	}
	public void setDealerbranch(String dealerbranch) {
		this.dealerbranch = dealerbranch;
	}
	public String getDealeraccountno() {
		return dealeraccountno;
	}
	public void setDealeraccountno(String dealeraccountno) {
		this.dealeraccountno = dealeraccountno;
	}
	public String getDealerpaytmid() {
		return dealerpaytmid;
	}
	public void setDealerpaytmid(String dealerpaytmid) {
		this.dealerpaytmid = dealerpaytmid;
	}
}
