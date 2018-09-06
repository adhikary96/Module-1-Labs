package com.cg.booking.dao;

import com.cg.booking.bean.Request;
import com.cg.booking.exception.BookingException;

public interface IBookingDAO {
	int addRequest(Request request) throws BookingException;
	Request getRequestByID(int id) throws BookingException;

}
