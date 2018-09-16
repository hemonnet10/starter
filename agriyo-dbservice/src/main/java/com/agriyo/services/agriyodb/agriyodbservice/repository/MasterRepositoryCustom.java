package com.agriyo.services.agriyodb.agriyodbservice.repository;

import java.util.List;

import com.agriyo.services.agriyodb.agriyodbservice.model.Country;
import com.agriyo.services.agriyodb.agriyodbservice.model.District;
import com.agriyo.services.agriyodb.agriyodbservice.model.State;

public interface MasterRepositoryCustom  {

	
	List<Country> fetchAllCountries(String status);
	List<State> fetchAllStates(Integer cid,String status);
	List<District> fetchAllDistrict(Integer sid,String status);


	
}

