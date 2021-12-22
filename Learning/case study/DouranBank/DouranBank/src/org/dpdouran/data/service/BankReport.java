package org.dpdouran.data.service;

public interface BankReport {
	
	String getPersonAccounts();

	Long getBankSum();

	// if error happened show message
	Long getPersonAverage();
}