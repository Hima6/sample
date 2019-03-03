package com.sample.project.expensereport.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sample.project.expensereport.domain.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Integer >{

	List<Expense> findByCreatedDate(LocalDate date);
	
	List<Expense> findByCreatedDateBetween(LocalDate startdate,LocalDate enddate);
}
