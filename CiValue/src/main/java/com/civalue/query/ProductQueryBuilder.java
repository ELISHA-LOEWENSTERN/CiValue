package com.civalue.query;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.civalue.dto.ResponseProduct;
import com.civalue.jpa.filters.ShopperFilter;

@Stateless
@LocalBean
public class ProductQueryBuilder extends BaseQueryBuilder<ShopperFilter, ResponseProduct>{

	@Override
	protected String buildQuery(ShopperFilter filter) {

		StringBuilder query = new StringBuilder(
				"select p.product_id, p.category, p.brand, r.relevancy_score " + 
				"from shoppers s " + 
				"join product_relevancies r on s.internal_id=r.shopper_internal_id " + 
				"join products p on r.product_id=p.product_id ");
		
		query.append("where s.shopper_id="+filter.getShopperId() + " ");
		
		if(filter.getCategory()!=null) {
			query.append("and p.category=" + filter.getCategory() + " ");
		}
		
		if(filter.getBrand()!=null) {
			query.append("and p.brand=" + filter.getBrand() + " ");
		}
		
		query.append("limit " + filter.getLimit() + " ");
		query.append("order by r.relevancy_score desc");
		
		return query.toString();
	}


	@Override
	protected List<ResponseProduct> resultListToResponse(List<Object[]> resultList) {

		List<ResponseProduct> response = new ArrayList<ResponseProduct>();
		
		if(resultList!=null) {
			for(Object[] row:resultList) {
				String productId = (String) row[0];
				String category = (String) row[1];
				String brand = (String) row[2];
				Double relevancy = (Double) row[3];
				ResponseProduct rp = new ResponseProduct(productId, category, brand, relevancy);
				response.add(rp);
			}
		}
		
		return response;
	}
		
}
