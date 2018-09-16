package com.agriyo.services.user.agriyouserservice.resource;

import java.util.Arrays;

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
@RequestMapping("/users")
public class UserResource {

	@Autowired
    RestTemplate restTemplate;

	 
	@PostMapping("/getUserByMobileAndPassword")
	    public ResponseEntity<String> getUserByMobileAndPassword(@RequestBody String user) {
		 HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    HttpEntity<String> httpEntity = new HttpEntity<String>(user, headers);
			   
	        ResponseEntity<String> quoteResponse = restTemplate.exchange("http://agriyo-dbservice/users/getUserByMobileAndPassword",
	        		HttpMethod.POST,
	        		httpEntity, new ParameterizedTypeReference<String>() {
	                });
	       return  quoteResponse;
	       
	    }
	
	@PostMapping("/create")
    public ResponseEntity<String> saveUser(@RequestBody String user) {
	HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    HttpEntity<String> httpEntity = new HttpEntity<String>(user, headers);

	
        ResponseEntity<String> quoteResponse = restTemplate.exchange("http://agriyo-dbservice/users/create",
        		HttpMethod.POST,
        		httpEntity, new ParameterizedTypeReference<String>() {
                });
       return  quoteResponse;
       
    }
	


}


