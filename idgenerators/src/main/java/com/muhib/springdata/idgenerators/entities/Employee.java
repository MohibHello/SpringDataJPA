package com.muhib.springdata.idgenerators.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Employee {

	// @TableGenerator(name = "employee_gen",table = "id_gen" ,allocationSize =
	// 2,pkColumnName = "gen_name",valueColumnName = "gen_val")
	@GenericGenerator(name = "emp_id", strategy = "com.muhib.springdata.idgenerators.entities.CustomIdGenerator")
	@Id
	@GeneratedValue(generator = "emp_id")
	private Long id;

	private String name;

}
