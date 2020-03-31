package com.muhib.springdata.transcactionmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.muhib.springdata.transcactionmanagement.dto.BankAccount;
import com.muhib.springdata.transcactionmanagement.repo.BankAccountRepoistory;

@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	BankAccountRepoistory bankRepo;

	@Override
	@Transactional
	public void tranfer(double amount) {

		BankAccount obamaAccount = bankRepo.findById(1).get();
		obamaAccount.setBalance(obamaAccount.getBalance() - amount);
		bankRepo.save(obamaAccount);
		
		if(true) {
			throw new RuntimeException();
		}
		
		BankAccount trumpAccount = bankRepo.findById(2).get();
		trumpAccount.setBalance(trumpAccount.getBalance() + amount);
		bankRepo.save(trumpAccount);

	}
}
