/**
 * 
 */
package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductApi;
import com.example.demo.entity.ProductDetails;
import com.example.demo.entity.ProductPrice;
import com.example.demo.service.ClientAPI;
import com.example.demo.service.ProductService;

/**
 * @author vamshidhar
 *
 */
@RestController
@RequestMapping("/products")
public class MyRetailerController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ClientAPI clientApi;
	
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public ResponseEntity<ProductDetails> getPrice(@PathVariable("id") String id) {
		Optional<ProductPrice> price = productService.getProductDetailsById(id);
		ProductDetails productDetails = new ProductDetails();
		ProductApi productApi = clientApi.getProductDetails(id);
//		productDetails.se
		String title = "";
		
		if(!price.isPresent() && null == productApi.getProduct()) {
			return new ResponseEntity<ProductDetails>(productDetails, HttpStatus.NOT_FOUND);
		}
		
		productDetails.setId(id);
		if(price.isPresent()) {
			productDetails.setCurrency_code(price.get().getCurrency_code());
			productDetails.setValue(price.get().getValue());
		}
		if(null != productApi.getProduct()) {
			title = productApi.getProduct().getItem().getProduct_description().getTitle();
			productDetails.setTitle(title);
		}
		
		return new ResponseEntity<ProductDetails>(productDetails, HttpStatus.OK);
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductDetails> updatePrice(@RequestBody ProductDetails productDetails) {
		ProductApi productApi = clientApi.getProductDetails(productDetails.getId());
		if(null != productApi) {
			productDetails.getValue();
			ProductPrice price = new ProductPrice();
			price.setCurrency_code(productDetails.getCurrency_code());
			price.setId(productDetails.getId());
			price.setValue(productDetails.getValue());
			productService.updatePrice(price);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<ProductDetails>(productDetails, HttpStatus.OK);
	}
	
	

}
