package com.cg.mra.db;

import java.util.HashMap;

import com.cg.mra.bean.Account;

public class AccountDb {
	private static HashMap<String,Account > accountEntry = new HashMap<String, Account>();

	public static HashMap<String, Account> getAccountDB() {
		return accountEntry;
	}
	static{
		accountEntry.put("1111111111", new Account("1111111111", "Idea", "Ramesh", 500.00));
		accountEntry.put("2222222222", new Account("2222222222", "Airtel", "Rajesh", 30.00));
		accountEntry.put("3333333333", new Account("3333333333", "Vodafone", "Anjali", 150.00));
		accountEntry.put("4444444444", new Account("4444444444", "Jio", "Jyothi", 1500.00));
		accountEntry.put("5555555555", new Account("5555555555", "Tata Docomo", "Shruthi", 60.00));
	}

}
