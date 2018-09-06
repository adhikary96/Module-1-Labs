package com.cg.cakeorder.ui;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

import com.cg.cakeorder.bean1.CakeOrder;
import com.cg.cakeorder.bean2.Customer;
import com.cg.cakeorder.exception.CakeException;
import com.cg.cakeorder.service.CakeService;
import com.cg.cakeorder.service.ICakeService;

public class Client {
	Scanner sc = new Scanner(System.in);
	ICakeService cakeService = new CakeService();
	public static void main(String[] args) {
		Client c = new Client();
		System.out.println("Cake Ordering App");
		String option = "";
		while (true) {
			System.out.println("1. PLace Order");
			System.out.println("2. Display Order");
			System.out.println("3. Exit");

			System.out.println("Enter your choice:");
			option = c.sc.nextLine();
			switch (option) {
			case "1":
					c.placeOrder();
				break;
			case "2":
					c.displayOrder();
				break;
			case "3":
				c.sc.close();
				System.exit(0);
				break;
			default:
				break;
			}//switch
		}//while
	}//main method
	
	private void placeOrder(){
		CakeOrder cake = new CakeOrder();
		Customer customer = new Customer();
		CakeService c = new CakeService();
				
		System.out.println("Enter name of the Customer:");
		customer.setCustName(sc.nextLine());
		
		System.out.println("Enter Customer Address:");
		customer.setAddress(sc.nextLine());
		
		System.out.println("Enter customer Phone Number:");
		customer.setPhone(sc.nextLine());
		
		System.out.println("Type of cake:");
		String type = sc.nextLine();
		
		try {
			boolean res = cakeService.validatePhone(customer.getPhone());
			double price = c.calculatePrice(type);
			price += 500.0;
			cake.setTotalPrice(price);
			System.out.println("Price:"+cake.getTotalPrice());
			System.out.println("Order Date:"+LocalDate.now());
			if(res){
				int id = cakeService.placeOrder(customer, cake);
				System.out.println("Cake order successfully places with Order Id:"+id);
			}
		} catch (CakeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An error has occured:\n"+e.getMessage());
			System.out.println();
		}
	}
	
	private void displayOrder(){
		System.out.println("Enter Order ID:");
		int id = Integer.parseInt(sc.nextLine());
		CakeOrder co;
		try {
			co = cakeService.getOrderDetails(id);
			System.out.println("=====================================");
			System.out.println("Customer ID:"+co.getCustomerId());
			System.out.println("Order ID:"+co.getOrderId());
			System.out.println("Total Price:"+co.getTotalPrice());
			System.out.println("=====================================");
		} catch (CakeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An error has occured:\n"+e.getMessage());
			System.out.println();
		}	
	}
}
