package com.sample.project.expensereport.service;

import java.util.List;

import com.sample.project.expensereport.domain.Expense;
import com.sample.project.expensereport.dto.ExpenseDTO;

public interface ExpenseService {

	public void createBill(ExpenseDTO expense);
	
	public List<ExpenseDTO> getData();
}
