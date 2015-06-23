package com.tarena.netctoss.action.role;

import java.util.Arrays;
import java.util.List;

import com.tarena.netctoss.action.BaseAction;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;
import com.tarena.netctoss.dao.RolePrivilegeDAO;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.entity.Role;
import com.tarena.netctoss.util.PrivilegeReader;

public class RoleModifyAction extends BaseAction{
	private Role role ;
	private String ok = "1";
	private List<Privilege> privileges = PrivilegeReader.getPrivilege();
	private RoleDAO roleDAO = DAOFactory.getRoleDAO();
	private RolePrivilegeDAO rolePrivilegeDAO = DAOFactory.getRolePrivilegeDAO();
	public String execute(){
	
		try {
			System.out.println(Arrays.toString(role.getRoleIds()));
			System.out.println(role.getId());
			System.out.println(role.getName());
			roleDAO.ModifyRole(role);
			role.setRoleIds2(rolePrivilegeDAO.findRolePrivilegeById(role.getId()));
			
			ok="1";
		} catch (DAOException e) {
			e.printStackTrace();
			ok="0";
		}
		return "success";
	}
	public String getOk() {
		return ok;
	}
	public void setOk(String ok) {
		this.ok = ok;
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
