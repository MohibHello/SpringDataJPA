package com.muhib.springdata.idgenerators.repo;

import org.springframework.data.repository.CrudRepository;

import com.muhib.springdata.idgenerators.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
