package com.muhib.springdata.idgenerators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.muhib.springdata.idgenerators.entities.Employee;
import com.muhib.springdata.idgenerators.repo.EmployeeRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CreateEmployeeTest {

	@Autowired
	EmployeeRepository repo;
	
	@Test
	public void createEmployee() {
		Employee employee=new Employee();
//		employee.setId(1l);
		employee.setName("muhib");
		
		repo.save(employee);
		
		
	}

}
