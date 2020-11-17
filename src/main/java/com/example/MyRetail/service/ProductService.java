package com.example.MyRetail.service;

import com.example.MyRetail.model.Price;
import com.example.MyRetail.model.Product;
import com.example.MyRetail.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product getProduct(String id){
        Product product = productRepository.findByid(id);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Map> map;
        WebClient webClient = WebClient.create();

        try {
            String responseJson = webClient.get()
                    .uri("https://redsky.target.com/v3/pdp/tcin/" + id + "?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics&key=candidate")
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();
            map = mapper.readValue(responseJson, Map.class);
            Map<String, Map> productMap = map.get("product");
            Map<String, Map> itemMap = productMap.get("item");
            Map<String, String> productDescriptionMap = itemMap.get("product_description");
            product = new Product(id,productDescriptionMap.get("title"),new Price(null,null));
        }catch (Exception e){
            System.out.println(e);
        }
        return product;
    }

    public Product save(Product product, String id) {

        if(productRepository.findByid(id)!=null) {
            productRepository.delete(productRepository.findByid(id));
        }
        productRepository.save(product);
        return product;
    }

}
