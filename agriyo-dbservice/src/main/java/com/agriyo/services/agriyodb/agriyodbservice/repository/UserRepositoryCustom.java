package com.agriyo.services.agriyodb.agriyodbservice.repository;

import java.util.List;

import com.agriyo.services.agriyodb.agriyodbservice.model.FarmerCrop;
import com.agriyo.services.agriyodb.agriyodbservice.model.FarmerDetail;
import com.agriyo.services.agriyodb.agriyodbservice.model.User;
import com.agriyo.services.agriyodb.agriyodbservice.model.UserRequest;

public interface UserRepositoryCustom  {

	
	List<User> getElibleFarmerForOrder(Integer cropId);
	
	void saveFarmerCrops(List<FarmerCrop> farmerCops);
	FarmerDetail saveFarmerDetail(FarmerDetail farmerDetail);
	void saveUserRequest(UserRequest userRequest);

	FarmerDetail getFarmerDetail(Integer farmerDetailId);

	List<FarmerCrop> getFarmerCrops(Integer farmerId);
	

	
}

