package com.civalue.jpa.filters;

public class ShopperFilter implements QueryFilter {

	private final String shopperId;
	private final String category;
	private final String brand;
	private final Integer limit;

	public static Builder createBuilder() {
		return new Builder();
	}
	
	public static class Builder {

		private String shopperId;
		private String category;
		private String brand;
		private Integer limit;

		public Builder() {
		}

		Builder(String shopperId, String category, String brand, Integer limit) {
			this.shopperId = shopperId;
			this.category = category;
			this.brand = brand;
			this.limit = limit;
		}

		public Builder shopperId(String shopperId) {
			this.shopperId = shopperId;
			return Builder.this;
		}

		public Builder category(String category) {
			this.category = category;
			return Builder.this;
		}

		public Builder brand(String brand) {
			this.brand = brand;
			return Builder.this;
		}

		public Builder limit(Integer limit) {
			this.limit = limit;
			return Builder.this;
		}

		public ShopperFilter build() {
			if (this.shopperId == null) {
				throw new NullPointerException("The property \"shopperId\" is null. "
						+ "Please set the value by \"shopperId()\". " + "The property \"shopperId\" is required.");
			}

			return new ShopperFilter(this);
		}
	}

	private ShopperFilter(Builder builder) {
		this.shopperId = builder.shopperId;
		this.category = builder.category;
		this.brand = builder.brand;
		this.limit = builder.limit == null ? 10 : Math.min(builder.limit, 1000);
	}

	public String getShopperId() {
		return shopperId;
	}

	public String getCategory() {
		return category;
	}

	public String getBrand() {
		return brand;
	}

	public Integer getLimit() {
		return limit;
	}
}
