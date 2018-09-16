package com.agriyo.services.agriyodb.agriyodbservice.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@Entity
@Table(name="t_order")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonInclude(Include.NON_NULL)
public class Order {
	
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	
	@Column(name="ORDER_DATE")
	private Date orderDate;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="ORDER_PLACED_BY")
	@Column(name="ORDER_PLACED_BY")
	private Integer orderPlacedBy;

	//@ManyToOne(fetch=FetchType.LAZY)
	//@JoinColumn(name="ORDER_RECEIVED_BY")
	@Column(name="ORDER_RECEIVED_BY")
	private Integer orderReceivedBy;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.REFRESH)
	@JoinColumn(name="CROP_ID")
	private Crop crop;
	
	private Date orderDueDate;
	
	private String description;
	
	/*@OneToMany
	@JoinColumn(name="order_id")
	private List<OrderAssign> orderAssigns;
	*/
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public Date getOrderDueDate() {
		return orderDueDate;
	}

	public void setOrderDueDate(Date orderDueDate) {
		this.orderDueDate = orderDueDate;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrderPlacedBy() {
		return orderPlacedBy;
	}

	public void setOrderPlacedBy(Integer orderPlacedBy) {
		this.orderPlacedBy = orderPlacedBy;
	}

	public Integer getOrderReceivedBy() {
		return orderReceivedBy;
	}

	public void setOrderReceivedBy(Integer orderReceivedBy) {
		this.orderReceivedBy = orderReceivedBy;
	}

	private Integer quantity;
	
	private String status;
	
	
}
