/**
 * 
 */
package com.example.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Employee;

/**
 * @author sunil
 *
 */

@Repository
public interface EmployeeDaa extends CrudRepository<Employee, Long> {

}
