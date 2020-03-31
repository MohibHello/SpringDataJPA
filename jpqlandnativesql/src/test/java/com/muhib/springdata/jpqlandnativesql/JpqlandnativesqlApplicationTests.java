package com.muhib.springdata.jpqlandnativesql;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.muhib.springdata.jpqlandnativesql.dto.Student;
import com.muhib.springdata.jpqlandnativesql.repos.StudentRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JpqlandnativesqlApplicationTests {

	@Autowired
	StudentRepository repository;
	
	@Test
	public void testCreateStudent() {
		repository.save(new Student(null,"mohib","khan",44));
	}
	@Test
	public void testFindAllStudent() {
		List<Student> findAllStudent = repository.findAllStudent();
		
		findAllStudent.forEach(p->{
			System.out.println(p.getFirstName()+"  "+p.getScore());
		});
	}
	
	@Test
	public void testFindStudentByFname() {
		List<Student> findAllStudent = repository.findByFirstName2("moin");
		
		System.out.println(findAllStudent.toString());
	}
	
	@Test
	public void testFindStudentByScore() {

			List<Student> findByScore = repository.findByScore(35,60);
			findByScore.forEach(s->{
				System.out.println(s.getFirstName()+" "+s.getScore());
			});
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testdeleteStudent() {
		
		repository.deleteByName("dj");
		
	}
	
}
