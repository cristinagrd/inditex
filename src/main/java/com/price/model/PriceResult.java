package com.price.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class PriceResult implements Serializable  {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private Long brandId;
	private Long productId;	
	private String startDate;
	private String endDate;
	private Double tariff;


}