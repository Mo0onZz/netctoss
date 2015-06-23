package com.tarena.netctoss.action.role;

import java.util.List;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;
import com.tarena.netctoss.dao.RolePrivilegeDAO;
import com.tarena.netctoss.entity.Privilege;
import com.tarena.netctoss.entity.Role;
import com.tarena.netctoss.util.PrivilegeReader;

public class RoleDetailAction {
	private Integer id ;
	private Role role ; 
	//发送权限集合
	private List<Privilege> privileges = PrivilegeReader.getPrivilege();
	private RoleDAO roleDAO = DAOFactory.getRoleDAO();
	private RolePrivilegeDAO rolePrivilegeDAO = DAOFactory.getRolePrivilegeDAO();
	public String execute(){
		try {
			System.out.println(id);
			role = roleDAO.findById(id);
			System.out.println(role);
			role.setRoleIds2(rolePrivilegeDAO.findRolePrivilegeById(role.getId()));
			role.setRoleIds(rolePrivilegeDAO.findByRoleId(role.getId()));
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
