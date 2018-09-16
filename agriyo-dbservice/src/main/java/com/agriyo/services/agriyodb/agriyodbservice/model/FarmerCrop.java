package com.agriyo.services.agriyodb.agriyodbservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_farmer_crop")
public class FarmerCrop implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY)
	private Crop crop;

	private Integer volume;
	private Double price;
	private String unit;

	@Column(name = "FARMER_ID")
	private Integer farmerId;

	@Column(name = "SEED_GROWING_MONTH")
	private String seedGrowingMonth;
	@Column(name = "CROP_SHOWING_MONTH")
	private String cropShowingMonth;
	@Column(name = "SEASON")
	private String season;
	@Column(name = "YEAR")
	private String year;
	@Column(name = "FIELD_SIZE")
	private Integer fieldSize;
	@Column(name = "FIELD_UNIT")
	private String fieldUnit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public Integer getFarmerId() {
		return farmerId;
	}

	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getSeedGrowingMonth() {
		return seedGrowingMonth;
	}

	public void setSeedGrowingMonth(String seedGrowingMonth) {
		this.seedGrowingMonth = seedGrowingMonth;
	}

	public String getCropShowingMonth() {
		return cropShowingMonth;
	}

	public void setCropShowingMonth(String cropShowingMonth) {
		this.cropShowingMonth = cropShowingMonth;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public Integer getFieldSize() {
		return fieldSize;
	}

	public void setFieldSize(Integer fieldSize) {
		this.fieldSize = fieldSize;
	}

	public String getFieldUnit() {
		return fieldUnit;
	}

	public void setFieldUnit(String fieldUnit) {
		this.fieldUnit = fieldUnit;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}