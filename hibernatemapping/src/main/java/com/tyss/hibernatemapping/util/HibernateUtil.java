package com.tyss.hibernatemapping.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tyss.hibernatemapping.dto.Address;
import com.tyss.hibernatemapping.dto.Course;
import com.tyss.hibernatemapping.dto.EmpInfo;
import com.tyss.hibernatemapping.dto.Employee;

public class HibernateUtil {

	private static SessionFactory factory;

	private HibernateUtil() {
	}

	private static SessionFactory getSessionFactory() {
		if (factory == null) {
			factory = new Configuration().configure().addAnnotatedClass(Employee.class).addAnnotatedClass(Course.class)
					.addAnnotatedClass(EmpInfo.class).addAnnotatedClass(Address.class).buildSessionFactory();
		}
		return factory;
	}

	public static Session openSession() {
		return getSessionFactory().openSession();
	}
}
