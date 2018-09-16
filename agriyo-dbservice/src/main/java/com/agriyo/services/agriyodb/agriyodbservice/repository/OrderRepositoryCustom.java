package com.agriyo.services.agriyodb.agriyodbservice.repository;

import java.util.List;
import java.util.Set;

import com.agriyo.services.agriyodb.agriyodbservice.dto.SearchInput;
import com.agriyo.services.agriyodb.agriyodbservice.dto.SearchResult;
import com.agriyo.services.agriyodb.agriyodbservice.model.Order;
import com.agriyo.services.agriyodb.agriyodbservice.model.OrderAssign;

public interface OrderRepositoryCustom  {
	Set<Order> findAllAssginedOrders(Integer userId);
	List<Order> findByOrderByAssignedId(Integer farmerId);
	void saveAssignedOrder(List<OrderAssign> OrderAssign);
	
	List<SearchResult> search(SearchInput searchInput);
	
	
	
}

