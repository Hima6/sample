package com.sample.project.expensereport.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
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
			entity.setCreatedDate(LocalDate.now()); 
			expenseRepository.save(entity);
		}else {
			throw new ValidationException();
			
		}
		
	}
	
	public List<ExpenseDTO> getData() {
		List<ExpenseDTO> response = new ArrayList<>();
		List<Expense> expenses = expenseRepository.findByCreatedDate(LocalDate.now());
		for(Expense e : expenses) {
			ExpenseDTO dto = new ExpenseDTO();
			dto.setAmount(new BigDecimal(e.getAmount()));
			dto.setBillType(BillTypeEnum.getBillTypeDescription(e.getBillType()));
			response.add(dto);
			//dto.setCreatedDate(e.getCreatedDate());
		}
		return response;
	}

	@Override
	public List<ExpenseDTO> getMonthlyData() {
		List<ExpenseDTO> response = new ArrayList<>();
		LocalDate todayDate = LocalDate.now();
		List<Expense> expenses = expenseRepository.findByCreatedDateBetween(todayDate.withDayOfMonth(1),todayDate);
		for(Expense e : expenses) {
			ExpenseDTO dto = new ExpenseDTO();
			dto.setAmount(new BigDecimal(e.getAmount()));
			dto.setBillType(BillTypeEnum.getBillTypeDescription(e.getBillType()));
			response.add(dto);
		}
		return response;
	}

}
