package com.price.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.price.exception.InvalidRequestException;
import com.price.exception.PriceNotFoundException;
import com.price.model.PriceResult;
import com.price.model.PriceSearch;
import com.price.service.PriceService;

@RequestMapping (value="price")
@RestController
public class PriceController{
	
	private PriceService priceService;
	
	@Autowired 
	public PriceController(PriceService priceService) {
		this.priceService = priceService;
	}
	
	@GetMapping(value="search/")
	public PriceResult getData(@RequestBody PriceSearch priceSearch) {
		PriceResult priceResult;
		if (priceSearch == null) {
			throw new InvalidRequestException("Invalid input parameters");
		}
		priceResult = priceService.getPriceByParams(priceSearch);

		if (priceResult == null) {
			throw new PriceNotFoundException("Price not found with brandId: " + priceSearch.getBrandId() + ", productID: " + priceSearch.getProductId() + ", date: " + priceSearch.getDate());
		}

		return priceResult;
	}

}
