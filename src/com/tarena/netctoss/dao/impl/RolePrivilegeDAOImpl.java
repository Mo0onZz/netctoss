package com.tarena.netctoss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.RolePrivilegeDAO;
import com.tarena.netctoss.entity.Entity;
import com.tarena.netctoss.entity.RolePrivilege;
import com.tarena.netctoss.util.DBUtil;

public class RolePrivilegeDAOImpl extends BaseDAO implements RolePrivilegeDAO{
	private String findByRoleId = "select PRIVILEGE_ID from ROLE_PRIVILEGE where ROLE_ID=?";

	@Override
	public Entity toEntity(ResultSet rs) throws SQLException {
		RolePrivilege rolePrivilege = new RolePrivilege();
		rolePrivilege.setPrivilegeId(rs.getInt("ROLE_ID"));
		rolePrivilege.setPrivilegeId(rs.getInt("PRIVILEGE_ID"));
		
		return rolePrivilege;
	}
	public List<Integer> findRolePrivilegeById(int id)throws DAOException{
		List<Integer> roleIds = new ArrayList<Integer>();
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(findByRoleId);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				roleIds.add(rs.getInt("PRIVILEGE_ID"));
			}
			return roleIds;
		}catch(Exception e){
			throw new DAOException("数据访问异常",e);	
		}finally{
			DBUtil.closeConnection(conn);
		}
	}
	public Integer[] findByRoleId(int id) throws DAOException {
		List<Integer> roleIdsList = new ArrayList<Integer>();
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(findByRoleId);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				roleIdsList.add(rs.getInt("PRIVILEGE_ID"));
			}
			Integer[] roleIds = new Integer[roleIdsList.size()];
			for(int i = 0 ; i < roleIdsList.size() ; i ++ ){
				roleIds[i] = roleIdsList.get(i);
			}
			return roleIds;
		}catch(Exception e){
			throw new DAOException("数据访问异常",e);	
		}finally{
			DBUtil.closeConnection(conn);
		}
		
	}
	public int deleteById(int id) throws DAOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
