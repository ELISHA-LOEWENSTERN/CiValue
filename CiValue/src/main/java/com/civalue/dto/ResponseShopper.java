package com.civalue.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseShopper implements Serializable, RestResponse{

	private static final long serialVersionUID = 1L;
	private String shopperId;
	private Double relevancyScore;
	
	public ResponseShopper(String productId, Double relevancyScore) {
		this.shopperId = productId;
		this.relevancyScore = relevancyScore;
	}

	public String getProductId() {
		return shopperId;
	}
	public void setProductId(String productId) {
		this.shopperId = productId;
	}
	public Double getRelevancyScore() {
		return relevancyScore;
	}
	public void setRelevancyScore(Double relevancyScore) {
		this.relevancyScore = relevancyScore;
	}
}
