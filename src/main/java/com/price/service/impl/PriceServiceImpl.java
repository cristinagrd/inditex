package com.price.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.price.exception.ParseException;
import com.price.model.PriceResult;
import com.price.model.PriceSearch;
import com.price.repository.dao.PriceRepositoryDao;
import com.price.service.PriceService;

@Service
public class PriceServiceImpl implements PriceService{
	
	PriceRepositoryDao priceRepositoryDao;
	
	@Autowired
	public PriceServiceImpl(PriceRepositoryDao priceRepositoryDao) {
		this.priceRepositoryDao = priceRepositoryDao;
	}
	
	@Override
	public PriceResult getPriceByParams(PriceSearch priceSearch) throws ParseException{
		return priceRepositoryDao.getData(priceSearch);
	}	

}
