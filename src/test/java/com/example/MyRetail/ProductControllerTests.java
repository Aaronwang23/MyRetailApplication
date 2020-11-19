package com.example.MyRetail;

import com.example.MyRetail.controller.ProductController;
import com.example.MyRetail.model.Price;
import com.example.MyRetail.model.Product;
import com.example.MyRetail.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ProductController.class)
class ProductControllerTests {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @Test
    void successGetProductTest() throws Exception {
        Product product = new Product();
        Price price = new Price();
        String id = "13860428";
        Mockito.when(productService.getProduct(id)).thenReturn(product);
        price.setCurrencyCode("USD");
        price.setCurrentPrice("100");
        product.setPrice(price);
        product.setId(id);
        product.setTitle("The Big Lebowski (Blu-ray)");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/product/13860428");
        Assert.assertEquals(HttpStatus.ACCEPTED.value(), mockMvc.perform(requestBuilder).andReturn().getResponse().getStatus());
    }

    @Test
    void failureGetProductTest() throws Exception {
        Product product = new Product();
        Price price = new Price();
        String id = "13860428";
        Mockito.when(productService.getProduct(id)).thenReturn(product);
        price.setCurrencyCode("USD");
        price.setCurrentPrice("100");
        product.setPrice(price);
        product.setId(id);
        product.setTitle("The Big Lebowski (Blu-ray)");

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/products/200");
        Assert.assertEquals(HttpStatus.NOT_FOUND.value(), mockMvc.perform(requestBuilder).andReturn().getResponse().getStatus());
    }


    @Test
    void successPutProductTest() throws Exception {
        Product product = new Product();
        String id = "13860428";
        Mockito.when(productService.save(product, id)).thenReturn(product);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
                "/product/13860428")
                .accept(MediaType.APPLICATION_JSON)
                .content("{\"id\":13860428,\"name\":\"The Big Lebowski (Blu-ray)\",\"current_price\":{\"value\":300,\"currency_code\":\"USD\"}}")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        Assert.assertEquals(HttpStatus.ACCEPTED.value(), mockMvc.perform(requestBuilder).andReturn().getResponse().getStatus());
    }


    @Test
    void failurePutProductTest() throws Exception {
        Product product = new Product();
        String id = "13860428";
        Mockito.when(productService.save(product, id)).thenReturn(product);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.put(
                "/product/13860428")
                .accept(MediaType.APPLICATION_JSON)
                .content("400")
                .contentType(MediaType.APPLICATION_JSON_VALUE);

        Assert.assertEquals(HttpStatus.BAD_REQUEST.value(), mockMvc.perform(requestBuilder).andReturn().getResponse().getStatus());

    }

}
