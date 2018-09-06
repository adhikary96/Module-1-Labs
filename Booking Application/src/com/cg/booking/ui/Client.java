package com.cg.booking.ui;

import java.time.LocalDate;

import java.util.Scanner;

import com.cg.booking.bean.Request;
import com.cg.booking.exception.BookingException;
import com.cg.booking.service.BookingService;
import com.cg.booking.service.IBookingService;

/**
 * Class name: Client
 * Methods Present: addRequest()
 * 					displayRequest();
 * 
 * @author Deepraj Adhikary
 * Date of Creation: 09-07-2018
 * 
 */

public class Client {
	Scanner sc = new Scanner(System.in);
	//Request req = new Request();
	IBookingService bookingService = new BookingService();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client c = new Client();
		System.out.println("-------Booking App--------");
		String option = "";
		while (true) {
			System.out.println("1. Raise a Request");
			System.out.println("2. View Request Status");
			System.out.println("3. Exit");
			System.out.println("---------------------------");

			System.out.println("Enter option:");
			option = c.sc.nextLine();
			switch (option) {
			case "1":
					c.addRequest();
					break;
			case "2":
					c.displayRequest();
					break;
			case "3":
					System.out.println("Thank you for booking.");
					System.exit(0);
					break;
			default:
					System.out.println("Enter a valid choice betwee 1 to 3");
					break;
			}	//end switch
		}	//while end

	}	//main end
	
	/**
	 * Method Name: addRequest
	 * Return type: void
	 * Purpose: Adding a request placed by the client to the database
	 */
	
	private void addRequest(){
		Request req = new Request();
		System.out.println("Enter Customer name:");
		req.setCustomerName(sc.nextLine());
		
		System.out.println("Enter Phone number:");
		req.setPhone(sc.nextLine());
		
		System.out.println("Enter pickup address:");
		req.setAddressOfPickup(sc.nextLine());
		
		System.out.println("Enter pincode:");
		req.setPinCode(sc.nextLine());
		
		req.setRequestStatus("Not Accepted");
		req.setDateOfRequest(LocalDate.now());
		try {
			boolean res = bookingService.validateRequest(req);
			if(res){
				int ret = bookingService.addRequest(req);
				System.out.println("Request with Id:"+ret+" has been added successfully");
			}
		} catch (BookingException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An error has occured:\n"+e.getMessage());
			System.out.println();
		}
		
	}
	
	private void displayRequest(){
		System.out.println("Enter Request ID:");
		int id = Integer.parseInt(sc.nextLine());
		try {
			Request req = bookingService.getRequestByID(id);
			System.out.println("=====================================");
			System.out.println("Customer name:"+req.getCustomerName());
			System.out.println("Request Status:"+req.getRequestStatus());
			System.out.println("Cab No.:"+req.getCabNumber());
			System.out.println("Request Date:"+req.getDateOfRequest());
			System.out.println("Pickup address:"+req.getAddressOfPickup());
			System.out.println("=====================================");
		} catch (BookingException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An error has occured:\n"+e.getMessage());
			System.out.println();
		}
	}
	
	
}	//end class
