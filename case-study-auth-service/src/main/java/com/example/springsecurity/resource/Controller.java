package com.example.springsecurity.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springsecurity.entity.UserInfo;
import com.example.springsecurity.model.AuthRequest;
import com.example.springsecurity.model.Dealer;
import com.example.springsecurity.model.Farmer;
import com.example.springsecurity.repository.DealerRepository;
import com.example.springsecurity.repository.FarmerRepository;

import com.example.springsecurity.repository.UserInfoRepository;
import com.example.springsecurity.service.JwtService;

@RestController
@CrossOrigin(origins = "*")	
@RequestMapping("/auth")
public class Controller {
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private FarmerRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private DealerRepository managementRepository;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	
	
	@PostMapping("/registerFarmer")
	public String registerFarmer(@RequestBody Farmer farmer) {
		
		farmer.setId((userInfoRepository.findAll().size())+1);
		repository.save(farmer);
		UserInfo userInfo = new UserInfo();
		userInfo.setId(farmer.getId());
		userInfo.setName(farmer.getFarmerName());
		userInfo.setPassword(passwordEncoder.encode(farmer.getPassword()));
		userInfo.setRoles("ROLE_FARMER");
		userInfoRepository.save(userInfo);
		
		return "added FARMER with id: " + farmer.getId();
	}
	@PostMapping("/registerDealer")
	public String registerDealer(@RequestBody Dealer dealer) {
		dealer.setId((userInfoRepository.findAll().size())+1);
		managementRepository.save(dealer);
		UserInfo userInfo = new UserInfo();
		userInfo.setId(dealer.getId());
		userInfo.setName(dealer.getName());
		userInfo.setPassword(passwordEncoder.encode(dealer.getPassword()));
		userInfo.setRoles("ROLE_DEALER");
		userInfoRepository.save(userInfo);
		
		return "added DEALER with id: " + dealer.getId();
	}
	
	@GetMapping("/welcome")
	public String welcome(){
		return "welcome";
	}
//	@PreAuthorize("ROLE_DEALER")
//	@GetMapping("/findAllDealer")
	
	
	
	
//	@PostMapping("/new")
//	public String addUser(@RequestBody UserInfo userInfo) {
//		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
//		userInfoRepository.save(userInfo);
//		return "user added to system";
//	}
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
//		System.out.println(authRequest.getUsername()+authRequest.getPassword());
		Authentication authentication= authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())); 
		if(authentication.isAuthenticated()) {
//			System.out.println("auth");
			UserInfo user =  userInfoRepository.findByName(authRequest.getUsername()).get();
			String token=jwtService.generateToken(user.getName(),user.getRoles());
//			System.out.println(token);
			return ResponseEntity.ok(token);	
		}
		else {
			throw new UsernameNotFoundException("invalid username");
		}
		
	}

}
