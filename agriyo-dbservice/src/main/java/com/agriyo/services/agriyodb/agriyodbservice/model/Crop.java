package com.agriyo.services.agriyodb.agriyodbservice.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="m_crop_product")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Crop{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	
	/*@JsonIgnore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CATEGORY_ID")
	private ProductCategory productCategory;
	*/
	@Column(name="CATEGORY_ID")
	private Integer categoryId;
	@Column(name="CROP_NAME")
	private String cropName;
	@JsonIgnore
	private String quality;
	@JsonIgnore
	@Column(name="IS_ACTIVE")
	private String isActive;
	
	/*@JsonIgnore
	@OneToMany(fetch=FetchType.LAZY)
	private List<FarmerCrop> eligibleFarmers;
	*/
	
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCropName() {
		return cropName;
	}
	public void setCropName(String cropName) {
		this.cropName = cropName;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
}