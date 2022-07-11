package com.civalue.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.civalue.model.BaseEntity;

@Stateless
@LocalBean
public class PersistenceHandler {

	@PersistenceContext(unitName = "civalue_persistence")
	protected EntityManager entityManager;

	public void persist(Collection<? extends BaseEntity> entities) {
		if(entities != null) {
			for(BaseEntity entity:entities) {
				entityManager.persist(entity);
			}
		}
	}

	public List<?> executeNativeQuery(String query) {
		return entityManager.createNativeQuery(query).getResultList();		
	}
}
