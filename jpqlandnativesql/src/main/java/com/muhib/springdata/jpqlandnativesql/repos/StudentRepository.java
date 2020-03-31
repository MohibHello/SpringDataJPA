package com.muhib.springdata.jpqlandnativesql.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.muhib.springdata.jpqlandnativesql.dto.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

	@Query("from Student")
	List<Student> findAllStudent();
	
	@Query("select firstName from Student s where s.firstName=:fname")
	List<Object[]> findByFirstName(@Param("fname")String name);
	
	@Query("from Student s where s.firstName=:fname")
	List<Student> findByFirstName2(@Param("fname")String name);
	
	@Query("from Student s where s.score>:min and s.score <:max")
	List<Student> findByScore(@Param("min")int min,@Param("max")int max);
	
	@Modifying
	@Query("delete from Student s where s.firstName=:fname")
	void deleteByName(@Param("fname")String fname);
}
