package com.cg.booking.bean;

import java.time.LocalDate;

public class Request {
	private int requestId;
	private String customerName;
	private String phone;
	private LocalDate dateOfRequest;
	private String requestStatus;
	private String cabNumber;
	private String addressOfPickup;
	private String pinCode;
	
	//Getters and setters
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getDateOfRequest() {
		return dateOfRequest;
	}
	public void setDateOfRequest(LocalDate dateOfRequest) {
		this.dateOfRequest = dateOfRequest;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public String getCabNumber() {
		return cabNumber;
	}
	public void setCabNumber(String cabNumber) {
		this.cabNumber = cabNumber;
	}
	public String getAddressOfPickup() {
		return addressOfPickup;
	}
	public void setAddressOfPickup(String addressOfPickup) {
		this.addressOfPickup = addressOfPickup;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	

}
