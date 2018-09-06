package com.cg.mra.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cg.mra.bean.Account;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.db.AccountDb;
import com.cg.mra.exception.MobileRechargeException;

public class TestDao {
	Account account;
	AccountDao accountDao;
	@Before
	public void init() {
		accountDao = new AccountDaoImpl();
	}
	@Test
	public void testRechargeAccount() {
		String mobile = "1111111111";
		account = new AccountDb().getAccountDB().get(mobile);
		account.setAccountBalance(accountDao.rechargeAccount(mobile, 140));
		assertNotEquals(640, account.getAccountBalance());
	}

}
