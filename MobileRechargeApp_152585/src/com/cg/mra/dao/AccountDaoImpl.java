package com.cg.mra.dao;

import java.util.HashMap;

import com.cg.mra.bean.Account;
import com.cg.mra.db.AccountDb;
import com.cg.mra.exception.MobileRechargeException;

/**
 * Class Name: AccountDaoImpl
 * Interface Implemented: AccountDao
 * No. Of Methods: 2
 * Purpose of Class: To perform DAO operations
 * Author: Deepraj Adhikary
 * Date of Creation: July 11, 2018
 * Date of Last Modification: July 11, 2018
 * Name of Methods: getAccountDetails, rechargeAccount
 * 
 */

public class AccountDaoImpl implements AccountDao {
	static HashMap<String, Account> accountMap = AccountDb.getAccountDB();
	
	/**
	 * Method Name: getAccountDetails
	 * Purpose of Method: To accept mobile number and return the account details
	 * Return type: Account
	 * Parameters Required: String mobile number
	 * Author: Deepraj Adhikary
	 * Date of Creation: July 11, 2018
	 * Date of Last Modification: July 11, 2018
	 * 
	 */
	@Override
	public Account getAccountDetails(String mobileNo) throws MobileRechargeException{
		// TODO Auto-generated method stub
		Account account = accountMap.get(mobileNo);
		if(account == null)
			throw new MobileRechargeException("Given Account ID Does Not Exit");
		return account;
	}
	
	/**
	 * Method Name: rechargeAccount
	 * Purpose of Method: To accept mobile number, and amount with which the acount is to be recharged
	 * 		and return the total amount
	 * Return type: integer
	 * Parameters Required: String mobile number, double Recharge Amount
	 * Author: Deepraj Adhikary
	 * Date of Creation: July 11, 2018
	 * Date of Last Modification: July 11, 2018
	 * 
	 */
	
	@Override
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		// TODO Auto-generated method stub
		Account account = accountMap.get(mobileNo);
		double amount = 0;
		amount = rechargeAmount + account.getAccountBalance();
		account.setAccountBalance(amount);
		return (int) amount;
	}

}
