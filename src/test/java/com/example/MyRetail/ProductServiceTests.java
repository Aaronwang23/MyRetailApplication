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
		webTestClient.get().uri("Product/13860428")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isOk()
				.expectHeader().contentType(MediaType.APPLICATION_JSON);
//				.bindToServer()
//				.baseUrl("http://localhost:8080")
//				.build()
//				.post()
//				.uri("Product/13860428")
//				.exchange()
//				.expectStatus().isCreated()
//				.expectHeader().valueEquals("Content-Type", "application/json")
//				.expectBody().isEmpty();
	}

//	@Before
//	public void setUp() throws Exception {
//		User user1= new User("Alice", 23);
//		User user2= new User("Bob", 38);
//		//save product, verify has ID value after save
//		assertNull(user1.getId());
//		assertNull(user2.getId());//null before save
//		this.userMongoRepository.save(user1);
//		this.userMongoRepository.save(user2);
//		assertNotNull(user1.getId());
//		assertNotNull(user2.getId());
//	}

}
