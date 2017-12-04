package com.bvarba.appdirect.domain.rules.exceptions;

public class BusinessRuleFailedException extends RuntimeException{

	private static final long serialVersionUID = -8707966576454928838L;

	public BusinessRuleFailedException(String message) {
		super(message);
	}
}
