package com.casestudy.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Crops")
public class Crop {
	
//	private String fid;
	@Id
	private String cropId;
	private String cropName;
	private String cropimage;
	//yet to learn and add
	private int cropqlty;
	private String croplocation;
	private String cropcontact;
	private int cropqnty;
	private String cropdesc;
	private int cropprice;

//	private String farmerId;
	private String farmerEmail;
	private String farmerName;
	
	
	public String getFarmerName() {
		return farmerName;
	}
	public void setFarmerName(String farmerName) {
		this.farmerName = farmerName;
	}

	public String getFarmerEmail() {
		return farmerEmail;
	}
	public void setFarmerEmail(String farmerEmail) {
		this.farmerEmail = farmerEmail;
	}
//	public String getFarmerId() {
//		return farmerId;
//	}
//	public void setFarmerId(String farmerId) {
//		this.farmerId = farmerId;
//	}
	
	
	public String getCropId() {
		return cropId;
	}
	public void setCropId(String cropId) {
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
	public int getCropqlty() {
		return cropqlty;
	}
	public void setCropqlty(int cropqlty) {
		this.cropqlty = cropqlty;
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
	public int getCropqnty() {
		return cropqnty;
	}
	public void setCropqnty(int cropqnty) {
		this.cropqnty = cropqnty;
	}
	public String getCropdesc() {
		return cropdesc;
	}
	public void setCropdesc(String cropdesc) {
		this.cropdesc = cropdesc;
	}
	public int getCropprice() {
		return cropprice;
	}
	public void setCropprice(int cropprice) {
		this.cropprice = cropprice;
	}
	
	

}
