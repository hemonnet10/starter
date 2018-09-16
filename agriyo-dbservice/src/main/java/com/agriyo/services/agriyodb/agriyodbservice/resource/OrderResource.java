package com.agriyo.services.agriyodb.agriyodbservice.resource;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agriyo.services.agriyodb.agriyodbservice.dto.SearchInput;
import com.agriyo.services.agriyodb.agriyodbservice.dto.SearchResult;
import com.agriyo.services.agriyodb.agriyodbservice.model.BaseBO;
import com.agriyo.services.agriyodb.agriyodbservice.model.FarmerCrop;
import com.agriyo.services.agriyodb.agriyodbservice.model.Order;
import com.agriyo.services.agriyodb.agriyodbservice.model.OrderAssign;
import com.agriyo.services.agriyodb.agriyodbservice.model.User;
import com.agriyo.services.agriyodb.agriyodbservice.repository.OrderRepository;


@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/getAllReceivedOrder/{userId}")
	public Set<Order> getAllReceivedOrder(@PathVariable("userId") Integer userId){
		
		Set<Order> orderSet=orderRepository.findAllAssginedOrders(userId);
		orderSet.addAll(orderRepository.findByOrderReceivedBy(userId));
		return orderSet;
	}
	
	@GetMapping("/getAllOrders")
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	//@GetMapping("/getAllAssignedOrder/{userId}")
	public List<Order> getAllAssignedOrder(@PathVariable("userId") Integer userId){
		return orderRepository.findByOrderByAssignedId(userId);
	}	
	@GetMapping("/getAllPlacedOrder/{userId}")
	public List<Order> getAllPlacedOrder(@PathVariable("userId") Integer userId){
		return orderRepository.findByOrderPlacedBy(userId);
	}
	
	
	@PostMapping("/create")
	@Transactional
    public BaseBO saveOrder(@RequestBody Order order) {
		System.out.println("in order create");
		BaseBO baseBO= new BaseBO();
		order.setStatus("Open");
		orderRepository.save(order);
		baseBO.setMessage("Order Created successfully");
		return baseBO;
	}
	@PostMapping("/update")
    public BaseBO updateOrder(@RequestBody Order order) {
		BaseBO baseBO= new BaseBO();
		Order tempOrder=orderRepository.getOne(order.getId());
		tempOrder.setStatus(order.getStatus());
		orderRepository.save(tempOrder);
		baseBO.setMessage("Order Created successfully");
		return baseBO;
	}
	
	@PostMapping("/assign")
    public BaseBO assignOrder(@RequestBody List<OrderAssign> orderAssignList) {
		BaseBO baseBO= new BaseBO();
		
	 orderRepository.saveAssignedOrder(orderAssignList);
	 baseBO.setMessage("Order Assigned successfully.");
	 return baseBO;
	}
	
	@PostMapping("/search")
    public List<SearchResult> search(@RequestBody SearchInput searchInput) {
		System.out.println("in search");
		List<SearchResult> list= orderRepository.search(searchInput);
		return list;
	}
	
}
