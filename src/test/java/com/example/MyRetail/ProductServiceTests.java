package com.example.MyRetail;

import com.example.MyRetail.controller.ProductController;
import com.example.MyRetail.model.Price;
import com.example.MyRetail.model.Product;
import com.example.MyRetail.repository.ProductRepository;
import com.example.MyRetail.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
class ProductServiceTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	public void testSearchProduct() {
	}
}
