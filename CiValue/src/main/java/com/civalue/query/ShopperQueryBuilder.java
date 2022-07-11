package com.civalue.query;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.civalue.dto.ResponseShopper;
import com.civalue.jpa.filters.ProductFilter;

@Stateless
@LocalBean
public class ShopperQueryBuilder extends BaseQueryBuilder<ProductFilter, ResponseShopper> {

	@Override
	protected String buildQuery(ProductFilter filter) {

		String query = 
				"select s.shopper_id, r.relevancy_score " + 
				"from shoppers s " + 
				"join product_relevancies r on s.internal_id=r.shopper_internal_id " +
				"where r.product_id=" + filter.getProductId() + " " + 
				"order by r.relevancy_score desc " +
				"limit " + filter.getLimit();
		
		return query;
	}

	@Override
	protected List<ResponseShopper> resultListToResponse(List<Object[]> resultList) {

		List<ResponseShopper> response = new ArrayList<ResponseShopper>();
		
		if(resultList!=null) {
			for(Object[] row:resultList) {
				String productId = (String) row[0];
				Double relevancy = (Double) row[1];
				ResponseShopper rp = new ResponseShopper(productId, relevancy);
				response.add(rp);
			}
		}
		
		return response;
	}
}
