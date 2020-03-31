package com.muhib.springdata.hibernateassociation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.muhib.springdata.hibernateassociation.dto.Customer;
import com.muhib.springdata.hibernateassociation.dto.PhoneNumber;
import com.muhib.springdata.hibernateassociation.repo.CustomerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HibernateassociationApplicationTests {

	@Autowired
	CustomerRepository repo;
	
	@Test
	public void testCreate() {
		
		
		Customer customer=new Customer();
		customer.setName("mohib");
		List<PhoneNumber> numbers=new ArrayList<>();
		numbers.add(addPhoneNumber("1234567890", "home",customer));
		numbers.add(addPhoneNumber("9876543210", "cellphone",customer));
		customer.setNumbers(numbers);
		repo.save(customer);
		
	}
	
	@Test
	public void testRead() {
		
		Optional<Customer> findById = repo.findById(1);
		
		System.out.println(findById.get().getName());
		
		List<PhoneNumber> numbers = findById.get().getNumbers();
		
		numbers.forEach(p->{
			System.out.println(p.getNumber());
		});
	
	}
	
	@Test
	public void testUpdate() {
		
		Customer customer = repo.findById(1).get();
		
		customer.setName("Mohan");
		
		List<PhoneNumber> numbers=new ArrayList<>();
		numbers.add(addPhoneNumber("1234567890", "home",customer));
		numbers.add(addPhoneNumber("9876543210", "cellphone",customer));
		customer.setNumbers(numbers);
		repo.save(customer);
		
	}
	
	@Test
	public void testDelete() {

		repo.deleteById(1);
	}
	
	

	private PhoneNumber addPhoneNumber(String num,String type,Customer customer) {
		PhoneNumber numbers=new PhoneNumber();
		numbers.setNumber(num);
		numbers.setType(type);
		numbers.setCustomer(customer);
		return numbers;
	}
	
}
