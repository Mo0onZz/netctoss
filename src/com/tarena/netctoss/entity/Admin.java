package com.tarena.netctoss.entity;

import java.util.Date;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;

public class Admin extends Entity{
//	 ID NUMBER(11) CONSTRAINT ADMIN_INFO_ID_PK PRIMARY KEY,
//	 ADMIN_CODE VARCHAR2(30) UNIQUE��NOT NULL,
//	 PASSWORD VARCHAR2(30) NOT NULL,
//	 NAME VARCHAR2(30) NOT NULL,
//	 TELEPHONE VARCHAR2(30),
//	 EMAIL VARCHAR2(50),
//	 ENROLLDATE DATE NOT NULL
	private String adminCode;
	private String password;
	private String name;
	private String telephone;
	private String email;
	private Date enrolldate;
	private Integer[] roles;
	

	public Integer[] getRoles() {
		return roles;
	}
	public String getRole() throws DAOException{
		RoleDAO roleDAO = DAOFactory.getRoleDAO();
		StringBuilder sb = new StringBuilder("");
		for(int i = 0 ; i < roles.length ; i ++ ){
			sb.append(roleDAO.findById(roles[i]).getName());
			if(i<roles.length-1){
				sb.append(",");
			}
		}
		return sb.toString();
	}
	public void setRoles(Integer[] roles) {
		this.roles = roles;
	}
	private int id ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAdminCode() {
		return adminCode;
	}
	public void setAdminCode(String adminCode) {
		this.adminCode = adminCode;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEnrolldate() {
		return enrolldate;
	}
	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}
	
}
