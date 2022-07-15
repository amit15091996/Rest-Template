package com.tem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.dao.DataOperation;
import com.tem.entity.DataMain;
import com.tem.exception.ExceptionConstant;
import com.tem.service.DataService;


@RestController
public class DataController {

	@Autowired
	DataService dataService;

	@Autowired
	DataOperation dataOperation;

	@GetMapping("/get") 
	public DataMain getData() {
		try {
			return dataService.getdata();
		} catch (Exception e) {
			throw new ExceptionConstant();
		}
		
	}

}
