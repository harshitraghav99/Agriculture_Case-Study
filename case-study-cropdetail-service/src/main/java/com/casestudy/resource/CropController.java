package com.casestudy.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Crop;
import com.casestudy.repository.CropRepository;

@RestController
@RequestMapping("/crop-service")
public class CropController {
	
	@Autowired
	private CropRepository repository;
	
	@PostMapping("/addCrop")
	public String addCrop(@RequestBody Crop crop) {
		repository.save(crop);
		return "added crop with id: " + crop.getCropId();
	}
	
	@GetMapping("/findAllCrops")
	public List<Crop> getCrops(){
		return repository.findAll();
	}
	
	@GetMapping("/findCrop/{id}")
	public Optional<Crop> getCrop(@PathVariable int id){
		return repository.findById(id);
	}
//	@PutMapping("/updateCrops/{id}")
//	public String updateCrop(@RequestBody Crop crop) {
//		repository.save(crop);
//		return "updated crop with id: " + crop.getFid();
//	}
	
	@DeleteMapping("/deleteCrop/{id}")
	public String deleteCrop(@PathVariable int id) {
		repository.deleteById(id);
		return "crop deleted with id : "+id;
		
	}

}
