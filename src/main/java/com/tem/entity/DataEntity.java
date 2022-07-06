package com.tem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataEntity {

//	@JsonProperty("ID Nation")
//	private String IdNation;
//	
//	@JsonProperty("Nation")
//	private String Nation;
//	
//	@JsonProperty("ID Year")
//	private long IdYear;
//	
//	@JsonProperty("Year")
//	private String Year;
//	
//	@JsonProperty("Population")
//	private long Population;
//	
//	@JsonProperty("Slug Nation")
//	private String SlugNation;

	@JsonProperty("_id")
	private String id;
//	@JsonProperty("title")
	private String title;
//	@JsonProperty("price")
	private long price;

	private Category category;
	private CreatedBy createdBy;
	private String description;
	private String createdAt;
	private String updatedAt;
	private String slug;

}
