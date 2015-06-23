package com.tarena.netctoss.action.role;

import java.util.List;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;
import com.tarena.netctoss.dao.RolePrivilegeDAO;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.entity.Role;
import com.tarena.netctoss.util.PrivilegeReader;

public class RoleListAction {
	private int page=1;
	private int totalpage ;
	private List<Role> roles;
	private RoleDAO roleDAO = DAOFactory.getRoleDAO();
	private RolePrivilegeDAO rolePrivilegeDAO = DAOFactory.getRolePrivilegeDAO();
	private List<Privilege> privileges = PrivilegeReader.getPrivilege();

	public String execute(){
		try {
			roles = roleDAO.findByPage(page, 5);
			System.out.println(roles.size());
			totalpage = roleDAO.getTotalPage(5);
			
			for(Role role : roles){
				role.setRoleIds( rolePrivilegeDAO.findByRoleId(role.getId()));
//				System.out.println(role.getId());
//				System.out.println(rolePrivilegeDAO.findByRoleId(role.getId()).length);
			}
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
}
