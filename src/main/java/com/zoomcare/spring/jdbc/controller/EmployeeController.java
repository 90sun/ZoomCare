package com.zoomcare.spring.jdbc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zoomcare.spring.jdbc.model.Employee;
import com.zoomcare.spring.jdbc.repository.EmployeeRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	  @GetMapping("/topLevelEmployees")
	  public ResponseEntity<List<Employee>> findTopEmployees(@RequestParam(required = false) String title) {
	    try {
	      List<Employee> topEmployees = new ArrayList<Employee>();


	      employeeRepository.findTopLevelEmployees().forEach(topEmployees::add);
	      
	      
	      if (topEmployees.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	      }

	      return new ResponseEntity<>(topEmployees, HttpStatus.OK);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	  @GetMapping("/employees/{ID}")
	  public ResponseEntity<Employee> findById(@PathVariable("ID") long ID) {
	    Employee employee = employeeRepository.findEmployeeById(ID);

	    if (employee != null) {
	      return new ResponseEntity<>(employee, HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }

}
