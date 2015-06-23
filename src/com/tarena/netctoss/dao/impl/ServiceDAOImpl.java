package com.tarena.netctoss.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.ServiceDAO;
import com.tarena.netctoss.entity.Entity;
import com.tarena.netctoss.entity.Service;

public class ServiceDAOImpl extends BaseDAO implements ServiceDAO{
	private static final String ServiceAdd = "insert into SERVICE(ID,ACCOUNT_ID,UNIX_HOST,OS_USERNAME,LOGIN_PASSWD,STATUS,CREATE_DATE,PAUSE_DATE,CLOSE_DATE,COST_ID) values(s_service.nextval,?,?,?,?,1,?,null,null,?)";
	private static  final String getTotalpage = "SELECT COUNT(*) FROM service";
	private static final String findServiceByOsAndIp ="select ID , ACCOUNT_ID,UNIX_HOST,OS_USERNAME,LOGIN_PASSWD,STATUS,CREATE_DATE,PAUSE_DATE,CLOSE_DATE,COST_ID from SERVICE where OS_USERNAME=? and UNIX_HOST=?";
	private static final String findServiceById = "select ID , ACCOUNT_ID,UNIX_HOST,OS_USERNAME,LOGIN_PASSWD,STATUS,CREATE_DATE,PAUSE_DATE,CLOSE_DATE,COST_ID from SERVICE where ID=?";
	private static final String serviceModify = "update service set COST_ID=? where ID=?";
	private static final String ServiceDelete = "update service set status=2 where id=?";
	private static final String stopService = "update SERVICE set STATUS=?,PAUSE_DATE=? where ID=?";
	private static final String startService = "update SERVICE set STATUS=?,PAUSE_DATE=null where ID=?";
	public int getTotalPage(int rows) throws DAOException{
		return query2(getTotalpage , rows);
	}
//	ID           NOT NULL NUMBER(10)   
//	ACCOUNT_ID   NOT NULL NUMBER(9)    
//	UNIX_HOST    NOT NULL VARCHAR2(15) 
//	OS_USERNAME  NOT NULL VARCHAR2(8)  
//	LOGIN_PASSWD NOT NULL VARCHAR2(8)  
//	STATUS                CHAR(1)      
//	CREATE_DATE           DATE         
//	PAUSE_DATE            DATE         
//	CLOSE_DATE            DATE         
//	COST_ID      NOT NULL NUMBER(4)    
	public List<Service> findServiceByConditions(Map<String , String> mustConditions , Map<String , String> likeConditions,int page,int rows )throws DAOException{
		String findServiceByConditions = "SELECT ID , ACCOUNT_ID , UNIX_HOST , OS_USERNAME , LOGIN_PASSWD ," +
		"STATUS , CREATE_DATE , PAUSE_DATE , CLOSE_DATE , COST_ID from (select rownum rn , ID , ACCOUNT_ID , UNIX_HOST , OS_USERNAME , LOGIN_PASSWD ," +
		"STATUS , CREATE_DATE , PAUSE_DATE , CLOSE_DATE , COST_ID from SERVICE where SOMECONDITIONS and rownum < ? ) where rn >= ? ";
		String sql = createSql(mustConditions , likeConditions,findServiceByConditions);
		int start = (page-1)*rows + 1;
		int end = start + rows;
		List services = query(sql,new Object[]{end,start});
		return services;
		
	}
	@Override
	public Entity toEntity(ResultSet rs) throws SQLException {
		Service service = new Service();
//		ID           NOT NULL NUMBER(10)   
		service.setId(rs.getInt("ID"));
//		ACCOUNT_ID   NOT NULL NUMBER(9)    
		service.setAccountId(rs.getInt("ACCOUNT_ID"));
//		UNIX_HOST    NOT NULL VARCHAR2(15) 
		service.setUnixHost(rs.getString("UNIX_HOST"));
//		OS_USERNAME  NOT NULL VARCHAR2(8)  
		service.setOsUsername(rs.getString("OS_USERNAME"));
//		LOGIN_PASSWD NOT NULL VARCHAR2(8)  
		service.setLoginPassWD(rs.getString("LOGIN_PASSWD"));
//		STATUS                CHAR(1) 
		service.setStatus(rs.getString("STATUS"));
//		CREATE_DATE           DATE  
		service.setCreateDate(rs.getDate("CREATE_DATE"));
//		PAUSE_DATE            DATE         
		service.setPauseDate(rs.getDate("PAUSE_DATE"));
//		CLOSE_DATE            DATE         
		service.setCloseDate(rs.getDate("CLOSE_DATE"));
//		COST_ID      NOT NULL NUMBER(4)    
		service.setCostId(rs.getInt("COST_ID"));
		return service;
	}

	
	
	public int serviceAdd(Service service) throws DAOException {
//		ID,ACCOUNT_ID,
//		UNIXHOST,OS_USERNAME,
//		LOGIN_PASSWD,STATUS,
//		CREATE_DATE,PAUSE_DATE
//		CLOSE_DATE,COST_ID) values(" +
//				"s_service.nextval,?" +
//				",?,?,?,1,?,null,null,?)";
		return update(ServiceAdd,new Object[]{
				service.getAccountId(),
				service.getUnixHost(),
				service.getOsUsername(),
				service.getLoginPassWD(),
				new java.sql.Date(System.currentTimeMillis()),
				service.getCostId()
				
		});
	}
	public Service findServiceByOsAndIp(String os, String ip)
			throws DAOException {
		List services = query(findServiceByOsAndIp, new Object[]{os,ip});
		if(services!=null&&services.size()>0){
			return (Service) services.get(0);
		}
		return null;
	}
	public Service findServiceById(Integer id) throws DAOException {
		List services = query(findServiceById, new Object[]{id});
		if(services!=null&&services.size()>0){
			return (Service) services.get(0);
		}
		return null;
	}
	public int serviceModify(Service service) throws DAOException {
		return 1;
	//	return update(serviceModify , new Object[]{service.getCostId(),service.getId()});
	}
	public int ServiceDelete(int id) throws DAOException {
		
		return update(ServiceDelete , new Object[]{id});
	}
//	private static final String stopService = "update SERVICE set STATUS=?,PAUSE_DATE=? where ID=?";
//	private static final String startService = "update SERVICE set STATUS=?,PAUSE_DATE=null where ID=?";
	public int startService(String status, int id) throws DAOException {
		
		return update(startService,new Object[]{status,id});
	}
	public int stopService(String status, int id) throws DAOException {
		
		return update(stopService,new Object[]{status,new java.sql.Date(System.currentTimeMillis()),id});
	}



















































}
