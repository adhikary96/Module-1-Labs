package com.cg.employee.dao;

import java.util.Collection;
import java.util.List;

import com.cg.employee.bean.Employee;
import com.cg.employee.exception.EmployeeException;

public interface IEmployeeDAO {
	Collection<Employee> getAllEmployees() throws EmployeeException;
	
	Employee getEmployeeByID(int id) throws EmployeeException;
	int addEmployee(Employee emp) throws EmployeeException;
	int deleteEmployee(int id) throws EmployeeException;
	List<Employee> getEmployeeByDesignation(String designation) throws EmployeeException;
	Employee findSeniorMostEmployee() throws EmployeeException;
	int updateEmployee(Employee emp) throws EmployeeException;
	
}
