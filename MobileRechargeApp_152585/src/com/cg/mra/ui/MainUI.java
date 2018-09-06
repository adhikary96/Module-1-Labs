package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.bean.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.db.AccountDb;
import com.cg.mra.exception.MobileRechargeException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

/**
 * Class Name: MainUI
 * No. Of Methods: 2
 * Purpose of Class: To display the menu and Accept the details from the user
 * Author: Deepraj Adhikary
 * Date of Creation: July 11, 2018
 * Date of Last Modification: July 11, 2018
 * Name of Methods: balanceEnquiry, rechargeAccount
 * 
 */

public class MainUI {
	Scanner scanner = new Scanner(System.in);
	AccountService accountService = new AccountServiceImpl();
	AccountDao accountDao = new AccountDaoImpl();
		public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainUI mainUI = new MainUI();
		String option = "";
		while (true) {
			System.out.println("1. Account Balance Enquiry");
			System.out.println("2. Recharge Account");
			System.out.println("3. Exit");

			System.out.println("Enter choice:");
			option = mainUI.scanner.nextLine();
			switch (option) {
			case "1":
				mainUI.balanceEnquiry();
				break;
			case "2":
				mainUI.rechargeAccount();
				break;
			case "3":
				mainUI.scanner.close();
				System.exit(0);
				break;
			default:
				System.out.println("Enter a valid option between 1-3");
				break;
			}
		}// end while

	}// end main method
	
	/**
	 * Method Name: balanceEnquiry
	 * Purpose of Method: To accept Mobile number from the user and display the Current account balance
	 * Return type: void
	 * Author: Deepraj Adhikary
	 * Date of Creation: July 11, 2018
	 * Date of Last Modification: July 11, 2018
	 * 
	 */
	private void balanceEnquiry() {
		System.out.print("Enter Mobile No:");
		String mobileNo = scanner.nextLine();
		try {
			boolean validate = accountService.validateMobile(mobileNo);
			if (validate) {
				Account account = accountService.getAccountDetails(mobileNo);
				System.out.println("Your Current balance is Rs."+ account.getAccountBalance());
			}
		} catch (MobileRechargeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("ERROR:" + e.getMessage());
			System.out.println();
		}
	}

	/**
	 * Method Name: rechargeAccount
	 * Purpose of Method: To accept mobile number and recharge the account with the amount given be the user.
	 * Return type: void
	 * Author: Deepraj Adhikary
	 * Date of Creation: July 11, 2018
	 * Date of Last Modification: July 11, 2018
	 * 
	 */
	private void rechargeAccount() {

		System.out.println("Enter Mobile No:");
		String mobileNo = scanner.nextLine();
		
		try {
			boolean result = accountService.check(mobileNo);
			if(result){
				Account account = accountDao.getAccountDetails(mobileNo);
				System.out.println("Enter Recharge Amount:");
				double recharge = Double.parseDouble(scanner.nextLine());
	
				int newBalance = accountService.rechargeAccount(mobileNo, recharge);
				System.out.println("Your Account Recharged Successfully");
				System.out.println("Hello " + account.getCustomerName() + ", Available Balance is " + newBalance);
			}
			
		} catch (MobileRechargeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("ERROR: Cannot Recharge Account as "	+ e.getMessage());
			System.out.println();
		}
	}

}
