package com.cg.mra.dao;

import com.cg.mra.bean.Account;
import com.cg.mra.exception.MobileRechargeException;

public interface AccountDao {
	Account getAccountDetails(String mobileNo) throws MobileRechargeException;
	int rechargeAccount(String mobileNo, double rechargeAmount);

}
