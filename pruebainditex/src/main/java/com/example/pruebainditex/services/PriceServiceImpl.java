package com.example.pruebainditex.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pruebainditex.entities.Price;
import com.example.pruebainditex.entities.PriceResponse;
import com.example.pruebainditex.mappers.PriceToPriceResponseMapper;
import com.example.pruebainditex.repositories.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService{
	
	@Autowired
	PriceRepository priceRepository;

	@Override
	public PriceResponse findPriceByDateBrandAndProduct(LocalDateTime applicationDate, int brandId, int productId) {
		PriceResponse priceResponse = new PriceResponse();
		Price price = priceRepository.findPriceByDateBrandAndProduct(applicationDate, brandId, productId);
		
		if (price != null) {
			priceResponse = PriceToPriceResponseMapper.map(price);
		}
		
		return priceResponse;
	}

}
