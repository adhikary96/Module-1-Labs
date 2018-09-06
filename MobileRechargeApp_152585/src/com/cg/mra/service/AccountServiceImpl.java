package com.cg.mra.service;

import com.cg.mra.bean.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.db.AccountDb;
import com.cg.mra.exception.MobileRechargeException;

/**
 * Class Name: AccountServiceImpl
 * Interface Implemented: AccountService
 * No. Of Methods: 4
 * Purpose of Class: To send data from DAO to UI, and perform validation of mobile number
 * Author: Deepraj Adhikary
 * Date of Creation: July 11, 2018
 * Date of Last Modification: July 11, 2018
 * Name of Methods: getAccountDetails, rechargeAccount, validateMobile, check
 * 
 */

public class AccountServiceImpl implements AccountService {
AccountDao accountDao = new AccountDaoImpl();
AccountDb  accountDb = new AccountDb();
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
	public Account getAccountDetails(String mobileNo)
			throws MobileRechargeException {
		// TODO Auto-generated method stub
		return accountDao.getAccountDetails(mobileNo);
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
	public int rechargeAccount(String mobileNo, double rechargeAmount){
		// TODO Auto-generated method stub
		return accountDao.rechargeAccount(mobileNo, rechargeAmount);
	}
	/**
	 * Method Name: validateMobile
	 * Purpose of Method: To accept mobile number, return true if mobile no is valid, else return false
	 * Return type: boolean
	 * Parameters Required: String mobile number
	 * Author: Deepraj Adhikary
	 * Date of Creation: July 11, 2018
	 * Date of Last Modification: July 11, 2018
	 * 
	 */
	public boolean validateMobile(String mobile) throws MobileRechargeException{
		if(!mobile.matches("\\d{10}"))
			throw new MobileRechargeException("Mobile number should contain 10 digits.");
		return true;
	}
	/**
	 * Method Name: check
	 * Purpose of Method: To accept mobile number, return true if account related to the mobile number exists, 
	 * 			else return false
	 * Return type: boolean
	 * Parameters Required: String mobile number
	 * Author: Deepraj Adhikary
	 * Date of Creation: July 11, 2018
	 * Date of Last Modification: July 11, 2018
	 * 
	 */
	public boolean check(String mobile) throws MobileRechargeException{
		Account account = accountDb.getAccountDB().get(mobile);
		if(account == null)
			throw new MobileRechargeException("Given Mobile No Does Not Exist");
		return false;
	}
	

}
