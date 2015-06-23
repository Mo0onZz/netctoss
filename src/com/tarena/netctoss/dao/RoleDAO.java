package com.tarena.netctoss.dao;

import java.util.List;

import com.tarena.netctoss.entity.Role;



public interface RoleDAO {
	public int AddRole(Role role)throws DAOException;
	public List<Role> findByPage(int page, int row)throws DAOException;
	public int getTotalPage(int row)throws DAOException;
	public Role findById(int id)throws DAOException;
	public int ModifyRole(Role role)throws DAOException;
	public int DeleteById(int id)throws DAOException;
	public List<Role> findAll()throws DAOException;
	public Role findByName(String name )throws DAOException;
}
