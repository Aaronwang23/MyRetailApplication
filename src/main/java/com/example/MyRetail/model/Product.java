package com.example.MyRetail.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "Product")
public class Product {
    @Id
    public String id;
    public String title;
    public Price price;

    public Product() {}

    public Product (String id, String title){
        this.id = id;
        this.title = title;
    }

}