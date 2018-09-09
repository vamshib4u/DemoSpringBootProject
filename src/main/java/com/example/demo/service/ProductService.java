/**
 * 
 */
package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductPriceRepository;
import com.example.demo.entity.ProductPrice;

/**
 * @author vamshidhar
 *
 */
@Service
public class ProductService {
	
	@Autowired
	ProductPriceRepository repo;
	
	public Optional<ProductPrice> getProductDetailsById(String id) {
		
		return repo.findById(id);
	}
	
	public ProductPrice updatePrice(ProductPrice price) {
		return repo.save(price);
	}

}
