package com.zoomcare.spring.jdbc.repository;

import java.util.List;

import com.zoomcare.spring.jdbc.model.Employee;

public interface EmployeeRepository {
	
	Employee findEmployeeById(Long ID);
	
	 List<Employee> findTopLevelEmployees();


}
