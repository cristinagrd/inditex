package com.price.model.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "prices")
public class Price implements Serializable  {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;	 
	@Id  
	@Column(name="PRICE_LIST")
	private Long id;
	@Column(name = "START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Column(name = "END_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	@Column(name = "PRIORITY")
	private Integer priority;
	@Column(name = "PRICE")
	private Double tariff;
	@Column(name = "CURR")
	private String currency;
	@Column(name = "BRAND_ID")
	private Long brandId;
	@Column(name = "PRODUCT_ID")
	private Long productId;


}