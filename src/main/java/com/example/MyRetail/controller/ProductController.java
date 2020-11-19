package com.example.MyRetail.controller;

import com.example.MyRetail.model.Product;
import com.example.MyRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController{

    @Autowired
    ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getProduct(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(productService.getProduct(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity putProduct(@RequestBody Product product, @PathVariable("id") String id) {
        try {
            return new ResponseEntity<>(productService.save(product, id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
