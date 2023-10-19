package com.dealer.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("crops")
public class Crops {
	
	
	
//	private  String fid;
	@Id
	private  String cropId;
	private  String cropName;
	private  String cropimage;
	private  String cropqlty;
	private  String cropdesc;
	private  String croplocation;
	private  String cropcontact;
	private  String cropqnty;
	private  String cropprice;
	private String farmerEmail;
	
	public String getFarmerEmail() {
		return farmerEmail;
	}
	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}
	public String getCropId() {
		return cropId;
	}
	public void setCropid(String cropId) {
		this.cropId = cropId;
	}
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropname) {
		this.cropName = cropname;
	}
	public String getCropimage() {
		return cropimage;
	}
	public void setCropimage(String cropimage) {
		this.cropimage = cropimage;
	}
	public String getCropqlty() {
		return cropqlty;
	}
	public void setCropqlty(String cropqlty) {
		this.cropqlty = cropqlty;
	}
	public String getCropdesc() {
		return cropdesc;
	}
	public void setCropdesc(String cropdesc) {
		this.cropdesc = cropdesc;
	}
	public String getCroplocation() {
		return croplocation;
	}
	public void setCroplocation(String croplocation) {
		this.croplocation = croplocation;
	}
	public String getCropcontact() {
		return cropcontact;
	}
	public void setCropcontact(String cropcontact) {
		this.cropcontact = cropcontact;
	}
	public String getCropqnty() {
		return cropqnty;
	}
	public void setCropqnty(String cropqnty) {
		this.cropqnty = cropqnty;
	}
	public String getCropprice() {
		return cropprice;
	}
	public void setCropprice(String cropprice) {
		this.cropprice = cropprice;
	}
	
	
}
