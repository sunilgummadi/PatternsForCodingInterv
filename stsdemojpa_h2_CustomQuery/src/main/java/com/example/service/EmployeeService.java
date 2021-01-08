/**
 * 
 */
package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appexception.RecordNotFoundException;
import com.example.dao.EmployeeDao;
import com.example.entity.Employee;

/**
 * @author sunil
 *
 */
@Service
public class EmployeeService {
	/*
	 * @Autowired private EmployeeDao employeeDao;
	 * 
	 * public List<Employee> getAllEmployee(){ List<Employee> employees =
	 * employeeDao.findAll(); if (employees.size()>0) return employees; return new
	 * ArrayList<Employee>(); }
	 * 
	 * public Employee getEmployeeById(long id) { Optional<Employee> optional=
	 * employeeDao.findById(id); if(optional.isPresent()) return optional.get();
	 * return null; //else // throw new
	 * RecordNotFoundException("Employee not found"); }
	 */
	@Autowired
	private EmployeeDao employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employeeList = employeeRepository.findAll();
		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<Employee>();
		}
	}

	public Employee getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public Employee createOrUpdateEmployee(Employee employee) throws RecordNotFoundException {
		Optional<Employee> employeeExisting = employeeRepository.findById(employee.getId());
		if (employeeExisting.isPresent()) {
			Employee oldEntity = employeeExisting.get();
			oldEntity.setFirstName(employee.getFirstName());
			oldEntity.setLastName(employee.getLastName());
			oldEntity.setEmail(employee.getEmail());
			employee = employeeRepository.save(oldEntity);
			return employee;
		} else {
			employee = employeeRepository.save(employee);
			return employee;
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
	
	public List<Employee> getByLastName(String name) {
		return employeeRepository.findByLastName(name);
	}
	
	public List<Employee> getByFirstAndLastName(String firstName , String lastName){
		return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
	}
	
	public List<Employee> getByFirstnameEndsWith(String firstName){
		return employeeRepository.findByFirstnameEndsWith(firstName);
	}
}
