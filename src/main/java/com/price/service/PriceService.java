package com.price.service;

import com.price.exception.ParseException;
import com.price.model.PriceResult;
import com.price.model.PriceSearch;

public interface PriceService {
	
	PriceResult getPriceByParams(PriceSearch priceSearch) throws ParseException;
	
}
