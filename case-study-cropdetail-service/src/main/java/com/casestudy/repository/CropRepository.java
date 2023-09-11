package com.casestudy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.casestudy.model.Crop;

public interface CropRepository extends MongoRepository<Crop, Integer> {

}
