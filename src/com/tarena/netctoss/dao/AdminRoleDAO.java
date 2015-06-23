package com.tarena.netctoss.dao;

public interface AdminRoleDAO {
	public Integer[] findByAdminId(int id)throws DAOException;
}
