package com.tarena.netctoss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.RoleDAO;
import com.tarena.netctoss.entity.Entity;
import com.tarena.netctoss.entity.Role;
import com.tarena.netctoss.util.DBUtil;

public class RoleDAOImpl extends BaseDAO implements RoleDAO{
	private String AddRole ="insert into role(ID,NAME) values(s_role.nextval,?)";
	private String AddRole_Privilege = "insert into ROLE_PRIVILEGE values(?,?)";
	private String findByPage = "select ID , NAME , RN from (select ID , NAME , ROWNUM RN from ROLE where ROWNUM < ?) where rn > =?";
	private String getTotalPage = "select count(*) from ROLE";
	private String findById = "select ID , NAME from ROLE where ID=?";
	private String ModifyRoleName = "update ROLE set NAME=? where ID = ?";
	private String deleteRoleById ="delete from ROLE where ID = ?";
	private String deleteRolePrivilegeById = "delete from ROLE_PRIVILEGE where ROLE_ID = ?";
	private String findAll = "select ID , NAME from ROLE";
	private String findByName = "select ID , NAME from ROLE where NAME = ?";
	public int AddRole(Role role) throws DAOException {
		Connection conn = null;
		try {
			conn=DBUtil.getConnection();
			conn.setAutoCommit(false);
			String [] columns = {"ID"};
			PreparedStatement ps = conn.prepareStatement(AddRole, columns);
			ps.setString(1,role.getName());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			PreparedStatement ps2 = conn.prepareStatement(AddRole_Privilege);
			for(int i : role.getRoleIds()){
				ps2.setInt(1, id);
				ps2.setInt(2, i);
				ps2.addBatch();
			}
			ps2.executeBatch();
			conn.commit();
			
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			throw new DAOException("数据访问异常",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		
		return 0;
	}
	public Map<String,String> getRoleOptions() throws DAOException{
		List<Role> roles = findAll();
		Map<String,String> roleOptions = new LinkedHashMap<String,String>();
		roleOptions.put("-1", "全部");
		for(Role role : roles){
			
		}
		return null;
	}

	@Override
	public Entity toEntity(ResultSet rs) throws SQLException {
		Role role = new Role();
		role.setId(rs.getInt("ID"));
		role.setName(rs.getString("NAME"));
		
		return role;
	}

	public List<Role> findByPage(int page, int row) throws DAOException {
		int start = (page-1)*row + 1;
		int end = start + row;
		List roles = query(findByPage,new Object[]{end , start});
		return roles;
	}

	public int getTotalPage(int row) throws DAOException {
		int pages = query2(getTotalPage,row);
		return pages;
	}

	public Role findById(int id) throws DAOException {
		List<Role> roles = query(findById,new Object[]{id});
		if(roles!=null&&roles.size()>0){
			return roles.get(0);
		}
		return null;
	}

	public int ModifyRole(Role role) throws DAOException {
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(ModifyRoleName);
			ps.setString(1, role.getName());
			ps.setInt(2, role.getId());
			ps.executeUpdate();
			PreparedStatement del = conn.prepareStatement("delete from ROLE_PRIVILEGE where ROLE_ID=?");
			del.setInt(1, role.getId());
			del.executeUpdate();
			PreparedStatement ins = conn.prepareStatement("insert into ROLE_PRIVILEGE(ROLE_ID,PRIVILEGE_ID) values(?,?)");
			for(Integer i : role.getRoleIds()){
				ins.setInt(1, role.getId());
				ins.setInt(2, i);
				ins.addBatch();
			}
			ins.executeBatch();
			conn.commit();
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DAOException("数据访问异常",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return 0;
	}

	public int DeleteById(int id) throws DAOException {
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(deleteRoleById);
			ps.setInt(1, id);
			ps.executeUpdate();
			PreparedStatement ps1 = conn.prepareStatement(deleteRolePrivilegeById);
			ps1.setInt(1, id);
			ps1.executeUpdate();
			conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			throw new DAOException("数据访问异常",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return 0;
	}

	public List<Role> findAll() throws DAOException {
		List roles = query(findAll,null);
		return roles;
	}

	public Role findByName(String name) throws DAOException {
		List<Role> roles = query(findByName,new Object[]{name});
		if(!roles.isEmpty()){
			return roles.get(0);
		}
		return null;
	}



	
}
