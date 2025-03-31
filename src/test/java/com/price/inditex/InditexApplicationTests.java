package com.price.inditex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.price.InditexApplication;
import com.price.controller.PriceController;
import com.price.model.PriceResult;
import com.price.model.PriceSearch;
import com.price.repository.dao.PriceRepositoryDao;
import com.price.service.PriceService;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = InditexApplication.class)
class InditexApplicationTests {

	
	@Autowired
	private PriceService priceService;
	  
	@Mock
	private PriceRepositoryDao dao;
	    
	PriceController price = new PriceController(priceService);
	
	@Test
	void testGetPrice() throws Throwable {
		var priceSearch = new PriceSearch();
		var priceResult = new PriceResult();
		//test #1
		priceSearch = setTest(1L, 35455L, "2020-06-14 10:00:00");
		priceResult.setId(1L);
		callTest(priceSearch, priceResult);
		
		//test #2
		priceSearch = setTest(1L, 35455L, "2020-06-14 16:00:00");
		priceResult.setId(2L);
		callTest(priceSearch, priceResult);	
		
		//test #2
		priceSearch = setTest(1L, 35455L, "2020-06-14 21:00:00");
		priceResult.setId(1L);
		callTest(priceSearch, priceResult);
		
		//test #2
		priceSearch = setTest(1L, 35455L, "2020-06-15 10:00:00");
		priceResult.setId(3L);
		callTest(priceSearch, priceResult);
		
		//test #2
		priceSearch = setTest(1L, 35455L, "2020-06-16 21:00:00");
		priceResult.setId(4L);
		callTest(priceSearch, priceResult);		
		

		
	}
	
	private void callTest(PriceSearch priceSearch, PriceResult priceResult) throws Throwable {
		Mockito.when(dao.getData(priceSearch)).thenReturn(priceResult); // When
		//When
		PriceResult result = priceService.getPriceByParams(priceSearch); // Then
		//Then
		assertNotNull(priceResult);
		assertEquals(priceResult.getId(), result.getId());		 
		 	
	}	
	
	private PriceSearch setTest(Long brandId, Long productId, String date) {
		var priceSearch = new PriceSearch();
		priceSearch.setBrandId(brandId);
		priceSearch.setProductId(productId);
		priceSearch.setDate(date);		
		return priceSearch;
	}

}

