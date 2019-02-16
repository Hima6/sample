package com.sample.project.expensereport.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import junit.framework.Assert;

public class ExpenseControllerTest{

	 @Autowired
	    private RestTemplate restTemplate;

	 
	@Test
	public void testAddBill() {
	        restTemplate = new RestTemplate();
	                String url = "http:localhost:8090";

	            ResponseEntity<String> resp =  restTemplate.getForEntity(url + "/expense/electricity",String.class);
	   Assert.assertEquals(resp.getBody(), "Added electricity bill.");
	}
	
}
