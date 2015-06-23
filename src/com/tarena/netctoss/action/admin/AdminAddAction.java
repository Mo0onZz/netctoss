package com.tarena.netctoss.action.admin;

import java.util.List;

import com.tarena.netctoss.dao.AdminDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;
import com.tarena.netctoss.entity.Admin;
import com.tarena.netctoss.entity.Role;

public class AdminAddAction {
	private List<Role> roles ;
	private Admin admin;
	private String status ;
	private AdminDAO adminDAO = DAOFactory.getAdminDAO();
	private RoleDAO roleDAO = DAOFactory.getRoleDAO();
	public String init(){
		try {
			roles = roleDAO.findAll();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String add(){
		try {
		
			roles = roleDAO.findAll();
			if(adminDAO.AdminAdd(admin)>0){
				status = "1";
			}else{
				status="0";
			}
			
		} catch (DAOException e) {
			status="0";
			e.printStackTrace();
		}
		return "success";
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
