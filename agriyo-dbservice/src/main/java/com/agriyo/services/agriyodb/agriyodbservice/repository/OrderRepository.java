package com.agriyo.services.agriyodb.agriyodbservice.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agriyo.services.agriyodb.agriyodbservice.model.Order;
import com.agriyo.services.agriyodb.agriyodbservice.model.User;

//@Transactional
public interface OrderRepository extends JpaRepository<Order, Integer>,OrderRepositoryCustom {

	List<Order> findByOrderPlacedBy(Integer userId);
	Set<Order> findByOrderReceivedBy(Integer userId);
	
	
}

