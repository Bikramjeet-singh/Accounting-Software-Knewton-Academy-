package com.knewton.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.knewton.model.DailyTransaction;

@Repository
public interface DailyTransactionRepository extends CrudRepository<DailyTransaction,String>{
	
}