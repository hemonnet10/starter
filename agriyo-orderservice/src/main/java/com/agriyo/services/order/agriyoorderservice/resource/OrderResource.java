package com.agriyo.services.order.agriyoorderservice.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/orders")
public class OrderResource {

	@Autowired
    RestTemplate restTemplate;

	 
	@GetMapping("/getAllReceivedOrder/{userId}")
	    public ResponseEntity<String> getAllOrderByUserId(@PathVariable("userId") Long userId ) {
		 HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
			   
	        ResponseEntity<String> quoteResponse = restTemplate.exchange("http://agriyo-dbservice/orders/getAllReceivedOrder/"+userId,
	        		HttpMethod.GET,
	        		httpEntity, new ParameterizedTypeReference<String>() {
	                });
	       return  quoteResponse;
	       
	    }

	@GetMapping("/getAllPlacedOrder/{userId}")
    public ResponseEntity<String> getAllPlacedOrder(@PathVariable("userId") Long userId ) {
	 HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
		   
        ResponseEntity<String> quoteResponse = restTemplate.exchange("http://agriyo-dbservice/orders/getAllPlacedOrder/"+userId,
        		HttpMethod.GET,
        		httpEntity, new ParameterizedTypeReference<String>() {
                });
       return  quoteResponse;
       
    }
	
	
	@PostMapping("/create")
    public ResponseEntity<String> saveOrder(@RequestBody String order) {
	HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> httpEntity = new HttpEntity<String>(order, headers);

	
        ResponseEntity<String> quoteResponse = restTemplate.exchange("http://agriyo-dbservice/orders/create",
        		HttpMethod.POST,
        		httpEntity, new ParameterizedTypeReference<String>() {
                });
       return  quoteResponse;
       
    }
	
	@PostMapping("/update")
    public ResponseEntity<String> saveReceive(@RequestBody String order) {
	HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> httpEntity = new HttpEntity<String>(order, headers);

	
        ResponseEntity<String> quoteResponse = restTemplate.exchange("http://agriyo-dbservice/orders/update",
        		HttpMethod.POST,
        		httpEntity, new ParameterizedTypeReference<String>() {
                });
       return  quoteResponse;
       
    }
	


}


