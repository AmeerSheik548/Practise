package com.timesheet.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.hibernate.service.ServiceRegistryBuilder;

import com.timesheet.dao.EmployeeDAO;
import com.timesheet.model.Employee;

@Controller
public class MyController {

	@Autowired
	EmployeeDAO employeeDao;
	
	@RequestMapping("/login")
	public void clickingLogin(HttpServletResponse res) throws IOException {
		System.out.println("login1 called");
		res.sendRedirect("login.jsp");
	}
	
	@RequestMapping("/reg")
	public void clickingRegistration(HttpServletResponse res) throws Exception {
		System.out.println("reg called");
		res.sendRedirect("reg.jsp");
	}
	
	@RequestMapping("/registration")
	public void employeeRegistration (HttpServletRequest req) {
		
		System.out.println("login2 called");
		System.out.println("Registration called");
		Employee emp=new Employee();
		emp.setId(req.getParameter("eId"));
		emp.setName(req.getParameter("eName"));
		emp.seteMail(req.getParameter("eEmail"));
		emp.setPwd(req.getParameter("pwd"));
		System.out.println(emp.getId()+":"+emp.getName()+":"+emp.geteMail()+":"+emp.getPwd());
		employeeDao.save(emp);
	}
	
	@RequestMapping("loggingchecking")
	public void logginChecking(HttpServletRequest req) {
		
		Employee emp = new Employee();
		String enteredMail = req.getParameter("mail");
		String enteredPassword = req.getParameter("pwd");
		Configuration config =new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf = config.buildSessionFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		emp = (Employee)s.get(Employee.class, enteredMail);
		String password = emp.getPwd();
		System.out.println(password);
		
	}
}
