package com.agriyo.services.agriyodb.agriyodbservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agriyo.services.agriyodb.agriyodbservice.model.Crop;
import com.agriyo.services.agriyodb.agriyodbservice.model.ProductCategory;
import com.agriyo.services.agriyodb.agriyodbservice.repository.CropRepository;
import com.agriyo.services.agriyodb.agriyodbservice.repository.ProductCategoryRepository;


@RestController
@RequestMapping("/crop")
public class CropResource {
	@Autowired
	private CropRepository cropRepository;
	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	@GetMapping("/getAllCropCategory")
	public List<ProductCategory> getAllCategory(){
		return productCategoryRepository.findByIsActive("1");
	}

	@GetMapping("/getCropByCategory/{categoryId}")
	public List<Crop> getCropByCategory(@PathVariable("categoryId") Integer categoryId){
		return cropRepository.findByCategoryIdAndIsActive(categoryId,"1");
	}
}
