package com.cg.booking.db;

import java.util.HashMap;

import com.cg.booking.bean.Request;

public class BookingDB {
	private static HashMap<Integer, Request> requestDB = new HashMap<Integer, Request>();

	public static HashMap<Integer, Request> getRequestDB() {
		return requestDB;
	}
	

}
