package com.bvarba.appdirect.domain.rules.handlers;

public abstract class BusinessRuleHandler<T> {
	private BusinessRuleHandler<T> successor;

	public BusinessRuleHandler<T> setSuccessor(BusinessRuleHandler<T> successor) {
		this.successor = successor;
		return this.successor;
	}

	public abstract void validate(T incomingBusinessData);

	public void execute(T incomingBusinessData) {
		validate(incomingBusinessData);
		if (successor != null) {
			successor.execute(incomingBusinessData);
		}
	}
}
