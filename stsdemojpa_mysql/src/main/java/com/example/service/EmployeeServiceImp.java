/**
 * 
 */
package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appexception.RecordNotFoundException;
import com.example.dao.EmployeeDaa;
import com.example.entity.Employee;

/**
 * @author sunil
 *
 */
@Service
public class EmployeeServiceImp {

	@Autowired
	private EmployeeDaa employeeDaa;

	public Employee saveEmployee(Employee employee) {

		employee = employeeDaa.save(employee);
		return employee;
	}

	public Employee getEmployeeById(long id) throws RecordNotFoundException {
		Optional<Employee> optional = employeeDaa.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new RecordNotFoundException("No such employee found");
		}
		// return null;
	}

	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeDaa.findAll();
	}

	public void deleteEmployee(long id) {
		employeeDaa.deleteById(id);

	}
}
