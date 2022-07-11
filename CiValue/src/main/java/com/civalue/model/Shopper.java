package com.civalue.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Shopper extends BaseEntity {

	private String shopperId;
	
	@OneToMany(cascade = javax.persistence.CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="shopper_internal_id",referencedColumnName="internalId")
	private Set<ProductRelevancy> shelf;

	public String getShopperId() {
		return shopperId;
	}

	public void setShopperId(String shopperId) {
		this.shopperId = shopperId;
	}

	public Set<ProductRelevancy> getShelf() {
		return shelf;
	}

	public void setShelf(Set<ProductRelevancy> shelf) {
		this.shelf = shelf;
	}
	
	
}
