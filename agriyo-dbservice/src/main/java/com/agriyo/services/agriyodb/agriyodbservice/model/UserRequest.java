package com.agriyo.services.agriyodb.agriyodbservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="t_user_request")
public class UserRequest{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Long id;
	@Column(name="REQUEST_TYPE")
	private String requestType;
	@Column(name="USER_ID")
	private Integer userId;
	@Column(name="DISCRIPTION")
	private String discription;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
}
