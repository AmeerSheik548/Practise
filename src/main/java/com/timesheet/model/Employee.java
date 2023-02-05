package com.timesheet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="employee_dim")
public class Employee {

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", eMail=" + eMail + ", pwd=" + pwd + "]";
	}
	
	@Column(name="eId")
	private String id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Size(min=3,max=45)
	@Column(name="eName")
	private String name;
	@Id
	@Column(name="eMail")
	private String eMail;
	@Column(name="ePassword")
	private String pwd;
}
