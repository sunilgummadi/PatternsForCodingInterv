/**
 * 
 */
package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appexception.RecordNotFoundException;
import com.example.entity.Employee;
import com.example.service.EmployeeService;

/**
 * @author sunil
 *
 */
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService service;

	 @GetMapping(value = "/getall")
	public ResponseEntity<List<Employee>> getAllEmployees() {
	List<Employee> list = service.getAllEmployees();

	 return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	 @GetMapping("fetch/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
	Employee entity = service.getEmployeeById(id);

	 return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	 @PostMapping(value = "/create")
	public ResponseEntity<Employee> createOrUpdateEmployee(@RequestBody Employee employee) throws RecordNotFoundException {
	Employee updated = service.createOrUpdateEmployee(employee);
	return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	 @DeleteMapping("del/{id}")
	public HttpStatus deleteEmployeeById(@PathVariable("id") Long id) throws RecordNotFoundException {
	service.deleteEmployeeById(id);
	return HttpStatus.FORBIDDEN;
	}
	 
	 @GetMapping("/lastname/{name}")
	 public List<Employee> readByLastName(@PathVariable("name") String lastName) {
		 return service.getByLastName(lastName);
	 }
	 
	 @GetMapping("/firstlast/{first}/{last}")
	 public List<Employee> readByFirstNameAndLastName(@PathVariable("first") String firstName,@PathVariable("last")String lastName){
		 
		 return service.getByFirstAndLastName(firstName, lastName);
	 }
	 
	 @GetMapping("/endswith/{name}")
	 public List<Employee> readByFirstnameEndsWith(@PathVariable("name") String firstName){
		 return service.getByFirstnameEndsWith(firstName);
	 }
}
