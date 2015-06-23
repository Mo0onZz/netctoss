package com.tarena.netctoss.dao;

import java.util.List;

public interface RolePrivilegeDAO {
	public Integer[] findByRoleId(int id)throws DAOException;
	public List<Integer> findRolePrivilegeById(int id)throws DAOException;
	public int deleteById(int id)throws DAOException;
}
