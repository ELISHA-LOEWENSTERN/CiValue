package com.civalue.jpa.filters;

public class ProductFilter implements QueryFilter {

  private final String productId;
  private final Integer limit;

	public static Builder createBuilder() {
		return new Builder();
	}

  public static class Builder {
    
    private String productId;
    private Integer limit;

    public Builder() {    
    }
      
    Builder(String productId, Integer limit) {    
      this.productId = productId; 
      this.limit = limit;             
    }
        
    public Builder productId(String productId){
      this.productId = productId;
      return Builder.this;
    }

    public Builder limit(Integer limit){
      this.limit = limit;
      return Builder.this;
    }

    public ProductFilter build() {
        if(this.productId == null){
          throw new NullPointerException("The property \"productId\" is null. "
              + "Please set the value by \"productId()\". "
              + "The property \"productId\" is required.");
        }

        return new ProductFilter(this);
    }
  }

  private ProductFilter(Builder builder) {
    this.productId = builder.productId; 
    this.limit = builder.limit;     
  }

public String getProductId() {
	return productId;
}

public Integer getLimit() {
	return limit;
}

}
