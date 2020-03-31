package com.muhib.springdata.manytomany.repos;

import org.springframework.data.repository.CrudRepository;

import com.muhib.springdata.manytomany.dto.Programmer;

public interface ProgrammerRepository extends CrudRepository<Programmer, Integer> {

}
