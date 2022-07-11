package com.civalue.query;

import java.util.List;

import javax.inject.Inject;

import com.civalue.dto.RestResponse;
import com.civalue.jpa.PersistenceHandler;
import com.civalue.jpa.filters.QueryFilter;

public abstract class BaseQueryBuilder<F extends QueryFilter, R extends RestResponse> {

	@Inject
	protected PersistenceHandler persistenceHandler;

	public List<R> listProducts(F filter) {
		
		String queryString = buildQuery(filter);
		List<Object[]> resultList = (List<Object[]>) persistenceHandler.executeNativeQuery(queryString.toString());		
		List<R> response = resultListToResponse(resultList); 
		
		return response;
	}

	protected abstract String buildQuery(F filter);

	protected abstract List<R> resultListToResponse(List<Object[]> resultList);
}
