/**
 * 
 */
package com.example.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sunil
 *
 */
@Entity
@Table(name = "employee_jpa")
public class Employee implements Serializable {

	@Id
	@Column(name = "id",length = 5)
	private long employeeId;
	@Column(name = "emplooyee_name",length = 25)
	private String employeeName;

	public Employee() {
		super();

	}

	public Employee(long employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + "]";
	}

}
