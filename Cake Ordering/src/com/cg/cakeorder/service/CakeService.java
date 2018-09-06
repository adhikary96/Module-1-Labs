
package com.cg.cakeorder.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.cg.cakeorder.bean1.CakeOrder;
import com.cg.cakeorder.bean2.Customer;
import com.cg.cakeorder.dao.CakeOrderDAO;
import com.cg.cakeorder.dao.ICakeOrderDAO;
import com.cg.cakeorder.exception.CakeException;

public class CakeService implements ICakeService{
	ICakeOrderDAO cakeOrderDAO = new CakeOrderDAO();
	FileInputStream fis = null;
	@Override
	public int placeOrder(Customer customer, CakeOrder cake) throws CakeException {
		
		return cakeOrderDAO.placeOrder(customer, cake);
	}
	
	public double calculatePrice(String type) throws CakeException{
		double cost = 0;
		try {
			fis = new FileInputStream("price.properties");
			Properties p = new Properties();
			p.load(fis);
			//String s = p.getProperty(type);
			if(!p.containsKey(type))
				throw new CakeException("Cake Flavour doesnot exist");
			cost = Double.parseDouble(p.getProperty(type));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new CakeException(e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new CakeException(e.getMessage());
		}
		finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new CakeException(e.getMessage());
			}
		}
		return cost;
	}

	@Override
	public boolean validatePhone(String phone) throws CakeException {
		// TODO Auto-generated method stub
		if(!phone.matches("\\d{10}"))
			throw new CakeException("Phone number must contain Exactly 10 digits");
		return true;
	}

	@Override
	public CakeOrder getOrderDetails(int id) throws CakeException {
		// TODO Auto-generated method stub
		return cakeOrderDAO.getOrderDetails(id);
	}
	
	

}
