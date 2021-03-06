package com.cg.cakeorder.service;

import com.cg.cakeorder.bean1.CakeOrder;
import com.cg.cakeorder.bean2.Customer;
import com.cg.cakeorder.exception.CakeException;

public interface ICakeService {
	public int placeOrder(Customer customer, CakeOrder cake) throws CakeException;
	public boolean validatePhone(String phone) throws CakeException;
	CakeOrder getOrderDetails(int id) throws CakeException;
}