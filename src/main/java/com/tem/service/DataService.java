package com.tem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tem.dao.DataOperation;
import com.tem.entity.DataMain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DataService {

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	DataOperation dataOperation;

	@Value("${API_URL}")
	String url;

	public DataMain getdata() {
		log.info("Calling getdata() method");
		try {
			
			HttpEntity<String> httpEntity = new HttpEntity<>("");
			ResponseEntity<DataMain> result = restTemplate.exchange(url, HttpMethod.GET, httpEntity, DataMain.class);
			log.info("Result : "+ result.getBody());
			if (result.getBody() != null) {
				int inserted = dataOperation.insertData(result.getBody());
				log.info("Data Inserted Successfully : " + inserted);
			}
			return result.getBody();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
