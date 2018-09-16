package com.agriyo.services.agriyodb.agriyodbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agriyo.services.agriyodb.agriyodbservice.model.ProductCategory;
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

	List<ProductCategory> findByIsActive(String status);



}

