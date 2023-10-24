package com.farmer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.farmer.exception.CropsNullException;
import com.farmer.model.Crops;
import com.farmer.model.Farmer;
import com.farmer.model.FarmerList;
import com.farmer.repository.FarmerRepository;

@Service
public class FarmerService {
	
	//Getting the repository functionality (MongoDB)
	@Autowired
	FarmerRepository farmerRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private SequenceGeneratorService service;
	
	//public FarmerService(FarmerService farmerService) {
		//this.farmerService = farmerService;
	//}
	
	//FETCH CROPS FROM ALL FARMERS
	
//	public FarmerList getAllCrops()
//	{
//		List<Farmer> allCrops = farmerRepo.findAll();
//		FarmerList listfarm = new FarmerList();
//		listfarm.setFarmerlist(allCrops);
//		
//		//return
//		return listfarm;
//	}
//	
//	//FARMER OPERATIONS
//	
//	//add a farmer
	public String addFarmer(Farmer f)
	{
		f.setCrops(null);
		System.out.println("helo farmer service");
//		f.setFabout(null);
		farmerRepo.save(f);
		return "Added Farmer";
	}
//	
//	//get farmer details
//	public Optional<Farmer> getFarmerDetails(String fid)
//	{
//		return farmerRepo.findById(fid);
//	}
//	
//	//update farmer details
//	public String updateFarmer(Farmer f, String fid)
//	{
//		farmerRepo.save(f);
//		//message
//		String success = "Updated Farmer Details";
//		return success+" "+fid;
//	}
//	
//	//delete the farmer
//	public String deleteFarmer(String fid)
//	{
//		farmerRepo.deleteById(fid);
//		String message = "Deleted";
//		return message;
//	}
//	
	//CROP OPERATIONS
	
	//fetch crops for farmers
	public List<Crops> fetchCropsFarmerEmail(String farmerEmail)
	{
//		System.out.println("hello from farmer service "+farmerEmail);
		List<Crops> crops = restTemplate.getForObject("http://localhost:8090/crop-service/getCropsEmail/{farmerEmail}", List.class,farmerEmail);
		return crops;
		
		
	}
	
	public Crops fetchCropsFarmerEmailCropName(String farmerEmail,String cropName)
	{
//		System.out.println("hello from farmer service "+farmerEmail+cropName);
		Crops crop = restTemplate.getForObject("http://localhost:8090/crop-service/getCropsEmailCropName/{farmerEmail}/{cropName}", 
				Crops.class,
				farmerEmail,
				cropName);
		
		return crop;
		
		
	}
	
	public void updateCropInc(String farmerEamil, String cropId, int qty) {
		
		Farmer farmer = farmerRepo.findByFarmerEmail(farmerEamil);
//		System.out.println(qty +"quantity");
		List<Crops> crops = farmer.getCrops();
		int i = 0;
		for (Crops crop : crops) {
			if(crop.getCropId().equalsIgnoreCase(cropId)) {
				int quantity=crop.getCropqnty() + qty;
//				System.out.println(quantity+ "after add");
				crops.remove(i);
				
				crop.setCropqnty(quantity);
//				System.out.println(crop.getCropqnty());
				crops.add(i, crop);
				break;
			}
			i++;
		}
		farmer.setCrops(crops);
		farmerRepo.save(farmer);
	
		String baseUrl= "http://localhost:8090/crop-service/updateCropInc/"+farmerEamil+"/"+cropId+"/"+qty;
		restTemplate.put(baseUrl, String.class);
	}
	
	
	public void updateCropDec(String farmerEamil, String cropId, int qty) {
		
		Farmer farmer = farmerRepo.findByFarmerEmail(farmerEamil);
//		System.out.println(qty +"quantity");
		List<Crops> crops = farmer.getCrops();
		int i = 0;
		for (Crops crop : crops) {
			if(crop.getCropId().equalsIgnoreCase(cropId)) {
				int quantity=crop.getCropqnty() - qty;
//				System.out.println(quantity+ "after add");
				crops.remove(i);
				
				crop.setCropqnty(quantity);
//				System.out.println(crop.getCropqnty());
				crops.add(i, crop);
				break;
			}
			i++;
		}
		farmer.setCrops(crops);
		farmerRepo.save(farmer);
	
		String baseUrl= "http://localhost:8090/crop-service/updateCropDec/"+farmerEamil+"/"+cropId+"/"+qty;
		restTemplate.put(baseUrl, String.class);
	}
	
	
	
	public void deleteCrop(String farmerEamil, String cropId) {
		Farmer farmer = farmerRepo.findByFarmerEmail(farmerEamil);
//		System.out.println(qty +"quantity");
		System.out.println(farmer.getFarmerName());
		List<Crops> crops = farmer.getCrops();
		System.err.println(crops.isEmpty());
		int i = 0;
		for (Crops crop : crops) {
			if(crop.getCropId().equalsIgnoreCase(cropId)) {
				System.out.println("ïnLoop");
				break;
			}
			i++;
			
		}
		System.out.println(i);
		crops.remove(i);
		farmer.setCrops(crops);
		farmerRepo.save(farmer);
		
		String baseUrl= "http://localhost:8090/crop-service/deleteCrop/"+farmerEamil+"/"+cropId;
		restTemplate.delete(baseUrl);
	}
	
	//Add crops by farmers
	public ResponseEntity<String> addCrops(String farmerEmail, Crops crop)
	{
		Farmer farmer =farmerRepo.findByFarmerEmail(farmerEmail);
		
		System.out.println(farmer.getFarmerName());
		crop.setFarmerName(farmer.getFarmerName());
		System.out.println(crop.getCropName());
		crop.setFarmerEmail(farmerEmail);
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Crops> request = new HttpEntity<>(crop, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(
        		"http://localhost:8090/crop-service/addCrop",
            request,
            String.class
        );
        crop.setCropid(response.getBody());
		List<Crops> crops = new ArrayList<>();
//		try {
		
		if(farmer.getCrops()==null) {
			System.err.println("null");
			crops.add(crop);
			farmer.setCrops(crops);
		}
		else if(farmer.getCrops().isEmpty()) {
			System.err.println("empty");
			crops.add(crop);
			farmer.setCrops(crops);
		}
		
		else {
			System.err.println(" not empty");
			crops=farmer.getCrops();	
			crops.add(crop);
			farmer.setCrops(crops);
		}
//		
		for (Crops crops2 : farmer.getCrops()) {
			System.out.println(crops2.getCropName()+" crop");
		}
		farmerRepo.save(farmer);
		
//		crop.setFarmerId(farmer.getFarmerId());

        // Handle the response as needed
        return response;
	}
	
	public String getFarmerName(String farmerEmail) {
		Farmer farmer=farmerRepo.findByFarmerEmail(farmerEmail);
		return farmer.getFarmerName();
	}
	
	
	//find all crops added by the farmer
	public List<Crops> findCrops(String farmerEmail)
	{
//		Crops crops = restTemplate.getForObject("http://Crop-Service/addCrop", Crops.class);
		Farmer farmer = farmerRepo.findByFarmerEmail(farmerEmail);
		ResponseEntity<Crops[]> response =
				  restTemplate.getForEntity(
				  "http://localhost:8090/crop-service/getCropsEmail/{farmerEmail}",
				  Crops[].class);

		return null;
		//search functionality yet to be deployed
	}
	
	//update the crop for the farmer
	public String updateCrop(String fid, int cropid, Crops crop)
	{
		return null;
	}
	
	//delete crops added by farmer
	public String deleteCrop(String fid,int cropid)
	{
		return null;
	}
	

}




