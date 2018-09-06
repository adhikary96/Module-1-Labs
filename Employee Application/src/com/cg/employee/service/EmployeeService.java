package com.cg.employee.service;

import java.util.Collection;
import java.util.List;

import com.cg.employee.bean.Employee;
import com.cg.employee.dao.EmployeeDAO;
import com.cg.employee.dao.IEmployeeDAO;
import com.cg.employee.exception.EmployeeException;

public class EmployeeService implements IEmployeeService {
	
	IEmployeeDAO employeeDAO = new EmployeeDAO(); 
	
	@Override
	public Collection<Employee> getAllEmployees() throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDAO.getAllEmployees();
	}

	@Override
	public Employee getEmployeeByID(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeByID(id);
	}

	@Override
	public boolean validateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		if(validateName(emp.getName()) && validateMobile(emp.getMobile()) && validateAge(emp.getAge()))
			return true;
		return false;
	}
	
	//VALIDATION FUNCTIONS: Name, Mobile number and Age
	private boolean validateName(String name) throws EmployeeException{
		if(name.isEmpty() || name.equals(null))
			throw new EmployeeException("Employee name cannot be empty.");
		else{
			if(!name.matches("[A-Z][A-Za-z\\s]{2,}"))
				throw new EmployeeException("Name should start with a Capital Letter and must contain only Alphabets.");
		}
		return true;
	}
	private boolean validateMobile(String mobile) throws EmployeeException{
		if(!mobile.matches("\\d{10}"))
			throw new EmployeeException("Mobile number should contain 10 digits.");
		return true;
	}
	private boolean validateAge(int age) throws EmployeeException{
		if(age>=18 && age <=60)
			return true;
		else	
			throw new EmployeeException("Age Should be between 18 and 60.");
	}

	@Override
	public int addEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDAO.addEmployee(emp);
	}

	@Override
	public int deleteEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDAO.deleteEmployee(id);
	}

	@Override
	public List<Employee> getEmployeeByDesignation(String designation)
			throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeByDesignation(designation);
	}

	@Override
	public Employee findSeniorMostEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDAO.findSeniorMostEmployee();
	}

	@Override
	public int updateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		return employeeDAO.updateEmployee(emp);
	}
}
