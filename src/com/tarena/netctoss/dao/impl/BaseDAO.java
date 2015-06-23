package com.tarena.netctoss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.entity.Entity;
import com.tarena.netctoss.util.DBUtil;

public abstract class BaseDAO {

	protected final List query(String sql,Object[] arguments) throws DAOException{
		Connection conn = null;
		List<Entity> entitys = new ArrayList<Entity>();
		try{
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if(arguments!=null&&arguments.length>0){
				for(int i = 0 ; i < arguments.length ; i ++	){
					ps.setObject(i+1, arguments[i]);
				
				}
			}
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				
				entitys.add(toEntity(rs));
			}
			return entitys;
			
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("数据库访问异常",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	protected final int query2(String sql , int rows) throws DAOException{
		int totalpage = 0;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				int data =  rs.getInt(1);
				if(data%rows!=0){
					totalpage=data/rows+1;
				}else{
					totalpage=data/rows;
				}
			}
		}catch(Exception e){
			
			throw new DAOException("数据库访问异常",e);
			
		}finally{
			DBUtil.closeConnection(conn);
		}
		return totalpage;
		
	}
	protected final int update(String sql , Object[] arguments) throws DAOException{
		Connection conn = null;
		
		try{
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			if(arguments!=null&&arguments.length>0){
				for(int i = 0 ; i < arguments.length ; i ++){
					ps.setObject(i+1, arguments[i]);
				}
			}
			System.out.println(sql);
			System.out.println(Arrays.toString(arguments));
			return ps.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("数据库访问异常",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		
	}

	public abstract Entity toEntity(ResultSet rs)throws SQLException, DAOException;
	
	public String createConditions(Map<String, String> mustConditions,Map<String, String> likeConditions ,int page){
		String conditions = " 1=1 ";
		Set<Entry<String,String>> mustEntry = mustConditions.entrySet();
		for(Entry<String,String> entry : mustEntry){
			if(!("".equals(entry.getValue())||entry.getValue().equals("-1"))){
				if(entry.getKey().equals("S_STATUS")){
					String a = entry.getKey();
					String b = a.replace('_', '.');
					System.out.println(a+","+b);
					conditions +=" and " + b +" = '"+entry.getValue()+"'";
				}else{
					
					
					conditions +=" and " + entry.getKey() +" = '"+entry.getValue()+"'";
				}
			}
		}
		Set<Entry<String,String>> likeEntry = likeConditions.entrySet();
		for(Entry<String,String> entry : likeEntry){
			if(!("".equals(entry.getValue())||entry.getValue().equals("-1"))){
				if(entry.getKey().equals("S_STATUS")){
					String a = entry.getKey();
					String b = a.replace('_', '.');
					System.out.println(a+","+b);
					conditions +=" and " + b +" = '"+entry.getValue()+"'";
				}else{
					
					conditions +=" and " + entry.getKey() + " like '" + entry.getValue()+"%'";
					
				}
			}
		}
		return conditions;
		
	}
	public String createSql(Map<String, String> mustConditions,Map<String, String> likeConditions ,String baseSql ){
		String conditions = " 1=1 ";
		Set<Entry<String,String>> mustEntry = mustConditions.entrySet();
		for(Entry<String,String> entry : mustEntry){
			if(!("".equals(entry.getValue())||entry.getValue().equals("-1"))){
				
				conditions +=" and " + entry.getKey() +"= '"+entry.getValue()+"'";
			}
		}
		Set<Entry<String,String>> likeEntry = likeConditions.entrySet();
		for(Entry<String,String> entry : likeEntry){
			String a = entry.getKey();
			String b = a.replace('_', '.');
			System.out.println(a+","+b);
			if(!("".equals(entry.getValue())||entry.getValue().equals("-1"))){
				conditions +=" and " + entry.getKey() + " like '" + entry.getValue()+"%'";
			}
		}
		
		String sql = baseSql.replace("SOMECONDITIONS", conditions);
		return sql;
		
	}
}











