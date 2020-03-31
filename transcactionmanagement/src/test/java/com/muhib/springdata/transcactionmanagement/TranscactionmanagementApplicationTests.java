package com.muhib.springdata.transcactionmanagement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.muhib.springdata.transcactionmanagement.service.BankAccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TranscactionmanagementApplicationTests {

	@Autowired
	BankAccountService service;
	
	@Test
	public void testTransfer() {
		service.tranfer(1000);
	}
}
