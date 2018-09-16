package com.agriyo.services.agriyodb.agriyodbservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



@Entity
@Table(name="t_user")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer id;
	private String name;
	private String gender;
	private String mobile;
	private String mobile2;
	private String email;

	@Column(name="auth_id")
	private String authId;
	private String password;
	@OneToOne
	@JoinColumn(name="role_id")
	private Role role;
	private String village;
	private String city;
	private String country;
	private String state;
	private String pincode;
	private Date dob;

	@Column(name="IS_ACTIVE")
	private String isActive;
	@Column(name="CREATED_BY")
	private String createdBy;
	@Column(name="CREATE_TIME")
	private String createdTime;

	
	@Column(name="COMPANY_NAME")
	private String companyName;
	@Column(name="COMPANY_TYPE")
	private String companyType;
	@Column(name="CIN")
	private String cin;
	@Column(name="DESIGNATION")
	private String designation;

	
	/*@JsonIgnoreProperties("farmerCrops")
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.REMOVE,mappedBy = "farmer")
	private List<FarmerCrop> farmerCrops;
	@JsonIgnoreProperties("farmer")
	@OneToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL, mappedBy = "farmer")
	private FarmerDetail farmerDetail;
*/
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getMobile2() {
		return mobile2;
	}
	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getVillage() {
		return village;
	}
	public void setVillage(String village) {
		this.village = village;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyType() {
		return companyType;
	}
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
