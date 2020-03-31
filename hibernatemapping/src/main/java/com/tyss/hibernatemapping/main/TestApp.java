package com.tyss.hibernatemapping.main;


import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.tyss.hibernatemapping.dto.Address;
import com.tyss.hibernatemapping.dto.Course;
import com.tyss.hibernatemapping.dto.EmpInfo;
import com.tyss.hibernatemapping.dto.Employee;
import com.tyss.hibernatemapping.util.HibernateUtil;

public class TestApp {

	public static void main(String[] args) {
		
		Session session=HibernateUtil.openSession();
		
		Employee employee=new Employee();
		employee.setName("abc");
		employee.setSalary(1234.5);
		
		Address address=new Address();
		address.setAddress("wqrttrtrtrg");
		address.setCity("dsfdf");
		address.setPincode(12345);
		address.setState("sfafafa");
		
		Address address2=new Address();
		address2.setAddress("wrrrjmmrtrtrg");
		address2.setCity("dsfdf");
		address2.setPincode(344566);
		address2.setState("syjykym");
		
		
		Course course=new Course();
		course.setCourseName("java");
		course.setType("programming");
		

		Course course2=new Course();
		course2.setCourseName("c");
		course2.setType("programming");
		
		EmpInfo empInfo=new EmpInfo();
		empInfo.setAdhar(12314);
		empInfo.setPassport("1214adad");
		empInfo.setPincode(555443);
		
		
		employee.setInfo(empInfo);
		
		//employee.getAddress().add(address);
		//employee.getAddress().add(address2);
		employee.setAddress(Arrays.asList(address,address2));
		//employee.getCourse().add(course);
		//employee.getCourse().add(course2);
		employee.setCourse(Arrays.asList(course,course2));
		
		
		
		Transaction txn=session.beginTransaction();
		
		//Employee  employee2=session.get(Employee.class, 1);
		//Address  employee2=session.get(Address.class, 7);
		//session.delete(employee2);
		//session.save(employee);
		
		Query w=session.createQuery("delete from Address e where e.aid=9 ");
		w.executeUpdate();
		
		txn.commit();
		
		
		
		
		
	}
}
