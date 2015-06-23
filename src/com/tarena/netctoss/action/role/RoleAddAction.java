package com.tarena.netctoss.action.role;

import java.util.ArrayList;
import java.util.List;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.entity.Role;
import com.tarena.netctoss.util.PrivilegeReader;

public class RoleAddAction extends BaseAction{
	private List<Privilege> privileges = new ArrayList<Privilege>();
	private Role role = new Role();
	private RoleDAO roleDAO = DAOFactory.getRoleDAO();
	public String init(){
		System.out.println(1);
		privileges = PrivilegeReader.getPrivilege();
		return "success";
	}
	public String add(){
		try {
			privileges = PrivilegeReader.getPrivilege();
			System.out.println(privileges.size());
			System.out.println(privileges);
			roleDAO.AddRole(role);
			request.put("ok",0);
		} catch (DAOException e) {
			System.out.println("异常");
			request.put("ok",1);
			
		}
		return "success";
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public List<Privilege> getPrivileges() {
		return privileges;
	}
	public void setPrivileges(List<Privilege> privileges) {
		this.privileges = privileges;
	}
}
