package com.tarena.netctoss.dao;

import com.tarena.netctoss.dao.impl.AccountDAOImpl;
import com.tarena.netctoss.dao.impl.AdminDAOImpl;
import com.tarena.netctoss.dao.impl.AdminRoleDAOImpl;
import com.tarena.netctoss.dao.impl.CostDAOImpl;
import com.tarena.netctoss.dao.impl.HostDAOImpl;
import com.tarena.netctoss.dao.impl.RoleDAOImpl;
import com.tarena.netctoss.dao.impl.RolePrivilegeDAOImpl;
import com.tarena.netctoss.dao.impl.ServiceDAOImpl;
import com.tarena.netctoss.dao.impl.ServiceLineDAOImpl;

public class DAOFactory {
	public static CostDAO getCostDAO(){
		CostDAO dao = new CostDAOImpl();
		return dao;
	}
	public static AccountDAO getAccountDAO(){
		AccountDAO accountDAO = new AccountDAOImpl();
		return accountDAO;
		
	}
	public static AdminDAO getAdminDAO(){
		AdminDAO adminDAO = new AdminDAOImpl();
		return adminDAO;
	}
	public static ServiceDAO getServiceDAO(){
		ServiceDAO serviceDAO = new ServiceDAOImpl();
		return serviceDAO;
	}
	public static ServiceLineDAO getSerivceLineDAO(){
		ServiceLineDAO serviceLineDAO = new ServiceLineDAOImpl();
		return serviceLineDAO;
	}
	public static HostDAO getHostDAO(){
		HostDAO hostDAO = new HostDAOImpl();
		return hostDAO;
	}
	public static RoleDAO getRoleDAO(){
		RoleDAO roleDAO = new RoleDAOImpl();
		return roleDAO;
	}
	public static RolePrivilegeDAO getRolePrivilegeDAO(){
		return new RolePrivilegeDAOImpl();
	}
	public static AdminRoleDAO getAdminRoleDAO(){
		return new AdminRoleDAOImpl();
	}
}
