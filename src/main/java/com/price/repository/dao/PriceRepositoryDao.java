package com.price.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.price.exception.ParseException;
import com.price.model.PriceResult;
import com.price.model.PriceSearch;
import com.price.model.entity.Price;

@Repository
public interface PriceRepositoryDao extends JpaRepository<Price, Long>{
	

	PriceResult getData(PriceSearch priceSearch) throws ParseException;
	
		
}
