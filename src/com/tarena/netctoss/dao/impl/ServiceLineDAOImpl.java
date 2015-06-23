package com.tarena.netctoss.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.ServiceLineDAO;
import com.tarena.netctoss.entity.Entity;
import com.tarena.netctoss.entity.ServiceLine;

public class ServiceLineDAOImpl extends BaseDAO implements ServiceLineDAO{
	private static final String findServiceLineById="select ID , ACCOUNT_ID , IDCARD_NO , REAL_NAME , OS_USERNAME , STATUS , UNIX_HOST , NAME , CREATE_DATE , PAUSE_DATE , CLOSE_DATE ,DESCR ,COST_ID from (select ROWNUM RN , s.ID , ACCOUNT_ID , IDCARD_NO , REAL_NAME , OS_USERNAME , s.STATUS , UNIX_HOST , c.NAME , s.CREATE_DATE , s.PAUSE_DATE , s.CLOSE_DATE ,DESCR ,c.id COST_ID from account a,service s , cost c where a.id =s.account_id and c.id = s.cost_id )where id = ? ";
	public List<ServiceLine> findServiceLineByConditions(Map<String , String> mustConditions , Map<String , String> likeConditions,int page,int rows ) throws DAOException {
		StringBuilder sql = new StringBuilder("");
		String conditions = createConditions(mustConditions , likeConditions,rows );
		sql.append("select ID , ACCOUNT_ID , IDCARD_NO , REAL_NAME , OS_USERNAME , STATUS , UNIX_HOST , NAME , CREATE_DATE , PAUSE_DATE , CLOSE_DATE ,DESCR ,COST_ID from (select ROWNUM RN , s.ID , ACCOUNT_ID , IDCARD_NO , REAL_NAME , OS_USERNAME , s.STATUS , UNIX_HOST , c.NAME , s.CREATE_DATE , s.PAUSE_DATE , s.CLOSE_DATE ,DESCR ,c.id COST_ID from account a,service s , cost c where a.id =s.account_id and c.id = s.cost_id and ");
		sql.append(conditions);
		sql.append("and ROWNUM < ?) where RN >= ?" );
		int start = (page-1)*rows + 1;
		int end = start + rows;
		System.out.println("sql:"+sql.toString());
		List<ServiceLine> serviceLines = query(sql.toString(),new Object[]{end,start});		
		System.out.println(serviceLines.size()+"查询结合长度");
		
		
		return serviceLines;
	}
	
	
//	业务ID 	
//	private Integer id;
////	账务账号ID 
//	private Integer accountId;
////	身份证 	
//	private String idcardNo;
////	姓名 	
//	private String realName;
////	OS 账号 	
//	private String osUsername;
////	状态 	
//	private String status;
////	服务器 IP 	
//	private String unixHost;

	@Override
	public Entity toEntity(ResultSet rs) throws SQLException {
		ServiceLine serviceLine = new ServiceLine();
		// CREATE_DATE , PAUSE_DATE , CLOSE_DATE ,DESCR COST_ID 
		serviceLine.setId(rs.getInt("ID"));
		serviceLine.setIdcardNo(rs.getString("IDCARD_NO"));
		serviceLine.setAccountId(rs.getInt("ACCOUNT_ID"));
		serviceLine.setRealName(rs.getString("REAL_NAME"));
		serviceLine.setOsUsername(rs.getString("OS_USERNAME"));
		serviceLine.setStatus(rs.getString("STATUS"));
		serviceLine.setUnixHost(rs.getString("UNIX_HOST"));
		serviceLine.setCostName(rs.getString("Name"));
		serviceLine.setCreateDate(rs.getDate("CREATE_DATE"));
		serviceLine.setCostId(rs.getInt("COST_ID"));
		serviceLine.setDescr(rs.getString("DESCR"));
		serviceLine.setPauseDate(rs.getDate("PAUSE_DATE"));
		serviceLine.setCloseDate(rs.getDate("CLOSE_DATE"));
		
		return serviceLine;
	}
public Map<String, String> getMustConditions() {
	 Map<String ,String> mustConditions = new LinkedHashMap<String,String>();
	
		mustConditions.put("OS_USERNAME", "");
		mustConditions.put("UNIX_HOST", "");
		mustConditions.put("ACCOUNT_ID", "");
		mustConditions.put("S_STATUS", "-1");
		return mustConditions;
	}

	public Map<String, String> getLikeConditions() {
		Map<String ,String> likeConditions = new LinkedHashMap<String,String>();
		likeConditions.put("OS_USERNAME", "");
		likeConditions.put("UNIX_HOST", "");
		likeConditions.put("ACCOUNT_ID", "");
		likeConditions.put("S_STATUS", "-1");
		return likeConditions;
	}

	public int getTotalPage(Map<String , String> mustConditions , Map<String , String> likeConditions,int rows) throws DAOException {
		StringBuilder sql = new StringBuilder("");
		String conditions = createConditions(mustConditions , likeConditions,rows );
		sql.append("select count(*) from service s , account a , cost c where a.id =s.account_id and c.id = s.cost_id and");
		sql.append(conditions);
		System.out.println("gettotalpage"+sql);
		return query2(sql.toString(),rows);
		
		
	}
	public Map<String,String> getServiceStatus(){
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("1", "开通");
		map.put("0", "暂停");	
		map.put("2", "删除");
		map.put("-1", "全部");
		return map;
	}


	public ServiceLine findServiceLineById(int id) throws DAOException {
		List serviceLines = query(findServiceLineById,new Object[]{id});
		return (ServiceLine) serviceLines.get(0);
	}
	
}
