package com.muhib.springdata.mappingonetoone.repo;

import org.springframework.data.repository.CrudRepository;

import com.muhib.springdata.mappingonetoone.dto.Person;

public interface PersonRepository extends CrudRepository<Person,Integer> {

}
