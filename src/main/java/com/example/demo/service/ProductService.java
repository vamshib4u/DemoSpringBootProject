/**
 * 
 */
package com.example.demo.service;

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
	
	public ProductPrice getProductDetailsById(String id) {
		
		return repo.findOne("13860428");
	}

}
