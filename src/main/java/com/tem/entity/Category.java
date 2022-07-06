package com.tem.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Category {

	@JsonProperty("_id")
	private String id;
	private String name;
	private String slug;
}
