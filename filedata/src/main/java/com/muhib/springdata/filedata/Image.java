package com.muhib.springdata.filedata;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class Image {

	@Id
	private long id;
	
	private String name;
	@Lob
	@Column(length = 100000)
	private byte[] data;
}
