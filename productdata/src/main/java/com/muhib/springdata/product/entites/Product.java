package com.muhib.springdata.product.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.Data;

@Data
@Entity
@Table(name = "product")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Product implements Serializable {
	
	@Id
	private int id;
	private String name;
	@Column(name = "description")
	private String desc;
	private Double price;

}
