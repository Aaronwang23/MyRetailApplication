package com.example.MyRetail.controller;

import com.example.MyRetail.model.Product;
import com.example.MyRetail.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.InputMismatchException;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "/{id}")
    public ResponseEntity getProduct(@PathVariable("id") String id){
        try {
            return new ResponseEntity<>(productService.getProduct(id), HttpStatus.ACCEPTED);
        }catch (Exception e){
            System.out.println(e);
        }
        return new ResponseEntity<>("", HttpStatus.ACCEPTED);
    }

    @PutMapping(value = "/{id}")
    public Product putProduct(@RequestBody Product productPrice, @PathVariable("id") String id) {
        if(id.equals(productPrice.id)) {
            return productService.save(productPrice, id);
        }
        throw new InputMismatchException("Object Id does not match Id in URL");
    }

}
