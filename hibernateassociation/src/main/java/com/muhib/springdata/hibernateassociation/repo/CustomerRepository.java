package com.muhib.springdata.hibernateassociation.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.muhib.springdata.hibernateassociation.dto.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
