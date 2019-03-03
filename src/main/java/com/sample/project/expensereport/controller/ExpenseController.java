package com.sample.project.expensereport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.project.expensereport.domain.Expense;
import com.sample.project.expensereport.dto.ExpenseDTO;
import com.sample.project.expensereport.enumerations.BillTypeEnum;
import com.sample.project.expensereport.service.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;

	@PostMapping
	public String addBill(@RequestBody ExpenseDTO expenseDto) {
		expenseService.createBill(expenseDto);
		return "Added " + BillTypeEnum.getBillTypeDescription(expenseDto.getBillType()) + " bill.";
	}
	
	@GetMapping("/today")
	public List<ExpenseDTO> getTodayReport() {
		List<ExpenseDTO> expenses = expenseService.getData();
		return expenses;
	}
	
	@GetMapping("/monthlyReport")
	public List<ExpenseDTO> getMonthlyReport() {
		List<ExpenseDTO> expenses = expenseService.getMonthlyData();
		return expenses;
	}
}
