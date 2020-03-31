package com.tyss.hibernatemapping.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name = "address")
public class Address implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aid;
	
	@Column(name = "address")
	private String address;
	@Column(name = "state")
	private String state;
	@Column(name ="city")
	private String city;
	@Column(name = "pincode")
	private int pincode;
	

	 
}
