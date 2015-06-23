package com.tarena.netctoss.dao;


import java.util.List;
import java.util.Map;

import com.tarena.netctoss.entity.Service;

public interface ServiceDAO {
	public List<Service> findServiceByConditions(Map<String , String> mustConditions , Map<String , String> likeConditions,int page,int rows )throws DAOException;
	public int getTotalPage(int rows )throws DAOException;
	public int serviceAdd(Service service)throws DAOException;
	public Service findServiceByOsAndIp(String os , String ip)throws DAOException;
	public Service findServiceById(Integer id )throws DAOException;
	public int serviceModify(Service service)throws DAOException;
	public int ServiceDelete(int id)throws DAOException;
	public int stopService(String status , int id)throws DAOException;
	public int startService(String status , int id)throws DAOException;
}