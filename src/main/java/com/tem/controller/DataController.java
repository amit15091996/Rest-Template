package com.tem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.dao.DataOperation;
import com.tem.entity.DataMain;
import com.tem.service.DataService;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class DataController {

	@Autowired
	DataService dataService;

	@Autowired
	DataOperation dataOperation;

	@GetMapping("/get")
	public DataMain getData() {
		try {
			DataMain getdata = dataService.getdata();
			return getdata;
		} catch (Exception e) {
			e.printStackTrace();
			 
			throw new RuntimeException(e.getCause());
		}
	}

}
