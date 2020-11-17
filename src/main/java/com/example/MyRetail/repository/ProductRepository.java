package com.example.MyRetail.repository;

import com.example.MyRetail.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByid(@Param("id")String id);
}
