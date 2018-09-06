package com.cg.cakeorder.dao;

import java.util.HashMap;
import java.util.Random;

import com.cg.cakeorder.bean1.CakeOrder;
import com.cg.cakeorder.bean2.Customer;
import com.cg.cakeorder.exception.CakeException;

public class CakeOrderDAO implements ICakeOrderDAO{
	HashMap<Integer, CakeOrder> cakeMap = new HashMap<Integer, CakeOrder>();
	HashMap<Integer, Customer> customerMap = new HashMap<Integer, Customer>();

	Random rand = new Random(); 
	@Override
	public int placeOrder(Customer customer, CakeOrder cake) throws CakeException {
		// TODO Auto-generated method stub
		int customerId = rand.nextInt(100);
		int orderId = rand.nextInt(1000);
		
		customer.setCustomerId(customerId);
		
		cake.setCustomerId(customerId);
		cake.setOrderId(orderId);
		
		customerMap.put(customer.getCustomerId(), customer);
		cakeMap.put(cake.getOrderId(), cake);
		
		return cake.getOrderId();
	}
	@Override
	public CakeOrder getOrderDetails(int id) throws CakeException {
		// TODO Auto-generated method stub
		CakeOrder co = cakeMap.get(id);
		if(co == null)
			throw new CakeException("Order ID:"+id+"Does not exist");
		return co;
	}

}
