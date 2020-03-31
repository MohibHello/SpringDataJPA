package com.muhib.springdata.transcactionmanagement.repo;

import org.springframework.data.repository.CrudRepository;

import com.muhib.springdata.transcactionmanagement.dto.BankAccount;

public interface BankAccountRepoistory extends CrudRepository<BankAccount, Integer>{

}
