package com.tyss.hibernatemapping.dto;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;


@Data
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "salary")
	private double salary;
	
	@OneToOne(cascade = CascadeType.ALL)
	private EmpInfo info;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Address> address;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "employee_course", joinColumns =@JoinColumn(name="eid") ,inverseJoinColumns = @JoinColumn(name="cid"))
	private List<Course> course;
}
