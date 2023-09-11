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
//	public String addFarmer(Farmer f)
//	{
//		f.setCrops(null);
//		f.setFabout(null);
//		farmerRepo.save(f);
//		return "Added Farmer";
//	}
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
	public Crops fetchCrop(String fid, int cropid)
	{
		/*Crops nullobject = new Crops(); //null object
		for(int i = 0; i < farmerRepo.findById(fid).get().getCrops().size(); i++)
		{
			Crops storecrops = farmerRepo.findById(fid).get().getCrops().get(i);
			if(storecrops.getCropid() == cropid)  //if(fob.getSource().equals(source) && fob.getDest().equals(dest))
			{
				return storecrops;
			}
		}
		return nullobject;*/
		Crops crop = restTemplate.getForObject("http://Crop-Service/findCrop/{fid}", Crops.class);
		return crop;
		
		
	}
	
	//Add crops by farmers
	public ResponseEntity<Crops> addCrops(String fid, Crops crop)
	{
//		Crops crops = restTemplate.getForObject("http://Crop-Service/addCrop", Crops.class);
//		return "added";
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Crops> request = new HttpEntity<>(crop, headers);

        ResponseEntity<Crops> response = restTemplate.postForEntity(
        		"http://Crop-Service/addCrop",
            request,
            Crops.class
        );

        // Handle the response as needed
        return response;
	}
	
	//find all crops added by the farmer
	public List<Crops> findCrops(String fid)
	{
//		Crops crops = restTemplate.getForObject("http://Crop-Service/addCrop", Crops.class);

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




