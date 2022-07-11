package com.civalue.facade;

import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.civalue.jpa.PersistenceHandler;
import com.civalue.model.Product;
import com.civalue.model.Shopper;

@Path("/data")
public class DataFacade {

	@Inject
	PersistenceHandler persistenceHandler;
	
	@POST
    @Path("/shoppers")
	@Consumes("application/json")
   public void loadShoppers (Set<Shopper> shoppers){
		persistenceHandler.persist(shoppers);
	}

	@POST
    @Path("/products")
	@Consumes("application/json")
   public void loadProducts (Set<Product> products) {
		persistenceHandler.persist(products);
    } 
}
