package com.tarena.netctoss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.netctoss.dao.AdminRoleDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.entity.Entity;
import com.tarena.netctoss.util.DBUtil;

public class AdminRoleDAOImpl extends BaseDAO implements AdminRoleDAO{
	private static final String findRolesByAdminId = "select ROLE_ID from ADMIN_ROLE where ADMIN_ID=?";
	public Integer[] findByAdminId(int id) throws DAOException {
		List<Integer> list = new ArrayList<Integer>();
		Connection conn = null;
		
		try{
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement(findRolesByAdminId);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getInt(1));
			}
			Integer[] roleIds = list.toArray(new Integer[]{});
			return roleIds;
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("数据访问异常",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		
	}
	@Override
	public Entity toEntity(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
