package com.example.pruebainditex.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pruebainditex.entities.Price;

public interface PriceRepository extends JpaRepository<Price, Long> {
	
	@Query("SELECT p FROM Price p WHERE brandId = :brandId AND productId = :productId AND :applicationDate BETWEEN startDate AND endDate ORDER BY priority DESC LIMIT 1")
	Price findPriceByDateBrandAndProduct(LocalDateTime applicationDate, int brandId, int productId);

}