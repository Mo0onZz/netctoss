package com.tarena.netctoss.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tarena.netctoss.dao.AdminDAO;
import com.tarena.netctoss.dao.AdminRoleDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;
import com.tarena.netctoss.entity.Admin;
import com.tarena.netctoss.entity.Entity;
import com.tarena.netctoss.util.DBUtil;

public class AdminDAOImpl extends BaseDAO implements AdminDAO{
	private AdminRoleDAO adminRoleDAO = DAOFactory.getAdminRoleDAO();
	private static final String adminAdd= "insert into ADMIN_INFO(ID, ADMIN_CODE, PASSWORD, NAME, TELEPHONE, EMAIL, ENROLLDATE) values(s_admin.nextval,?,?,?,?,?,?)";
	private static final String findByCode = "select ID, NAME, ADMIN_CODE, PASSWORD, TELEPHONE, EMAIL, ENROLLDATE from ADMIN_INFO where ADMIN_CODE=?";
	String findAdminByCodeAndPwd = "SELECT id,admin_code,password,name,telephone,email,enrolldate " +
			"FROM admin_info WHERE admin_code=? and password=?";
	
	public Admin findAdminByCodeAndPwd(String code, String pwd)
			throws DAOException {
			System.out.println(code+","+pwd);
			List admins = new ArrayList();
			admins = query(findAdminByCodeAndPwd,new Object[]{code,pwd});
			if(admins!=null&&admins.size()>0){
				return (Admin)admins.get(0);
			}
			return null;
	}
	
	@Override
	public Entity toEntity(ResultSet rs) throws SQLException, DAOException {
		
		Admin admin = new Admin();
		admin.setAdminCode(rs.getString("admin_code"));
		admin.setId(rs.getInt("id"));
		admin.setName(rs.getString("name"));
		admin.setEmail(rs.getString("email"));
		admin.setPassword(rs.getString("password"));
		admin.setTelephone(rs.getString("telephone"));
		admin.setEnrolldate(rs.getDate("Enrolldate"));
		try {
			admin.setRoles(adminRoleDAO.findByAdminId(rs.getInt("ID")));
		} catch (DAOException e) {
			e.printStackTrace();
			throw new DAOException("数据访问异常",e);
		}
		return admin;
	}

	public int AdminAdd(Admin admin) throws DAOException {
//		ADMIN_CODE NOT NULL VARCHAR2(30) 
//		PASSWORD   NOT NULL VARCHAR2(30) 
//		NAME       NOT NULL VARCHAR2(30) 
//		TELEPHONE           VARCHAR2(30) 
//		EMAIL               VARCHAR2(50) 
//		ENROLLDATE NOT NULL DATE         
		int count = 0;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			String[] idArr = new String[]{"ID"};
			PreparedStatement ps = conn.prepareStatement(adminAdd,idArr);
			ps.setString(1, admin.getAdminCode());
			ps.setString(2, admin.getPassword());
			ps.setString(3, admin.getName());
			ps.setString(4, admin.getTelephone());
			ps.setString(5, admin.getEmail());
			ps.setDate(6, new java.sql.Date(System.currentTimeMillis()));
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			PreparedStatement ps1 = conn.prepareStatement("insert into ADMIN_ROLE(ADMIN_ID,ROLE_ID) values(?,?)");
			for(int i = 0 ; i < admin.getRoles().length ; i ++ ){
				ps1.setInt(1, id);
				ps1.setInt(2, admin.getRoles()[i]);
				ps1.addBatch();
			}
			ps1.executeBatch();
			conn.commit();
			count = 1;
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
		return count;
	}

	public Admin findAdminByCode(String adminCode) throws DAOException {
		List admins = query(findByCode,new Object[]{adminCode});
		if(!admins.isEmpty()){
			return (Admin) admins.get(0);
		}
		return null;
	}

	public List<Admin> findAdmimListByConditions(String privilegeId, String roleName,int page , int rows)
			throws DAOException {
		int start = (page-1)*rows + 1;
		int end = start + rows;
		//RoleDAO roleDAO = DAOFactory.getRoleDAO();
//select RN , ID , ADMIN_CODE , PASSWORD , NAME , TELEPHONE , EMAIL , ENROLLDATE from (select distinct ROWNUM RN , ID , ADMIN_CODE , PASSWORD , NAME , TELEPHONE , EMAIL , ENROLLDATE from admin_info,admin_role,role_privilege where admin_info.id = admin_role.admin_id and admin_role.role_id = role_privilege.role_id and role_privilege.privilege_id=2 and admin_role.role_id=1 and rownum <5)where rn >1;
		StringBuilder sql = new StringBuilder("select RN , ID , ADMIN_CODE , PASSWORD , NAME , TELEPHONE , EMAIL , ENROLLDATE from (select distinct ROWNUM RN , a.ID , ADMIN_CODE , PASSWORD , a.NAME , TELEPHONE , EMAIL , ENROLLDATE from admin_info a,admin_role ar,role_privilege rp,role r where a.id = ar.admin_id and ar.role_id = rp.role_id and ar.role_id = r.id");
		if(privilegeId!=null&&privilegeId!="-1"){
			sql.append(" and rp.privilege_id = "+privilegeId+" ");
		
		}
		if(roleName!=null&&roleName!=""){
			//int id = roleDAO.findByName(roleName).getId();
			sql.append(" and  r.name ='"+roleName+"' ");
		}
		sql.append(" and rownum <?)where rn >=?");
		System.out.println(sql);
		List<Admin> admins = query(sql.toString(),new Object[]{end,start});
		return admins;
	}

	public int getTotalPage(String privilegeId, String roleName, int rows)
			throws DAOException {
		//RoleDAO roleDAO = DAOFactory.getRoleDAO();
		StringBuilder sql = new StringBuilder(" select  distinct ID , ADMIN_CODE , PASSWORD , NAME , TELEPHONE , EMAIL , ENROLLDATE from (select distinct ADMIN_CODE , ROWNUM RN , a.ID , PASSWORD , a.NAME , TELEPHONE , EMAIL , ENROLLDATE from admin_info a ,admin_role ar ,role_privilege  rp, role r where a.ID = ar.ADMIN_ID and ar.ROLE_ID = R.ID and ar.ROLE_ID = rp.ROLE_ID  ");
		if(privilegeId!=null&&privilegeId!="-1"){																																														//a.ID = ar.ADMIN_ID and ar.ROLE_ID = R.ID and ar.ROLE_ID = rp.ROLE_ID where r.name='大混子'
			sql.append(" and rp.privilege_id = "+privilegeId+" ");
		
		}
		if(roleName!=null&&roleName!=""){
			//int id = roleDAO.findByName(roleName).getId();
			sql.append(" and  r.name='"+roleName+"' ");
		}
		sql.append(" )");
		List admins = query(sql.toString(),null);
		int allRows = admins.size();
		if(allRows%rows==0){
			return allRows/rows;
		}else{
			return allRows/rows +1;
		}
	}

	

}
