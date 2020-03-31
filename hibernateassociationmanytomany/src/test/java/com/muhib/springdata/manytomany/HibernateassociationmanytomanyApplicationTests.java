package com.muhib.springdata.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.muhib.springdata.manytomany.dto.Programmer;
import com.muhib.springdata.manytomany.dto.Project;
import com.muhib.springdata.manytomany.repos.ProgrammerRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HibernateassociationmanytomanyApplicationTests {

	@Autowired
	ProgrammerRepository repo;
	
	
	@Test
	public void testCreate() {
		
		Programmer programmer=new Programmer();
		programmer.setProgrammerName("mohan");
		programmer.setSalary(20000.00);
		
		Project project=new Project();
		project.setProjectName("SPA");
		
		Project project2=new Project();
		project2.setProjectName("JAVA");
		
		List<Project> projects=new ArrayList<>();
		projects.add(project);
		projects.add(project2);
		
		
		programmer.setProjects(projects);
		
		repo.save(programmer);
		
	}
	
	@Test 
	@Transactional
	public void testLoad() {
		
		Programmer programmer = repo.findById(1).get();
		repo.findById(1).get();
		repo.findById(1).get();
		System.out.println(programmer);
		
		System.out.println(programmer.getProjects());
	}
	

}
