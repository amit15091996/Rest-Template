package com.tem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataMain {

	private String status;
	private DataEntity data;
	private String message;

}
