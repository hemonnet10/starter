package com.agriyo.services.agriyodb.agriyodbservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agriyo.services.agriyodb.agriyodbservice.model.Country;
import com.agriyo.services.agriyodb.agriyodbservice.model.District;
import com.agriyo.services.agriyodb.agriyodbservice.model.State;
import com.agriyo.services.agriyodb.agriyodbservice.repository.CountryRepository;


@RestController
@RequestMapping("/master")
public class MasterResource {
	
	@Autowired
	private CountryRepository masterDataRepository;

	@GetMapping("/getAllCountry")
	public List<Country> getAllCountry(){
		return masterDataRepository.fetchAllCountries("1");
	}

	@GetMapping("/getAllState/{countryId}")
	public List<State> getAllState(@PathVariable("countryId") Integer countryId){
		return masterDataRepository.fetchAllStates(countryId,"1");
	}
	
	@GetMapping("/getAllDistrict/{stateId}")
	public List<District> getAllDistrict(@PathVariable("stateId") Integer stateId){
		return masterDataRepository.fetchAllDistrict(stateId,"1");
	}
}
