package com.sample.project.expensereport.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@GetMapping("/{billType:.+}")
	public String addBill(@PathVariable("billType") String billType) {
		return "Added " + billType + " bill.";
	}
}
