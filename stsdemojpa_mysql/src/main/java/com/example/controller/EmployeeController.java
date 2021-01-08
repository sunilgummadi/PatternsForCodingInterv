/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appexception.RecordNotFoundException;
import com.example.entity.Employee;
import com.example.service.EmployeeServiceImp;

/**
 * @author sunil
 *
 */
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceImp employeeService;

	@GetMapping("/one")
	public String testEmployee() {
		return "test";
	}
	
	@PostMapping("/create")
	public Employee createStudent(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
		
	}
	@GetMapping("/read/{id}")
	public Employee readEmployee(@PathVariable("id") long id) {
		try {
			return employeeService.getEmployeeById(id);
		} catch (RecordNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	@GetMapping("/readAll")
	public List<Employee> readAllEmployee(){
		
		return employeeService.getAllEmployee();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable("id") long id) {
		employeeService.deleteEmployee(id);
	}
}
