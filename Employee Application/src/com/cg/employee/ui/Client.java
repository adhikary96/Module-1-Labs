package com.cg.employee.ui;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import com.cg.employee.bean.Employee;
import com.cg.employee.exception.EmployeeException;
import com.cg.employee.service.EmployeeService;
import com.cg.employee.service.IEmployeeService;

public class Client {
	
	Scanner scan = new Scanner(System.in);
	IEmployeeService service = new EmployeeService();

	public static void main(String[] args) {
		Client c = new Client();
		String option = "";
		while (true) {
			System.out.println("1. Display All Employees");
			System.out.println("2. Add an employee");
			System.out.println("3. Delete an Employee");
			System.out.println("4. Update an Employee");
			System.out.println("5. Display Employee by ID");
			System.out.println("6. Display Employees by Designation");
			System.out.println("7. Display the most Senior Employee");
			System.out.println("8. Exit");

			System.out.println("Enter your choice:");
			option = c.scan.nextLine();

			switch (option) {
			case "1":
					c.displayAllEmployee();
					break;
			case "2":
					c.addEmployee();
					break;
			case "3":
					c.deleteEmployee();
					break;
			case "4":
					c.updateEmployee();
					break;
			case "5":
					c.displayEmployeeByID();
					break;
			case "6":
					c.displayEmpByDesignation();
					break;
			case "7":
					c.findSenior();
					break;
			case "8":
					System.exit(0);
					break;
			default: System.out.println("Please enter choice from 1 to 8");
					break;
			} //end of switch

		} //end of while

	} //end of main
	
	private void displayAllEmployee(){
		try {
			Collection<Employee> employees = service.getAllEmployees();
			employees.forEach(System.out::println);
		} catch (EmployeeException e) {
			System.out.println();
			System.err.println("An Error has occured:\n"+e.getMessage());
			System.out.println();
		}
	}
	
	public void displayEmployeeByID(){
		System.out.println("Enter Employee id:");
		int id = Integer.parseInt(scan.nextLine());
		try {
			Employee emp = service.getEmployeeByID(id);
			System.out.println(emp);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An Error has occured:\n"+e.getMessage());
			System.out.println();
		}
	}
	
	public void addEmployee(){
		Employee emp = new Employee();
		System.out.println("Enter Employee ID:");
		emp.setId(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Enter Employee Name:");
		emp.setName(scan.nextLine());
		
		System.out.println("Enter Employee gender:");
		emp.setGender(scan.nextLine());
		
		System.out.println("Enter Employee Age:");
		emp.setAge(Integer.parseInt(scan.nextLine()));
		
		System.out.println("Enter employee designation:");
		emp.setDesignation(scan.nextLine());
				
		System.out.println("Enter Employee Mobile number:");
		emp.setMobile(scan.nextLine());
		
		System.out.println("Enter Employee salary:");
		emp.setSalary(Double.parseDouble(scan.nextLine()));
		
		emp.setDoj(LocalDate.now());	//Date of joining is the current date
		
		try {
			boolean result = service.validateEmployee(emp);
			if(result){
				int res = service.addEmployee(emp);
				System.out.println("Employee with Id:"+res+" has been added to the database");
			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An Error has occured:\n"+e.getMessage());
			System.out.println();
		}		
	}
	private void deleteEmployee(){
		System.out.println("Enter Employee ID:");
		int id = Integer.parseInt(scan.nextLine());
		try {
			int result = service.deleteEmployee(id);
			System.out.println("Employee with Id:"+result+" has been deleted from the database");
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An Error has occured:\n"+e.getMessage());
			System.out.println();
		}
	}
	
	private void updateEmployee(){
		System.out.println("Enter Employee Id to be updated:");
		int id = Integer.parseInt(scan.nextLine());
		try {
			Employee emp = service.getEmployeeByID(id);
			System.out.println("Employee Current Details:");
			System.out.println(emp);
			
			System.out.println("Enter Employee Name:");
			emp.setName(scan.nextLine());
			
			System.out.println("Enter Employee gender:");
			emp.setGender(scan.nextLine());
			
			System.out.println("Enter Employee Age:");
			emp.setAge(Integer.parseInt(scan.nextLine()));
			
			System.out.println("Enter employee designation:");
			emp.setDesignation(scan.nextLine());
					
			System.out.println("Enter Employee Mobile number:");
			emp.setMobile(scan.nextLine());
			
			System.out.println("Enter Employee salary:");
			emp.setSalary(Double.parseDouble(scan.nextLine()));
			
			boolean result = service.validateEmployee(emp);
			if(result){
				int res = service.updateEmployee(emp);
				System.out.println("Employee with Id:"+res+" has been updated successfully");
			}
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An Error has occured:\n"+e.getMessage());
			System.out.println();
		}
		
	}
	
	private void displayEmpByDesignation(){
		System.out.println("Enter Designation:");
		String des = scan.nextLine();
		try {
			List<Employee> employees = service.getEmployeeByDesignation(des);
			employees.forEach(System.out::println);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An Error has occured:\n"+e.getMessage());
			System.out.println();
		}
	}
	
	private void findSenior(){
		try {
			Employee emp = service.findSeniorMostEmployee();
			System.out.println(emp);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			System.out.println();
			System.err.println("An Error has occured:\n"+e.getMessage());
			System.out.println();
		}
	}
	

} // end of class
