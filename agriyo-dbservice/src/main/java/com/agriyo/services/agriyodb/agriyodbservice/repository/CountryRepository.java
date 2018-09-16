package com.agriyo.services.agriyodb.agriyodbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agriyo.services.agriyodb.agriyodbservice.model.Country;

public interface CountryRepository extends JpaRepository<Country, Integer>,MasterRepositoryCustom {

}

