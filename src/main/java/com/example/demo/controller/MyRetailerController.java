/**
 * 
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ProductPrice;
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
	public ProductPrice getPrice(@PathVariable("id") String id) {
		ProductPrice price = productService.getProductDetailsById(id);
		
		return price;
	}

}
