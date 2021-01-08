/**
 * 
 */
package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Employee;

/**
 * @author sunil
 *
 */
public interface EmployeeDao extends JpaRepository<Employee, Long> {

	//  custom query
	public List<Employee> findByLastName(String name);
	
	public List<Employee> findByFirstNameAndLastName(String firstName,String lastName);
	
	@Query("select e from Employee e where e.firstName like '%day'")
	public List<Employee> findByFirstnameEndsWith(String firstName);
}
