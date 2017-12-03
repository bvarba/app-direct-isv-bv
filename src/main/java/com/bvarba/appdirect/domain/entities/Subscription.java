package com.bvarba.appdirect.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Subscription {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    private Integer id;

		private String marketplaceBaseUrl;
	    private String marketplaceParner;
	    private String companyCountry;
	    private String companyName;
	    private String companyUuid;
	    private String companyWebsite;

	    private String orderEditionCode;
	    private String orderPricingDuration;
	    private Integer orderItemsQuentity;

	    private OrderLineItemUnitType orderItemUnit;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getMarketplaceBaseUrl() {
			return marketplaceBaseUrl;
		}

		public void setMarketplaceBaseUrl(String marketplaceBaseUrl) {
			this.marketplaceBaseUrl = marketplaceBaseUrl;
		}

		public String getMarketplaceParner() {
			return marketplaceParner;
		}

		public void setMarketplaceParner(String marketplaceParner) {
			this.marketplaceParner = marketplaceParner;
		}

		public String getCompanyCountry() {
			return companyCountry;
		}

		public void setCompanyCountry(String companyCountry) {
			this.companyCountry = companyCountry;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getCompanyUuid() {
			return companyUuid;
		}

		public void setCompanyUuid(String companyUuid) {
			this.companyUuid = companyUuid;
		}

		public String getCompanyWebsite() {
			return companyWebsite;
		}

		public void setCompanyWebsite(String companyWebsite) {
			this.companyWebsite = companyWebsite;
		}

		public String getOrderEditionCode() {
			return orderEditionCode;
		}

		public void setOrderEditionCode(String orderEditionCode) {
			this.orderEditionCode = orderEditionCode;
		}

		public String getOrderPricingDuration() {
			return orderPricingDuration;
		}

		public void setOrderPricingDuration(String orderPricingDuration) {
			this.orderPricingDuration = orderPricingDuration;
		}

		public Integer getOrderItemsQuentity() {
			return orderItemsQuentity;
		}

		public void setOrderItemsQuentity(Integer orderItemsQuentity) {
			this.orderItemsQuentity = orderItemsQuentity;
		}

		public OrderLineItemUnitType getOrderItemUnit() {
			return orderItemUnit;
		}

		public void setOrderItemUnit(OrderLineItemUnitType orderItemUnit) {
			this.orderItemUnit = orderItemUnit;
		}
}
