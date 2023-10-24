package com.dealer.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dealer.model.Cart;
//import com.dealer.model.CropsList;

public interface CartRepository extends MongoRepository<Cart, String>{

	Cart findByDealerEmail(String dealerEmail);
	
	
}
