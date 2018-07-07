package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.example.demo.entity.ProductApi;
import com.example.demo.entity.StatusObject;

@Service
public class ClientAPI {
	
	public ProductApi getProductDetails(String id) {
		ProductApi productApi = new ProductApi();
		StatusObject statusObject = new StatusObject();
		try {
			String responseUrl = "https://redsky.target.com/v2/pdp/tcin/"+id;
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProductApi> result = restTemplate.getForEntity(responseUrl, ProductApi.class);
			productApi = result.getBody();
			statusObject.setSuccess(true);
//			productApi.setStatusObject(statusObject);
//			System.out.println(result.toString());
		  } catch (Exception e) {
//			statusObject.setSuccess(false);
//			statusObject.setErrorMessage(e.getMessage());
//			productApi.setStatusObject(statusObject);
			  //TO-DO
		  }
		return productApi;
	}

}
