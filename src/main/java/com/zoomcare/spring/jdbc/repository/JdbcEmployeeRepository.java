package com.zoomcare.spring.jdbc.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zoomcare.spring.jdbc.model.Employee;


@Repository
public class JdbcEmployeeRepository implements EmployeeRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Employee findEmployeeById(Long ID) {
		
		try {
			Employee employee = jdbcTemplate.queryForObject("SELECT EMPLOYEE.ID, PROPERTY.KEY, PROPERTY.VALUE, EMPLOYEE.SUPERVISOR_ID FROM\r\n"
					+ "EMPLOYEE INNER JOIN PROPERTY ON EMPLOYEE.ID = PROPERTY.EMPLOYEE_ID WHERE\r\n"
					+ "EMPLOYEE.ID = ?", BeanPropertyRowMapper.newInstance(Employee.class), ID);

			return employee;
			
			
		}catch(IncorrectResultSizeDataAccessException e) {
			return null;
		}
	}
	
	  @Override
	  public List<Employee> findTopLevelEmployees() {
		  
		  List<Employee> employees = new ArrayList<Employee>();
		  
	      System.out.println("topEmployees = " + employees);

		  
	    employees =  jdbcTemplate.query("SELECT EMPLOYEE.ID, PROPERTY.KEY, PROPERTY.VALUE, EMPLOYEE.SUPERVISOR_ID\r\n"
	    		+ "FROM EMPLOYEE \r\n"
	    		+ "INNER JOIN PROPERTY ON EMPLOYEE.ID = PROPERTY.EMPLOYEE_ID\r\n"
	    		+ "WHERE VALUE LIKE '%CEO%'\r\n"
	    		+ "OR VALUE LIKE '%Director%'\r\n"
	    		+ "OR VALUE LIKE '%President%'"
, new RowMapper() {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setID(rs.getLong("ID"));
        employee.setKEY(rs.getString("KEY"));
        employee.setVALUE(rs.getString("VALUE"));
        employee.setSUPERVISOR_ID(rs.getLong("SUPERVISOR_ID"));
        return employee;
    }
    });
	    
	      System.out.println("topEmployees = " + employees);
	      
		  return employees;

	  }
	  

}


