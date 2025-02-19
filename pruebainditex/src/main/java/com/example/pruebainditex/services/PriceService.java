package com.example.pruebainditex.services;

import java.time.LocalDateTime;

import com.example.pruebainditex.entities.PriceResponse;

public interface PriceService {
	PriceResponse findPriceByDateBrandAndProduct(LocalDateTime applicationDate, int brandId, int productId);

}
