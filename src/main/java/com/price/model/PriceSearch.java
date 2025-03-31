package com.price.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class PriceSearch implements Serializable  {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long brandId;
	private Long productId;
	private String date;

}