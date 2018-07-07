/**
 * 
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public ProductDetails getPrice(@PathVariable("id") String id) {
		ProductPrice price = productService.getProductDetailsById(id);
		ClientAPI api = new ClientAPI();
		ProductApi productApi = api.getProductDetails(id);
		String title = productApi.getProduct().getItem().getProduct_description().getTitle();
		ProductDetails productDetails = new ProductDetails(price.getId(), price.getValue(), price.getCurrency_code(), title);
		return productDetails;
	}

}
