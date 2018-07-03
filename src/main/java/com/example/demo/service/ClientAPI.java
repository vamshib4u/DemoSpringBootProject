package com.example.demo.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.example.demo.entity.ProductApi;

public class ClientAPI {
	
	public ProductApi getProductDetails(String id) {
		ProductApi productApi = new ProductApi();
		try {
			String responseUrl = "https://redsky.target.com/v2/pdp/tcin/"+id;
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProductApi> result = restTemplate.getForEntity(responseUrl, ProductApi.class);
			productApi = result.getBody();
			System.out.println(result.toString());
		  } catch (Exception e) {
			e.printStackTrace();
		  }
		return productApi;
	}

}
