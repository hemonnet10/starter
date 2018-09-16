package com.agriyo.services.agriyodb.agriyodbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agriyo.services.agriyodb.agriyodbservice.model.Crop;
public interface CropRepository extends JpaRepository<Crop, Integer> {

	List<Crop> findByCategoryIdAndIsActive(Integer categoryId,String status);
	List<Crop> findByCropName(String cropName);
	


}

