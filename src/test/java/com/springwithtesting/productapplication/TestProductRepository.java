package com.springwithtesting.productapplication;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import com.springwithtesting.productapplication.model.Product;
import com.springwithtesting.productapplication.repository.ProductRepository;

@DataJpaTest
@ActiveProfiles("test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestProductRepository {

	@Autowired
	private ProductRepository productrepo;
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	@Order(1)
	void testrepo() {
		org.junit.jupiter.api.Assertions.assertNotNull(productrepo);
		org.junit.jupiter.api.Assertions.assertNotNull(entityManager);
	}
	
	@Test
	@Order(2)
	void givenProduct_saveProduct() {
		Product product = new Product("camera", "good quality", 7000.57);
		entityManager.persist(product);
//		productrepo.save(product);
		List<Product> productget = productrepo.findAll();
		assertThat(productget).hasSize(1);
		assertThat(product)
		.hasFieldOrPropertyWithValue("productname", "camera")
		.hasFieldOrPropertyWithValue("productinfo", "good quality")
		.hasFieldOrPropertyWithValue("productprice", 7000.57)
		.hasNoNullFieldsOrProperties();
//		.hasAllNullFieldsOrProperties();
		assertThat(product.getProductinfo()).matches("good quality");
	}

	@Test
	@Order(3)
	void givenProductId_getProduct() {
		Product product = productrepo.getById(1);
		assertThat(product.getProductid()).isEqualTo(1);
	}
	
	@Test
	@Order(4)
	void getListOfProducts() {
		Product product1 = new Product("camera", "good quality", 7000.57);
		entityManager.persist(product1);
		Product product2 = new Product("lens", "good quality", 1000.17);
		entityManager.persist(product2);
		Product product3 = new Product("shampoo", "good quality,smooth hair,hairfall rescue", 500.77);
		entityManager.persist(product3);
		Product product4 = new Product("fountain pen", "good quality,smooth flow,light weight,firm grip", 200.74);
		entityManager.persist(product4);
		Product product5 = new Product("pencil", "good quality,smooth writing", 50.55);
		entityManager.persist(product5);
		List<Product> products = productrepo.findAll();
//		assertThat(products).isEmpty();
//		assertThat(products).isNull();
//		assertThat(products).isNullOrEmpty();
//		assertThat(products).isNotEmpty();
		assertThat(products).isNotNull().hasSizeGreaterThan(1);
	}
	
	
}
