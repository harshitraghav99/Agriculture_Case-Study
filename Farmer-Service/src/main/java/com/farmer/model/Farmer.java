package com.farmer.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;




@Document("farmer")
public class Farmer {
	
	@Id
	private String fid;
	@Field
	private String femail;
	@Field
	private String fpass;
	@Field
	private String fname;
	@Field
	private String fimage;
	@Field
	private String fbank;
	@Field
	private String fpaytmid;
	@Field
	private String faccountno;
	@Field
	private String fbankbranch;
	@Field
	private String fcontact;
	@Field
	private String flocation;
	@Field
	private String fabout;
	@Field
	private List<Crops> crops;
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getFemail() {
		return femail;
	}
	public void setFemail(String femail) {
		this.femail = femail;
	}
	public String getFpass() {
		return fpass;
	}
	public void setFpass(String fpass) {
		this.fpass = fpass;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFimage() {
		return fimage;
	}
	public void setFimage(String fimage) {
		this.fimage = fimage;
	}
	public String getFbank() {
		return fbank;
	}
	public void setFbank(String fbank) {
		this.fbank = fbank;
	}
	public String getFpaytmid() {
		return fpaytmid;
	}
	public void setFpaytmid(String fpaytmid) {
		this.fpaytmid = fpaytmid;
	}
	public String getFaccountno() {
		return faccountno;
	}
	public void setFaccountno(String faccountno) {
		this.faccountno = faccountno;
	}
	public String getFbankbranch() {
		return fbankbranch;
	}
	public void setFbankbranch(String fbankbranch) {
		this.fbankbranch = fbankbranch;
	}
	public String getFcontact() {
		return fcontact;
	}
	public void setFcontact(String fcontact) {
		this.fcontact = fcontact;
	}
	public String getFlocation() {
		return flocation;
	}
	public void setFlocation(String flocation) {
		this.flocation = flocation;
	}
	public String getFabout() {
		return fabout;
	}
	public void setFabout(String fabout) {
		this.fabout = fabout;
	}
	public List<Crops> getCrops() {
		return crops;
	}
	public void setCrops(List<Crops> crops) {
		this.crops = crops;
	}
	
}
