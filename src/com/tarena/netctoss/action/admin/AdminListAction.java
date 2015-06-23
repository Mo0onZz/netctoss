package com.tarena.netctoss.action.admin;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.AdminDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;
import com.tarena.netctoss.entity.Admin;
import com.tarena.netctoss.entity.Role;
import com.tarena.netctoss.util.PrivilegeReader;

public class AdminListAction {
	private int page = 1;
	private int totalPage;
	private Map<String,String> privilegeOptions = new LinkedHashMap();
	private RoleDAO roleDAO = DAOFactory.getRoleDAO();
	private List<Role> roles;
	private AdminDAO adminDAO = DAOFactory.getAdminDAO();
	private List<Admin> admins;
	private String privilegeId;
	private String roleName;
	
	public String execute() throws DAOException{
		PrivilegeReader pr = new PrivilegeReader();
		privilegeOptions.put("-1", "全部");
		
		roles = roleDAO.findAll();
		totalPage = adminDAO.getTotalPage(privilegeId, roleName, 10);
		admins = adminDAO.findAdmimListByConditions(privilegeId, roleName, page, 10);
		
		return "success";
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
	public List<Admin> getAdmins() {
		return admins;
	}
	public void setAdmins(List<Admin> admins) {
		this.admins = admins;
	}
	public String getPrivilegeId() {
		return privilegeId;
	}
	public void setPrivilegeId(String privilegeId) {
		this.privilegeId = privilegeId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	

}
