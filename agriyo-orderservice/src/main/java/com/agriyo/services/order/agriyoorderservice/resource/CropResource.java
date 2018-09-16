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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
@RequestMapping("/crop")
public class CropResource {

	@Autowired
    RestTemplate restTemplate;

	 
	@GetMapping("/getAllCropCategory")
	    public ResponseEntity<String> getAllCropCategory() {
		 HttpHeaders headers = new HttpHeaders();
		    headers.setContentType(MediaType.APPLICATION_JSON);
		    HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
			   
	        ResponseEntity<String> quoteResponse = restTemplate.exchange("http://agriyo-dbservice/crop/getAllCropCategory",
	        		HttpMethod.GET,
	        		httpEntity, new ParameterizedTypeReference<String>() {
	                });
	       return  quoteResponse;
	       
	    }
	
	@GetMapping("/getCropByCategory/{categoryId}")
    public ResponseEntity<String> getAllCropCategory(@PathVariable("categoryId") Integer categoryId) {
	 HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    HttpEntity<String> httpEntity = new HttpEntity<String>(null, headers);
		   
        ResponseEntity<String> quoteResponse = restTemplate.exchange("http://agriyo-dbservice/crop/getCropByCategory/"+categoryId,
        		HttpMethod.GET,
        		httpEntity, new ParameterizedTypeReference<String>() {
                });
       return  quoteResponse;
       
    }
	


}


