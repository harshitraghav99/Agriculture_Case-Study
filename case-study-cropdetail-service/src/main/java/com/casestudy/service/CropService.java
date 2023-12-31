package com.casestudy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.casestudy.model.Crop;
import com.casestudy.repository.CropRepository;

@Service
public class CropService {
	
	@Autowired
	CropRepository cropRepository;
	
	@Autowired
	RestTemplate restTemplate;
	
//	public Optional<List<Crop>> getCropsEmail(String farmerEmail){
	public List<Crop> getAllCrops(){
		return cropRepository.findAll();
	}
	
	public List<Crop> getCropsEmail(String farmerEmail){
		return cropRepository.findByFarmerEmail(farmerEmail);		
		
	}
	public Crop getCropEmailCropName(String farmerEmail,String cropName) {
		return cropRepository.findByFarmerEmailAndCropName(farmerEmail, cropName);
	}
	public Crop updateCropInc(String farmerEmail,String cropId,int qty) {
		Crop crop = cropRepository.findByFarmerEmailAndCropId(farmerEmail, cropId);
		System.out.println(crop.getCropName());
		int quantity = crop.getCropqnty();
		quantity+=qty;
		crop.setCropqnty(quantity);
		cropRepository.save(crop);
		return crop;
	}
	public Crop updateCropDec(String farmerEmail, String cropId, int qty) {
		// TODO Auto-generated method stub
		Crop crop = cropRepository.findByFarmerEmailAndCropId(farmerEmail, cropId);
		System.out.println(crop.getCropName());
		int quantity = crop.getCropqnty();
		quantity-=qty;
		crop.setCropqnty(quantity);
		cropRepository.save(crop);
		return crop;
		
	}
	public String deleteCrop(String farmerEmail, String cropId) {
		// TODO Auto-generated method stub
		Crop crop = cropRepository.findByFarmerEmailAndCropId(farmerEmail, cropId);
		cropRepository.delete(crop);
		return "deleted";
	}
	public String getFarmerName(String farmerEmail) {
		String farmerName=restTemplate.getForObject("http://localhost:8090/farmer-service/getFarmerName/"+farmerEmail, String.class);
		return farmerName;
	}

	public Crop getCropById(String id) {
		// TODO Auto-generated method stub
		
		return cropRepository.findById(id).get();
	}

}
