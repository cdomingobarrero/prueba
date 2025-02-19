package com.example.pruebainditex.mappers;

import com.example.pruebainditex.entities.Price;
import com.example.pruebainditex.entities.PriceResponse;

public class PriceToPriceResponseMapper {
	
	public static PriceResponse map(Price price) {
		PriceResponse priceResponse = new PriceResponse();
		
		priceResponse.setBrandId(price.getBrandId());
		priceResponse.setEndDate(price.getEndDate());
		priceResponse.setPrice(price.getPrice());
		priceResponse.setPriceList(price.getPriceList());
		priceResponse.setProductId(price.getProductId());
		priceResponse.setStartDate(price.getStartDate());
		
		return priceResponse;
	}

}
