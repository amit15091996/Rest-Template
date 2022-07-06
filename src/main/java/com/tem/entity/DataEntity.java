package com.tem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataEntity {

	@JsonProperty("_id")
	private String id;

	private String title;

	private long price;

	private Category category;
	private CreatedBy createdBy;
	private String description;
	private String createdAt;
	private String updatedAt;
	private String slug;

}
