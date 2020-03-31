package com.tyss.hibernatemapping.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "Employee_Info")
@Entity
public class EmpInfo implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eid;
	@Column(name = "address")
	private String address;
	@Column(name= "adhar")
	private int adhar;
	@Column(name = "passport")
	private String passport;
	@Column(name = "pincode")
	private int pincode;
	
}
