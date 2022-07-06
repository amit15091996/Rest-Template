package com.tem.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.tem.entity.DataMain;
import com.tem.exception.ExceptionConstant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class DataOperation {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int createTable() {
		String query = "CREATE TABLE IF NOT EXISTS product(id varchar(50),status varchar(50),message varchar(50),title varchar(50),name varchar(50), price long) ";
		int update = this.jdbcTemplate.update(query);
		if (update > 0) {
			log.info("Table Created");
		}
		return update;
	}

	public Boolean insertData(DataMain mainEntity) {
		try {
			createTable();
			String query = "insert into product(status,message,title,name,price,id) values(?,?,?,?,?,?)";
			log.info("MainEntity : " + mainEntity);
			return this.jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

					ps.setLong(1,   mainEntity.getData().getPrice());
					ps.setString(2, mainEntity.getMessage());
					ps.setString(3, mainEntity.getData().getTitle());
					ps.setString(4, mainEntity.getStatus());
					ps.setString(5, mainEntity.getData().getCategory().getName());
					ps.setString(6, mainEntity.getData().getCategory().getId());
					return ps.execute();
				}

			});
		} catch (Exception e) {
			throw new ExceptionConstant();
		}

	}
}
