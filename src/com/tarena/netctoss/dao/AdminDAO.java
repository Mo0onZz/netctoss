package com.tarena.netctoss.dao;

import java.util.List;

import com.tarena.netctoss.entity.Admin;

public interface AdminDAO {
	public Admin findAdminByCodeAndPwd(String code , String pwd)throws DAOException;
	public int AdminAdd(Admin admin)throws DAOException;
	public Admin findAdminByCode(String adminCode)throws DAOException;
	public List<Admin> findAdmimListByConditions(String privilegeId,String roleName,int page , int rows)throws DAOException;
	public int getTotalPage(String privilegeId,String roleName,int rows)throws DAOException;
}
