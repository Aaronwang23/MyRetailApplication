package com.example.MyRetail.service;

import com.example.MyRetail.model.Product;
import com.example.MyRetail.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RedSkyRestService redSkyRestService;

    ObjectMapper mapper = new ObjectMapper();

    private Product mapJsonToProduct(String id) throws JsonProcessingException {
        JsonNode jsonNode = readRedSkyJson(id);
        return new Product(id, jsonNode.get("product").get("item").get("product_description").get("title").asText());
    }

    private JsonNode readRedSkyJson(String id) throws JsonProcessingException {
        return mapper.readTree(redSkyRestService.getRedSkyJson(id));
    }

    public Product getProduct(String id) throws JsonProcessingException {
        Product product = mapJsonToProduct(id);
        if(productRepository.findByid(id)!=null) {
            product.setPrice(productRepository.findByid(id).getPrice());
        }
        return product;
    }

    public Product save(Product product, String id) {
        if(!id.equals(product.getId())) {
            throw new InputMismatchException("Object Id does not match Id in URL");
        }
        return productRepository.save(product);
    }

}
