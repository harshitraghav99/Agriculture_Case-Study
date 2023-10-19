package com.dealer.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dealer.model.Cart;
import com.dealer.model.Crops;
//import com.dealer.model.CropsList;
import com.dealer.model.Dealer;

import com.dealer.model.FarmerList;
import com.dealer.repository.CartRepository;
//import com.dealer.repository.CropListRepository;
import com.dealer.repository.DealerRepository;


@Service
public class DealerService {
	
	//RestTemplate
	@Autowired
	RestTemplate restTemplate;
	
	//Get the dealer Repo
	@Autowired
	private DealerRepository dealerRepo;
	
	@Autowired
	private CartRepository cartRepository;
	
	
	
	
	//add a dealer (implement in register)
	public String addDealer(Dealer dealer)
	{
		dealerRepo.save(dealer);
		return "Added Dealer";
	}

	//update dealer details
	public String updateDealer(Dealer d, String dealerid)
	{
		dealerRepo.save(d);
		//message
		String success = "Updated Dealer Details";
		return success+" "+dealerid;
	}
	
	//delete Dealer
	public String deleteDealer(String dealerid)
	{
		dealerRepo.deleteById(dealerid);
		String message = "Deleted";
		return message;
	}
		
	//get dealer details
	public Optional<Dealer> getDealer(String dealerid)
	{
		return dealerRepo.findById(dealerid);
	}
	
	

	public List<Crops> getAllCrops()
	{
		
		List<Crops> crops = restTemplate.getForObject("http://localhost:8090/crop-service/getAllCrops", List.class);
		
		return crops;
	}
	
	//get crops
//	public List<Crops> getCropsarray(String randomid)
//	{
//		getDealerCrops(randomid);
//		return croplistRepo.findById(randomid).get().getCrops();
//	}

	public Crops fetchCropById(String cropId) {
		// TODO Auto-generated method stub
		String url="http://localhost:8090/crop-service/getCropById/";
		Crops crop = restTemplate.getForObject(url+cropId, Crops.class);
		return crop;
	}
	
	

	public void buyCrop(String dealerEmail,Crops crop,int quantity) {
		crop.setCropqnty(String.valueOf(quantity));
		
		Dealer dealer = dealerRepo.findByDealerEmail(dealerEmail);
		if(dealer.getDealerCart()==null) {
			dealer.setDealerCart(new Cart());
		}
		Cart cart = dealer.getDealerCart();
		
		
		List<Crops> crops = new ArrayList<>();
		if(cart.getCrops() == null) {
			crops.add(crop);
			cart.setCrops(crops);
		}
		else if(cart.getCrops().isEmpty()) {
			crops.add(crop);
			cart.setCrops(crops);
		}
		else {
			crops=cart.getCrops();
			crops.add(crop);
		}
		cart.setCrops(crops);
		cart.setDealerEmail(dealerEmail);
		cartRepository.save(cart);
		dealer.setDealerCart(cart);
		dealerRepo.save(dealer);
	}
	
	/*
	 * //find by dealer email public List<Dealer> getDealerDetailsbyEmail(String
	 * dealeremail) { List<Dealer> d = dealerRepo.findAll(); List<Dealer> s = new
	 * ArrayList<>();
	 * 
	 * for(Dealer temp: d) { if(temp.getDealeremail().equals(dealeremail)) {
	 * s.add(temp); System.out.println(s); } } return s; }
	 */
}
