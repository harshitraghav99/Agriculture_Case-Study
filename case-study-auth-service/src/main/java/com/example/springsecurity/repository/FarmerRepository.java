package com.example.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springsecurity.model.Farmer;


public interface FarmerRepository extends MongoRepository<Farmer, Integer> {
	Optional<Farmer> findByFarmerName(String farmerName);
}
