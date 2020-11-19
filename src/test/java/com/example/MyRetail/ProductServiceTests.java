package com.example.MyRetail;

import com.example.MyRetail.controller.ProductController;
import com.example.MyRetail.model.Price;
import com.example.MyRetail.model.Product;
import com.example.MyRetail.repository.ProductRepository;
import com.example.MyRetail.service.ProductService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@WebMvcTest(ProductController.class)
class ProductServiceTests {

	@MockBean
	ProductController productController;

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductService productService;

	@Test
	void successSaveProductTest() throws Exception {
		Product product = new Product();
		Price price = new Price();
		String id = "13860428";
		Mockito.when(productRepository.save(product)).thenReturn(product);
		price.setCurrencyCode("USD");
		price.setCurrentPrice("100");
		product.setPrice(price);
		product.setId(id);
		product.setTitle("The Big Lebowski (Blu-ray)");

		Product saved = productService.save(product, id);
		Assert.assertEquals(product, saved);
	}

	@Test
	void failureSaveProductTest() throws Exception {
		String expectedMessage = "java.util.InputMismatchException: Object Id does not match Id in URL";
		Product product = new Product();
		Price price = new Price();
		String id = "13860428";
		try {
			Mockito.when(productRepository.save(product)).thenReturn(product);
			price.setCurrencyCode("USD");
			price.setCurrentPrice("100");
			product.setPrice(price);
			product.setId("600");
			productService.save(product, id);
		}catch(RuntimeException e){
			Assert.assertEquals(expectedMessage, e.toString());
		}
	}

}
