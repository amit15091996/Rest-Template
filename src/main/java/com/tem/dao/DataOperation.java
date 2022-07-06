package com.tem.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tem.entity.DataMain;

@Repository
public class DataOperation {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int createTable() {
		String query = "CREATE TABLE IF NOT EXISTS product(id varchar(50) primary key,status varchar(50),message varchar(50),title varchar(50),name varchar(50), price long) ";
		int update = this.jdbcTemplate.update(query);
		if (update > 0) {
			System.out.println("Table Created");
		}
		return update;
	}

	public int insertData(DataMain mainEntity) {
		createTable();
		String query = "insert into product(status,message,title,name,price,id) values(?,?,?,?,?,?)";
		createTable();
		Object args[] = { mainEntity.getStatus(), mainEntity.getMessage(), mainEntity.getData().getPrice(),
				mainEntity.getData().getTitle(), mainEntity.getData().getCategory().getName(),
				mainEntity.getData().getCategory().getId() };
		int update = this.jdbcTemplate.update(query, args);
		return update;

	}
}
