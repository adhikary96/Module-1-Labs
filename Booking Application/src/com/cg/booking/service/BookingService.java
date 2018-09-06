package com.cg.booking.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.cg.booking.bean.Request;
import com.cg.booking.dao.BookingDAO;
import com.cg.booking.dao.IBookingDAO;
import com.cg.booking.exception.BookingException;

public class BookingService implements IBookingService {
IBookingDAO bookingDAO = new BookingDAO(); 
	@Override
	public int addRequest(Request request) throws BookingException {
		// TODO Auto-generated method stub
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("pincode.properties");
			Properties p = new Properties();
			p.load(fis);
			String cabNo = p.getProperty(request.getPinCode());
			if(cabNo!=null){
				request.setRequestStatus("Accepted");
				request.setCabNumber(cabNo);
			}
		} catch (FileNotFoundException e) {
			throw new BookingException(e.getMessage());
		} catch (IOException e) {
			throw new BookingException(e.getMessage());
		} finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new BookingException(e.getMessage());
			}
		}
		
		return bookingDAO.addRequest(request);
	}
	@Override
	public boolean validateRequest(Request request) throws BookingException {
		// TODO Auto-generated method stub
		if(validateName(request.getCustomerName())
				&&validatePhone(request.getPhone())&&validatePincode(request.getPinCode()))
			return true;
		return false;
	}
	
	private boolean validateName(String name) throws BookingException{
		if(name.isEmpty()|| name == null)
			throw new BookingException("Customer Name cannot be empty");
		else{
			if(!name.matches("[A-Z][A-Za-z\\s]{2,}"))
				throw new BookingException("Name must start with a Capital Letter "
						+ "and should contain only alphabets and spaces");
		}
		return true;
	}
	private boolean validatePhone(String phone) throws BookingException{
		if(!phone.matches("\\d{10}"))
			throw new BookingException("Phone number must contain 10 digits only");
		return true;
	}
	private boolean validatePincode(String pin) throws BookingException{
		if(!pin.matches("\\d{6}"))
			throw new BookingException("Pincode must have exactly 6 digits");
		return true;
	}
	@Override
	public Request getRequestByID(int id) throws BookingException {
		// TODO Auto-generated method stub
		
		return bookingDAO.getRequestByID(id);
	}

}
