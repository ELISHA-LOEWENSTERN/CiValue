package com.civalue.facade;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.civalue.dto.ResponseProduct;
import com.civalue.dto.ResponseShopper;
import com.civalue.jpa.filters.ProductFilter;
import com.civalue.jpa.filters.ShopperFilter;
import com.civalue.model.Product;
import com.civalue.model.Shopper;
import com.civalue.query.ProductQueryBuilder;
import com.civalue.query.ShopperQueryBuilder;

@Path("/ecommerce")
public class EcommerceFacade {
	
	@Inject
	private ProductQueryBuilder productQueryBuilder;
	
	@Inject
	private ShopperQueryBuilder shopperQueryBuilder;
	
	@GET
    @Path("/shoppers/{shopperId}")
	@Produces("application/json")
	public List<ResponseProduct> listProducts (@PathParam("shopperId") String shopperId, @QueryParam("category") String category, @QueryParam("brand") String brand, @QueryParam("limit") Integer limit) {
		ShopperFilter sf = ShopperFilter.createBuilder().shopperId(shopperId).category(category).brand(brand).limit(limit).build();
		return productQueryBuilder.listProducts(sf);
	}

	@GET
    @Path("/products/{productId}")
	@Produces("application/json")
	public List<ResponseShopper> listShoppers (@PathParam("productId") String productId, @QueryParam("limit") Integer limit) {
		ProductFilter pf = ProductFilter.createBuilder().productId(productId).limit(limit).build();
		return shopperQueryBuilder.listShoppers(pf);
    } 
}
