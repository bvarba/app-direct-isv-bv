package com.bvarba.appdirect.domain.dal.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserProfile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "user_id")
	private Integer userId;

	private String email;
	private String firstName;
	private String language;
	private String lastName;
	private String locale;
	private String openId;
	private String uuid;

	private Boolean isAdmin;


	@ManyToOne
	@JoinColumn(name = "subscription_id")
	private SubscriptionAccount subscriptionAccount;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public SubscriptionAccount getSubscriptionAccount() {
		return subscriptionAccount;
	}

	public void setSubscriptionAccount(SubscriptionAccount subscriptionAccount) {
		this.subscriptionAccount = subscriptionAccount;
	}	
}
