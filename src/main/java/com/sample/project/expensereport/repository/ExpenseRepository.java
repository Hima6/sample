package com.sample.project.expensereport.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.format.annotation.DateTimeFormat;

import com.sample.project.expensereport.domain.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Integer >{

	@Query("SELECT sum(amount), billType, createdDate FROM Expense where created_date = ?1 group by bill_type")
	List<Expense> findByCreatedDate(String date);
}
