package com.example.pruebainditex.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.pruebainditex.entities.PriceResponse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void Test1(){
		//Test 1: peticion a las 10:00 del dia 14 del producto 35455 para la brand 1 (ZARA)           
		ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/precio?applicationDate={applicationDate}&brandId={brandId}&productId={productId}",
																			PriceResponse.class, 
																			LocalDateTime.of(2020,6,14,10,0,0), 1, 35455);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(1, response.getBody().getPriceList());
		assertEquals(LocalDateTime.of(2020,6,14,0,0,0), response.getBody().getStartDate());
		assertEquals(LocalDateTime.of(2020,12,31,23,59,59), response.getBody().getEndDate());
		assertEquals(35.5, response.getBody().getPrice());
		
	}
	
	@Test
	public void Test2(){
		//Test 2: peticion a las 16:00 del dia 14 del producto 35455 para la brand 1 (ZARA)           
		ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/precio?applicationDate={applicationDate}&brandId={brandId}&productId={productId}",
																			PriceResponse.class,
																			LocalDateTime.of(2020,6,14,16,0,0), 1, 35455);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(2, response.getBody().getPriceList());
		assertEquals(LocalDateTime.of(2020,6,14,15,0,0), response.getBody().getStartDate());
		assertEquals(LocalDateTime.of(2020,6,14,18,30,0), response.getBody().getEndDate());
		assertEquals(25.45, response.getBody().getPrice());
		
	}
	
	@Test
	public void Test3(){
		//Test 3: peticion a las 21:00 del dia 14 del producto 35455 para la brand 1 (ZARA)
		ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/precio?applicationDate={applicationDate}&brandId={brandId}&productId={productId}", 
																			PriceResponse.class,
																			LocalDateTime.of(2020,6,14,21,0,0), 1, 35455);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(1, response.getBody().getPriceList());
		assertEquals(LocalDateTime.of(2020,6,14,0,0,0), response.getBody().getStartDate());
		assertEquals(LocalDateTime.of(2020,12,31,23,59,59), response.getBody().getEndDate());
		assertEquals(35.5, response.getBody().getPrice());
		
	}
	
	@Test
	public void Test4(){
		// Test 4: peticion a las 10:00 del dia 15 del producto 35455 para la brand 1 (ZARA)
		ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/precio?applicationDate={applicationDate}&brandId={brandId}&productId={productId}",
																			PriceResponse.class,
																			LocalDateTime.of(2020,6,15,10,0,0), 1, 35455);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(3, response.getBody().getPriceList());
		assertEquals(LocalDateTime.of(2020,6,15,0,0,0), response.getBody().getStartDate());
		assertEquals(LocalDateTime.of(2020,6,15,11,0,0), response.getBody().getEndDate());
		assertEquals(30.5, response.getBody().getPrice());
		
	}
	
	@Test
	public void Test5(){
		// Test 5: peticion a las 21:00 del dia 16 del producto 35455 para la brand 1 (ZARA)
		ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/precio?applicationDate={applicationDate}&brandId={brandId}&productId={productId}",
																			PriceResponse.class,
																			LocalDateTime.of(2020,6,16,21,0,0), 1, 35455);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(35455, response.getBody().getProductId());
		assertEquals(1, response.getBody().getBrandId());
		assertEquals(4, response.getBody().getPriceList());
		assertEquals(LocalDateTime.of(2020,6,15,16,0,0), response.getBody().getStartDate());
		assertEquals(LocalDateTime.of(2020,12,31,23,59,59), response.getBody().getEndDate());
		assertEquals(38.95, response.getBody().getPrice());
		
	}
	
}
