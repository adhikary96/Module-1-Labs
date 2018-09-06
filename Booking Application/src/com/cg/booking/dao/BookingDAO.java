package com.cg.booking.dao;

import java.util.HashMap;
import java.util.Random;

import com.cg.booking.bean.Request;
import com.cg.booking.db.BookingDB;
import com.cg.booking.exception.BookingException;

/**
 * 
 * @author Deepraj Adhikary
 * Date of creation: 10-07-2018
 *
 */
public class BookingDAO implements IBookingDAO{
	static HashMap<Integer, Request> bookingMap = BookingDB.getRequestDB();
	Random rand = new Random();
	@Override
	public int addRequest(Request request) throws BookingException {
		// TODO Auto-generated method stub
		int id = rand.nextInt(1000);
		request.setRequestId(id);
		bookingMap.put(request.getRequestId(), request);
		return request.getRequestId();
	}
	@Override
	public Request getRequestByID(int id) throws BookingException {
		// TODO Auto-generated method stub
		Request req = bookingMap.get(id);
		if(req == null)
			throw new BookingException("Request ID:"+id+" does not exist");
		return req;
	}

}
