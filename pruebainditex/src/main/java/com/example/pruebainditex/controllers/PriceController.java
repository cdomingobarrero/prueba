package com.example.pruebainditex.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pruebainditex.entities.PriceResponse;
import com.example.pruebainditex.services.PriceService;

@RestController
public class PriceController {
	
	@Autowired
	PriceService priceService;
	
	@GetMapping("/precio")
	PriceResponse findPriceByDateBrandAndProduct(@RequestParam LocalDateTime applicationDate, @RequestParam int brandId, @RequestParam int productId) {
		return priceService.findPriceByDateBrandAndProduct(applicationDate, brandId, productId);
	}

}
