package com.civalue.model;

import javax.persistence.Entity;

@Entity
public class ProductRelevancy extends BaseEntity{

	private String productId;
	private Double relevancyScore;

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Double getRelevancyScore() {
		return relevancyScore;
	}
	public void setRelevancyScore(Double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}
	
	
}
