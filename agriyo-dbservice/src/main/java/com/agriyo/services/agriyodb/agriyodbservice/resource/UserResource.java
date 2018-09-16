package com.agriyo.services.agriyodb.agriyodbservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agriyo.services.agriyodb.agriyodbservice.exception.AgriyoBusinessException;
import com.agriyo.services.agriyodb.agriyodbservice.model.FarmerCrop;
import com.agriyo.services.agriyodb.agriyodbservice.model.FarmerDetail;
import com.agriyo.services.agriyodb.agriyodbservice.model.User;
import com.agriyo.services.agriyodb.agriyodbservice.model.UserRequest;
import com.agriyo.services.agriyodb.agriyodbservice.repository.UserRepository;


@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/getUserByMobileAndPassword")
	public User getUserByMobileAndPassword(@RequestBody User user){
		return userRepository.findByMobileAndPassword(user.getMobile(),user.getPassword());
	}
	
	@PostMapping("/create")
	public User saveUser(@RequestBody User user){
		User tempUser=null;
		try {
			tempUser= userRepository.save(user);
		}
		catch (Exception e) {
			if(e.getMessage().contains("for key 'MOBILE_UNIQUE'"));
			 throw new AgriyoBusinessException("Mobile No already registered. Please try different Mobile no.");
		}
		return tempUser;
	}
	
	
	
	@PostMapping("/update")
	public User updateUser(@RequestBody User user){
		return userRepository.save(user);
	}

	
	@PostMapping("/saveUserRequest")
	public void saveUserRequest(@RequestBody UserRequest userRequest){
		 userRepository.saveUserRequest(userRequest);
	}

	
	@PostMapping("/saveFarmerCrops")
	public void updateUser(@RequestBody List<FarmerCrop> farmerCops){
		 userRepository.saveFarmerCrops(farmerCops);
	}
	@PostMapping("/saveFarmerDetail")
	public FarmerDetail saveFarmerDetail(@RequestBody FarmerDetail farmerDetail){
		 return userRepository.saveFarmerDetail(farmerDetail);
	}
	
	
	@GetMapping("/getElibleFarmerForOrder/{cropId}")
	public List<User> getElibleFarmerForOrder(@PathVariable("cropId") Integer cropId){
		return userRepository.getElibleFarmerForOrder(cropId);
	}
	
	@GetMapping("/getFarmerCrops/{farmerId}")
	public List<FarmerCrop> getFarmerCrops(@PathVariable("farmerId") Integer farmerId){
		return  userRepository.getFarmerCrops(farmerId);
	}
	@GetMapping("/getFarmerDetail/{farmerId}")
	public FarmerDetail getFarmerDetail(@PathVariable("farmerId") Integer farmerId){
		return  userRepository.getFarmerDetail(farmerId);
	}
	
	
}
