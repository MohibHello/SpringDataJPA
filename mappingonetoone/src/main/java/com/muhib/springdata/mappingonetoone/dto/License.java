package com.muhib.springdata.mappingonetoone.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;

@Entity
@Data
public class License {

	@Id
	@GeneratedValue
	@Column(name = "license_id")
	private int licenseId;
	
	private String type;
	@CreationTimestamp
	@Column(name = "valid_from")
	private Date validFrom;
	@Column(name = "valid_to")
	private Date validTo;
	
}
