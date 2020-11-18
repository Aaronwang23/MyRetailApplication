package com.example.MyRetail.service;

import com.example.MyRetail.model.Price;
import com.example.MyRetail.model.Product;
import com.example.MyRetail.repository.ProductRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    RedSkyRestService redSkyRestService;

    ObjectMapper mapper = new ObjectMapper();
    Map<String, Map> map;

    public Product convertJsonToProduct(String id) throws JsonProcessingException {
            Product product;
            map = mapper.readValue(redSkyRestService.getRedSkyJson(id), Map .class);
            Map<String, Map> productMap = map.get("product");
            Map<String, Map> itemMap = productMap.get("item");
            Map<String, String> productDescriptionMap = itemMap.get("product_description");
            product = new Product(id,productDescriptionMap.get("title"),new Price(null,null));
            return product;
    }

    public Product getProduct(String id) throws JsonProcessingException {
        Product product = convertJsonToProduct(id);
        redSkyRestService.getRedSkyJson(id);
        return product;
    }

    public Product save(Product product, String id) {
        return productRepository.save(product);
    }

}
