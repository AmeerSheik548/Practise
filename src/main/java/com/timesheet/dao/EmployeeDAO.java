package com.timesheet.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.timesheet.model.Employee;

public class EmployeeDAO {
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		
		this.template = template;
	}
	
	public void save(Employee emp) {
		
		System.out.println("called save method");
		String sql = "insert into employee_dim(eId,eName,eEmail,ePassword) values('"+emp.getId()+"','"+emp.getName()+"','"+emp.geteMail()+"','"+emp.getPwd()+"')";
		System.out.println(sql);
		template.update(sql);
	}
	
	public void getPassword(String mail) {
		
		System.out.println("getPassword called");
		String sql = "select ePassword from employee_dim where eEmail = '"+mail+"'";
		System.out.println(sql);
		template.update(sql);
		
	}
}
