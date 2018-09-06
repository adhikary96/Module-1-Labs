package com.cg.mra.service;

import com.cg.mra.bean.Account;
import com.cg.mra.exception.MobileRechargeException;

public interface AccountService {
	Account getAccountDetails(String mobileNo) throws MobileRechargeException;
	int rechargeAccount(String mobileNo, double rechargeAmount);
	boolean validateMobile(String mobile) throws MobileRechargeException;
	boolean check(String mobile) throws MobileRechargeException;
}
