package com.price.repository.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.price.exception.ParseException;
import com.price.model.PriceResult;
import com.price.model.PriceSearch;
import com.price.model.entity.Price;
import com.price.repository.dao.PriceRepositoryDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class PriceRepositoryDaoImpl implements PriceRepositoryDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * Method to get price data
	 * @param priceSearch
	 * @return priceResult
	 */
	public PriceResult getData(PriceSearch priceSearch) throws ParseException{
		Timestamp formatedDate = formatDate(priceSearch.getDate());
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Price> query= cb.createQuery(Price.class);
		Root<Price> root = query.from(Price.class);
		query.select(root);
		Predicate predicate = cb.and(
		    cb.equal(root.get("brandId"), priceSearch.getBrandId()),
		    cb.equal(root.get("productId"), priceSearch.getProductId()),
		    cb.between(
		        cb.literal(formatedDate),
		        root.get("startDate"),
		        root.get("endDate")
		    )
		);

		query.where(predicate);		
		query.orderBy(cb.desc(root.get("priority")));
		
		TypedQuery<Price> typedQuery = entityManager.createQuery(query);
		typedQuery.setMaxResults(1);
		Price price = typedQuery.getSingleResult(); 
		return setData(price);
	}

	/**
	 * Method to format date
	 * @param date
	 * @return timestamp
	 * @throws ParseException
	 */
	private Timestamp formatDate(String date) throws ParseException {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date fechaDate;
		try {
			fechaDate = formato.parse(date);
		} catch (Exception e) {
			throw new ParseException("Error formatting dates");
		}

		return new Timestamp(fechaDate.getTime());
	}
	
	/**
	 * Method to set result data
	 * @param price
	 * @return
	 * @throws ParseException 
	 */
	private PriceResult setData(Price price) {
		PriceResult priceResult = new PriceResult();
		priceResult.setId(price.getId());
		priceResult.setBrandId(price.getBrandId());
		priceResult.setProductId(price.getProductId());
		priceResult.setStartDate(price.getStartDate().toString());
		priceResult.setEndDate(price.getEndDate().toString());
		priceResult.setTariff(price.getTariff());
		return priceResult;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends Price> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Price> List<S> saveAllAndFlush(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllInBatch(Iterable<Price> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Price getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Price getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Price getReferenceById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Price> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Price> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Price> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Price> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Price> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Price> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Price> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Price entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Price> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Price> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Price> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Price> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Price> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Price> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Price> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <S extends Price, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		// TODO Auto-generated method stub
		return null;
	}
	

	
		
}
