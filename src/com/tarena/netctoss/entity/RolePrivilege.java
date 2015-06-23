package com.tarena.netctoss.entity;

public class RolePrivilege extends Entity{
	private Integer RoleId;
	private Integer PrivilegeId;
	public Integer getRoleId() {
		return RoleId;
	}
	public void setRoleId(Integer roleId) {
		RoleId = roleId;
	}
	public Integer getPrivilegeId() {
		return PrivilegeId;
	}
	public void setPrivilegeId(Integer privilegeId) {
		PrivilegeId = privilegeId;
	}

}
