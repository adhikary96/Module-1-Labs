package com.cg.employee.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cg.employee.bean.Employee;
import com.cg.employee.db.EmployeeDB;
import com.cg.employee.exception.EmployeeException;

public class EmployeeDAO implements IEmployeeDAO {
	
	static HashMap<Integer, Employee> empMap = EmployeeDB.getEmpDB();
	
	@Override
	public Collection<Employee> getAllEmployees() throws EmployeeException {
		try{
			return empMap.values();
		}catch (Exception ex){
			throw new EmployeeException(ex.getMessage());
		}
	}

	@Override
	public Employee getEmployeeByID(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		Employee emp = empMap.get(id);
		if(emp == null){
			throw new EmployeeException("Employe with ID:"+id+" does not exist in the Database");
		}
		return emp;
	}

	@Override
	public int addEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		if(empMap.containsKey(emp.getId()))
			throw new EmployeeException("Employee with Id:"+emp.getId()+" already exists in the Database");
		empMap.put(emp.getId(), emp);
		return emp.getId();
	}

	@Override
	public int deleteEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		if(!empMap.containsKey(id))
			throw new EmployeeException("Employee with Id:"+id+" does not exists in the Database");
		empMap.remove(id);
		return id;
	}

	@Override
	public List<Employee> getEmployeeByDesignation(String designation) throws EmployeeException {
		// TODO Auto-generated method stub
		try{
			List<Employee> employees = empMap.values().stream()
					.filter(x->x.getDesignation().equals(designation)).collect(Collectors.toList());
			if(employees == null || employees.size() == 0)
				throw new EmployeeException("Invalid Designation. Please enter a valid Designation");
			return employees;
		}catch(Exception e){
			throw new EmployeeException(e.getMessage());
		}
	}

	@Override
	public Employee findSeniorMostEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		Optional<Employee> emp = empMap.values().stream().min((x,y)->x.getDoj().compareTo(y.getDoj()));
		return emp.get();
	}

	@Override
	public int updateEmployee(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		try {
			empMap.replace(emp.getId(), emp);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new EmployeeException(e.getMessage());
		}
		return emp.getId();
	}

}
