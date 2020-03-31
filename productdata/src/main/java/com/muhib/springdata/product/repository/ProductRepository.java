package com.muhib.springdata.product.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.muhib.springdata.product.entites.Product;
import java.lang.String;


public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	 List<Product> findByName(String name);
	 
	 List<Product> findByNameAndId(String name,Integer id);
	 
	 List<Product> findByPriceGreaterThan(Double price);
	 
	 List<Product> findByDescContains(String name);
	 
	 List<Product> findByPriceBetween(Double price1,Double price2);
	 
	 List<Product> findByNameLike(String name);
	 
	 List<Product> findByIdIn(List<Integer> Integer);
}
