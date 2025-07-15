package com.flipkart.sales.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flip")
public class Salescontroller {
	
	@GetMapping("/sale/{imei}")
	public ResponseEntity<String> postSale(@PathVariable("imei") String imei){
		String message="posted sale for this device"+imei+"by shahimsha successfully";
		System.out.println(message);
		return ResponseEntity.ok(message);
	}

}
