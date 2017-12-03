package com.bvarba.appdirect.domain.dal.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "subscriptionAccount")
public class SubscriptionAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "subscriptionId")
	private Integer id;

	@Column(name = "accountIdentifier", unique = true)
	private String accountIdentifier;

	private String marketplaceBaseUrl;
	private String marketplaceParner;

	private String companyCountry;
	private String companyName;
	private String companyUuid;
	private String companyWebsite;

	private String orderEditionCode;
	private String orderPricingDuration;
	private Integer orderItemsQuantity;

	private SubscriptionAccountState accountState;

	private OrderLineItemUnitType orderItemUnit;

	@OneToMany(mappedBy = "subscriptionAccount", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<User> subscribedUsers = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountIdentifier() {
		return accountIdentifier;
	}

	public void setAccountIdentifier(String accountIdentifier) {
		this.accountIdentifier = accountIdentifier;
	}

	public SubscriptionAccountState getAccountState() {
		return accountState;
	}

	public void setAccountState(SubscriptionAccountState accountState) {
		this.accountState = accountState;
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
		return orderItemsQuantity;
	}

	public void setOrderItemsQuentity(Integer orderItemsQuentity) {
		this.orderItemsQuantity = orderItemsQuentity;
	}

	public OrderLineItemUnitType getOrderItemUnit() {
		return orderItemUnit;
	}

	public void setOrderItemUnit(OrderLineItemUnitType orderItemUnit) {
		this.orderItemUnit = orderItemUnit;
	}
	
}
