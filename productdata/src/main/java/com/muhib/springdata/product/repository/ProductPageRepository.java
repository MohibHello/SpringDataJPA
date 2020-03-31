package com.muhib.springdata.product.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.muhib.springdata.product.entites.Product;

public interface ProductPageRepository extends PagingAndSortingRepository<Product, Long> {

 List<Product> findByName(String name);
	 
	 List<Product> findByNameAndId(String name,Integer id);
	 
	 List<Product> findByPriceGreaterThan(Double price);
	 
	 List<Product> findByDescContains(String name);
	 
	 List<Product> findByPriceBetween(Double price1,Double price2);
	 
	 List<Product> findByNameLike(String name);
	 
	 List<Product> findByIdIn(List<Integer> id);
	 
	 //customer finder for paging and sorting
	 List<Product> findByIdIn(List<Integer> id,Pageable pageable);
}
