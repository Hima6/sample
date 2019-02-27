package com.sample.project.expensereport.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.project.expensereport.domain.Expense;
import com.sample.project.expensereport.dto.ExpenseDTO;
import com.sample.project.expensereport.enumerations.BillTypeEnum;
import com.sample.project.expensereport.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;

	@Override
	public void createBill(ExpenseDTO expense) {
		System.out.println(BillTypeEnum.getBillTypeEnum(expense.getBillType()));
		if(BillTypeEnum.getBillTypeEnum(expense.getBillType()) != null) {
			Expense entity = new Expense();
			entity.setBillType(expense.getBillType());
			entity.setAmount(expense.getAmount().toString());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			entity.setCreatedDate(format.format(new Date()));
			expenseRepository.save(entity);
		}else {
			throw new ValidationException();
			
		}
		
	}
	
	public List<Expense> getData() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return expenseRepository.findByCreatedDate(format.format(new Date()));
	}

}
