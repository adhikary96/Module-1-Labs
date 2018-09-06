package com.cg.employee.db;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;

import com.cg.employee.bean.Employee;

public class EmployeeDB {
	private static HashMap<Integer, Employee> empDB = new HashMap<Integer, Employee>();

	public static HashMap<Integer, Employee> getEmpDB() {
		return empDB;
	}
	
	static{
		empDB.put(1001, new Employee(1001, "Deepraj", "Male", 21
				, LocalDate.of(2016, Month.JUNE, 13), "Programmer", "1111111111", 30000));
		empDB.put(1002, new Employee(1002, "Anjali", "Female", 25
				, LocalDate.of(2016, Month.AUGUST, 15), "Analyst", "2222222222", 25000));
		empDB.put(1003, new Employee(1003, "Rahul", "Male", 24
				, LocalDate.of(2016, Month.NOVEMBER, 14), "Consultant", "3333333333",  26000));
		empDB.put(1004, new Employee(1004, "Anu", "Female", 45
				, LocalDate.of(2003, Month.JANUARY, 25), "Manager", "4444444444",  50000));
		empDB.put(1005, new Employee(1005, "John", "Male", 30
				, LocalDate.of(2012, Month.JANUARY, 05), "Team Lead", "5555555555", 36000));
		empDB.put(1006, new Employee(1006, "Sam", "Male", 35
				, LocalDate.of(1996, Month.JANUARY, 15), "Team Lead", "6666666666", 36000));
		
	}

}
