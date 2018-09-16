package com.agriyo.services.agriyodb.agriyodbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "t_farmer_detail")
public class FarmerDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	// @JsonIgnoreProperties("farmerDetail")
	//@OneToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name = "FARMER_ID", nullable = false)
	@Column(name = "FARMER_ID")
	private Integer farmerId;

	@Column(name = "LAND_SIZE")
	private Double landSize;

	@Column(name = "NEAREST_MANDI")
	private String nearestMandi;

	@Column(name = "LAND_UNIT")
	private String landUnit;
	@Column(name = "IS_LAND_AVAILABLE")
	private String isLandAvailable;
	@Column(name = "NEAREST_MARKET")
	private String nearestMarket;
	@Column(name = "FARMING_TYPE")
	private String farmingType;
	@Column(name = "PROFESSION")
	private String profession;
	@Column(name = "INCOME")
	private String income;
	@Column(name = "FAMILY_MEMBER")
	private String familyMember;
	@Column(name = "ADHAAR")
	private String adhaar;
	@Column(name = "BANK_ACCOUNT")
	private String bankAccount;
	@Column(name = "IS_ASSET_AVAILABLE")
	private String isAssetAvailable;
	@Column(name = "ASSET_TYPE")
	private String assetType;
	@Column(name = "ASSET")
	private String asset;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Double getLandSize() {
		return landSize;
	}
	public void setLandSize(Double landSize) {
		this.landSize = landSize;
	}
	public String getNearestMandi() {
		return nearestMandi;
	}
	public void setNearestMandi(String nearestMandi) {
		this.nearestMandi = nearestMandi;
	}
	public String getLandUnit() {
		return landUnit;
	}
	public void setLandUnit(String landUnit) {
		this.landUnit = landUnit;
	}
	public String getIsLandAvailable() {
		return isLandAvailable;
	}
	public void setIsLandAvailable(String isLandAvailable) {
		this.isLandAvailable = isLandAvailable;
	}
	public String getNearestMarket() {
		return nearestMarket;
	}
	public void setNearestMarket(String nearestMarket) {
		this.nearestMarket = nearestMarket;
	}
	public String getFarmingType() {
		return farmingType;
	}
	public void setFarmingType(String farmingType) {
		this.farmingType = farmingType;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getFamilyMember() {
		return familyMember;
	}
	public void setFamilyMember(String familyMember) {
		this.familyMember = familyMember;
	}
	public String getAdhaar() {
		return adhaar;
	}
	public void setAdhaar(String adhaar) {
		this.adhaar = adhaar;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getIsAssetAvailable() {
		return isAssetAvailable;
	}
	public void setIsAssetAvailable(String isAssetAvailable) {
		this.isAssetAvailable = isAssetAvailable;
	}
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public Integer getFarmerId() {
		return farmerId;
	}
	public void setFarmerId(Integer farmerId) {
		this.farmerId = farmerId;
	}

}
