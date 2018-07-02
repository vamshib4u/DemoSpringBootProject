package com.example.demo.dao;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductPrice;

@Repository
public interface ProductPriceRepository extends MongoRepository<ProductPrice, Serializable>{

}
