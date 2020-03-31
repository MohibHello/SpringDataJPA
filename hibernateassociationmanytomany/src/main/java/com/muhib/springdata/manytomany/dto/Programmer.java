package com.muhib.springdata.manytomany.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "projects")
public class Programmer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "programmer_id")
	private int programmerId;
	@Column(name = "programmer_name")
	private String programmerName;
	private double salary;

	@JoinTable(name = "programmers_projects",
			joinColumns = @JoinColumn(name = "prog_id", referencedColumnName = "programmer_id"),
			inverseJoinColumns = @JoinColumn(name = "proj_id", referencedColumnName = "project_id"))
	@ManyToMany(cascade = CascadeType.ALL)
	List<Project> projects;
}
