package com.muhib.springdata.mappingonetoone;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.muhib.springdata.mappingonetoone.dto.License;
import com.muhib.springdata.mappingonetoone.dto.Person;
import com.muhib.springdata.mappingonetoone.repo.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MappingonetooneApplicationTests {

	@Autowired
	PersonRepository repo;

	@Test
	public void testCreate() throws ParseException {

		Person person = new Person();
		person.setFirstName("mohib");
		person.setLastName("khan");
		person.setAge(23);

		License license = new License();
		license.setType("DL");
		license.setValidTo(testdate());

		person.setLicense(license);

		repo.save(person);

	}

	public Date testdate() throws ParseException {
		String string = "2020-12-05";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(string);
		System.out.println(date);
		return date;
	}

}
