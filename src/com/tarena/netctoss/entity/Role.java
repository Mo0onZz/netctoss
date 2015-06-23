package com.tarena.netctoss.entity;

import java.util.List;

import com.tarena.netctoss.util.PrivilegeReader;

public class Role extends Entity{
	private Integer id;
	private String name;
	private Integer[] roleIds;
	private List<Integer> roleIds2;
	
	public String getPrivilegeNames(){
		//根据roleIds获取privilege的name拼串
		PrivilegeReader reader = new PrivilegeReader();
		StringBuilder  str = new StringBuilder("");
		for(int i = 0 ; i < roleIds.length ; i ++ ){
			str.append(reader.findPrivileNamegeById(roleIds[i].toString()));
			if(i<roleIds.length-1){
				str.append("、");
			}
		}
		return str.toString();
	}
	
	public List<Integer> getRoleIds2() {
		return roleIds2;
	}
	public void setRoleIds2(List<Integer> roleIds2) {
		this.roleIds2 = roleIds2;
	}
	public Integer[] getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(Integer[] roleIds) {
		this.roleIds = roleIds;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args){
		
	}
}

