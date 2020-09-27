package com.example.productcatalogservice;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.example.productcatalogservice.model.Product;
import com.example.productcatalogservice.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class ProductcatalogserviceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductRepository mockRepository;
	
	@BeforeEach
	public void init() {
		List<Product> products = createSampleListOfProducts();
		when(mockRepository.findByColorId(1)).thenReturn(products);
	}
	
	@Test
	public void find_employeeId_OK() throws Exception {
		// @formatter:off
		mockMvc.perform(
				get("/api/products/search/color/1")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON))
				.andDo(print())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				;
		// @formatter:on
		verify(mockRepository, times(1)).findByColorId(1);
	}


	private List<Product> createSampleListOfProducts() {
		List<Product> products= new ArrayList<Product>();
		Product product=new Product();
		product.setId(1L);
		product.setColorId(1);
		product.setName("AddidasShoe");
		
		Product product2=new Product();
		product2.setId(2L);
		product2.setColorId(3);
		product2.setName("nikecap");
		
		products.add(product);
		products.add(product2);
		
		return products;
	}
	
	

}
