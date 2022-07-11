package com.civalue.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseProduct implements Serializable, RestResponse{

	private static final long serialVersionUID = 1L;
	private String productId;
	private String category;
	private String brand;
	private Double relevancyScore;
	
	public ResponseProduct(String productId, String category, String brand, Double relevancyScore) {
		this.productId = productId;
		this.category = category;
		this.brand = brand;
		this.relevancyScore = relevancyScore;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getRelevancyScore() {
		return relevancyScore;
	}
	public void setRelevancyScore(Double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}
}
