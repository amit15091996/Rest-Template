package com.tem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CreatedBy {

	private String role;
	@JsonProperty("_id")
	private String id;
	private String name;
}
