package com.cg.cakeorder.dao;

import com.cg.cakeorder.bean1.CakeOrder;
import com.cg.cakeorder.bean2.Customer;
import com.cg.cakeorder.exception.CakeException;

public interface ICakeOrderDAO {
	public int placeOrder(Customer customer, CakeOrder cake) throws CakeException;
	CakeOrder getOrderDetails(int id) throws CakeException;

}
