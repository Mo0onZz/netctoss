package com.tarena.netctoss.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.entity.Entity;
import com.tarena.netctoss.entity.Service;
import com.tarena.netctoss.util.DBUtil;

public class AccountDAOImpl extends BaseDAO implements AccountDAO{
	private static final String findByPage="select ID,RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD, STATUS, CREATE_DATE,PAUSE_DATE,CLOSE_DATE, REAL_NAME , IDCARD_NO , BIRTHDATE , GENDER , OCCUPATION , TELEPHONE ,EMAIL , MAILADDRESS , ZIPCODE , QQ , LAST_LOGIN_TIME ,LAST_LOGIN_IP from " +
			"(select ROWNUM RN , ID,RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD, STATUS, CREATE_DATE," +
			"PAUSE_DATE,CLOSE_DATE, REAL_NAME , IDCARD_NO , BIRTHDATE , GENDER , OCCUPATION , TELEPHONE , " +
			"EMAIL , MAILADDRESS , ZIPCODE , QQ , LAST_LOGIN_TIME ,LAST_LOGIN_IP from " +
			"account where rownum<?)where rn >=?";
	private static final String getTotalPage="select count(*) from ACCOUNT";
	private static final String findAccountById="select ID,RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD, STATUS, CREATE_DATE,PAUSE_DATE,CLOSE_DATE, REAL_NAME , IDCARD_NO , BIRTHDATE , GENDER , OCCUPATION , TELEPHONE ,EMAIL , MAILADDRESS , ZIPCODE , QQ , " +
			"										LAST_LOGIN_TIME ,LAST_LOGIN_IP from account where id = ?";
	private static final String deleteAccountById="update Account set STATUS=?,CLOSE_DATE=? where ID=?";
	private static final String deleteServiceByAccountId = "update Service set STATUS=? ,CLOSE_DATE=? where ACCOUNT_ID=?";
	private static final String findAccountByLoginName="select ID,RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD, STATUS, CREATE_DATE,PAUSE_DATE,CLOSE_DATE, REAL_NAME , IDCARD_NO , BIRTHDATE , GENDER , OCCUPATION , TELEPHONE ,EMAIL , MAILADDRESS , ZIPCODE , QQ , LAST_LOGIN_TIME ,LAST_LOGIN_IP from account where LOGIN_NAME=?";
	private static final String saveAccount="insert into ACCOUNT( ID,RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD, STATUS, CREATE_DATE , PAUSE_DATE,CLOSE_DATE,REAL_NAME,IDCARD_NO , BIRTHDATE,GENDER,OCCUPATION,TELEPHONE , EMAIL,MAILADDRESS,ZIPCODE,QQ , LAST_LOGIN_TIME ,LAST_LOGIN_IP ) values ("+"s_account.nextval,?,?,?,?,? ,?,?,?,? , ?,?,?,? , ?,?,?,?,?,?)";
	private static final String findAccountByIdcardNo="select ID,RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD, STATUS, CREATE_DATE,PAUSE_DATE,CLOSE_DATE, REAL_NAME , IDCARD_NO , BIRTHDATE , GENDER , OCCUPATION , TELEPHONE ,EMAIL , MAILADDRESS , ZIPCODE , QQ , LAST_LOGIN_TIME ,LAST_LOGIN_IP from account where IDCARD_NO=?";																																	
	private static final String modifyAccount ="update account set REAL_NAME=?,LOGIN_PASSWD=?,TELEPHONE=?,BIRTHDATE=?,EMAIL=?,OCCUPATION =?,GENDER=?,MAILADDRESS=?,ZIPCODE =?,QQ=? where ID=?";
	private static  Map<String,String> mustConditions;
	private static  Map<String,String> likeConditions;
	private static final String setStatus = "update ACCOUNT set STATUS=? where ID=?";
	private static final String stopAccountById="update ACCOUNT set STATUS=?,PAUSE_DATE=? where ID = ?";
	private static final String stopServiceByAccountId = "update SERVICE set STATUS=?,PAUSE_DATE=? where ACCOUNT_ID = ?";
	private static final String startAccountById = "update Account set STATUS=? , PAUSE_DATE=null where ID = ?";
	public Map<String,String> getmustConditions(){
		Map<String,String> mustConditions = new LinkedHashMap();
		mustConditions.put("IDCARD_NO","");
		mustConditions.put("REAL_NAME", "");
		mustConditions.put("LOGIN_NAME", "");
		mustConditions.put("STATUS", "-1");
		return mustConditions;
	}
	public Map<String,String> getlikeConditions(){
		Map<String,String> likeConditions = new LinkedHashMap();
		likeConditions.put("IDCARD_NO","");
		likeConditions.put("REAL_NAME", "");
		likeConditions.put("LOGIN_NAME", "");
		likeConditions.put("STATUS", "-1");
		return likeConditions;
	}

	public List<Account> findByPage(int pages, int rows) throws DAOException {
		int start = (pages-1)*rows +1;
		int end = start + rows;
		List accounts= query(findByPage,new Object[]{end,start});
		return accounts;
	}

	public int getTotalPage(int rows) throws DAOException {
		Connection conn = null;
		int data = 0;
		try{
			conn = DBUtil.getConnection();
			PreparedStatement ps = conn.prepareCall(getTotalPage);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				data = rs.getInt(1);
			}
			if(data%rows==0){
				return data/rows;
				
			}else{
				return data/rows + 1;
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("鏁版嵁璁块棶寮傚父",e);
			
			
		}finally{
			DBUtil.closeConnection(conn);
		}
		

	}

	@Override
	public Entity toEntity(ResultSet rs) throws SQLException {
		Account account = new Account();
//		ID              NOT NULL NUMBER(9)    
		account.setId(rs.getInt("ID"));
//		RECOMMENDER_ID           NUMBER(9)
		account.setRecommenderId(rs.getInt("RECOMMENDER_ID"));
//		LOGIN_NAME      NOT NULL VARCHAR2(30) 
		account.setLoginName(rs.getString("LOGIN_NAME"));
//		LOGIN_PASSWD    NOT NULL VARCHAR2(30) 
		account.setLoginPassWD(rs.getString("LOGIN_PASSWD"));
//		STATUS                   CHAR(1)
		account.setStatus(rs.getString("STATUS"));
//		CREATE_DATE              DATE   
		account.setCreateDate(rs.getDate("CREATE_DATE"));
//		PAUSE_DATE               DATE   
		account.setPauseDate(rs.getDate("PAUSE_DATE"));
//		CLOSE_DATE               DATE      
		account.setCloseDate(rs.getDate("CLOSE_DATE"));
//		REAL_NAME       NOT NULL VARCHAR2(20) 
		account.setRealName(rs.getString("REAL_NAME"));
//		IDCARD_NO       NOT NULL CHAR(18)     
		account.setIdcardNo(rs.getString("IDCARD_NO"));
//		BIRTHDATE                DATE 
		account.setBirthDate(rs.getDate("BIRTHDATE"));
//		GENDER                   CHAR(1)    
		account.setGender(rs.getString("GENDER"));
//		OCCUPATION               VARCHAR2(50) 
		account.setOccUpation(rs.getString("OCCUPATION"));
//		TELEPHONE       NOT NULL VARCHAR2(15) 
		account.setTelephone(rs.getString("TELEPHONE"));
//		EMAIL                    VARCHAR2(50) 
		account.setEmail(rs.getString("EMAIL"));
//		MAILADDRESS              VARCHAR2(50) 
		account.setMailAddress(rs.getString("MAILADDRESS"));
//		ZIPCODE                  CHAR(6)      
		account.setZipCode(rs.getString("ZIPCODE"));
//		QQ                       VARCHAR2(15) 
		account.setQq(rs.getString("QQ"));
//		LAST_LOGIN_TIME          DATE   
		account.setLastLoginTime(rs.getDate("LAST_LOGIN_TIME"));
//		LAST_LOGIN_IP            VARCHAR2(15) 
		account.setLastLoginIp(rs.getString("LAST_LOGIN_IP"));
		return account;
	}

	public Map<String, String> getAccountStatus() {
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("1", "开通");
		map.put("0", "暂停");	
		map.put("2", "删除");
		map.put("-1", "全部");
		return map;
	}

	public Account findAccountById(int id) throws DAOException {
		List accounts = new ArrayList<Account>();
		accounts = query(findAccountById,new Object[]{id});
		if(accounts!=null&&accounts.size()>0){
			return (Account) accounts.get(0);
		}
		return null;
	}

	public Map<String, String> getSex() throws DAOException {
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("1", "男");
		map.put("0", "女");
		return map;
	}
	public Map<String,String> getZhiye(){
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("1", "学生");
		map.put("2", "干部");
		map.put("3", "你大爷");
		map.put("0", "无");
		return map;
	}

	
	public int deleteAccountById(String status,java.sql.Date date,int id) throws DAOException {
//		private static final String deleteAccountById="update Account set STATUS=?,CLOSE_DATE=? where ID=?";
//		private static final String deleteServiceByAccountId = "update Service set STATUS=? ,CLOSE_DATE=? where ACCOUNT_ID=?";
		int r = 0 ;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(deleteAccountById);
			ps.setString(1, status);
			ps.setDate(2, date);
			ps.setInt(3, id);
			ps.executeUpdate();
			PreparedStatement ps1 = conn.prepareStatement(deleteServiceByAccountId);
			ps1.setString(1, status);
			ps1.setDate(2, date);
			ps1.setInt(3, id);
			ps1.executeUpdate();
			conn.commit();
			r = 1;
		}catch(Exception e){
			r = 0;
			throw new DAOException("数据访问异常",e);
		}finally{
			DBUtil.closeConnection(conn);
		}
		return r;
		
	}

	public Account findAccountByLoginName(String name) throws DAOException {
		List accounts = query(findAccountByLoginName,new Object[]{name});
		if(accounts!=null&&accounts.size()>0){
			return (Account) accounts.get(0);
		}
		return null;
	}

	public int saveAccount(Account account) throws DAOException {
//		ID,RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD, STATUS, 
//		CREATE_DATE , PAUSE_DATE,CLOSE_DATE,REAL_NAME,
//		IDCARD_NO , BIRTHDATE,GENDER,OCCUPATION,
//		TELEPHONE , EMAIL,MAILADDRESS,ZIPCODE,\
//		QQ , LAST_LOGIN_TIME ,LAST_LOGIN_IP
//		s_account.nextval,?,?,?,? ,?,?,?,? , ?,?,?,? , ?,?,?,?,?,?
		
		System.out.println("推荐人没插进去"+account.getRecommenderId());
		return update(saveAccount,new Object[]{
				account.getRecommenderId(),account.getLoginName(),account.getLoginPassWD(),1,
				new java.sql.Date(System.currentTimeMillis()),account.getPauseDate(),account.getCloseDate(),account.getRealName(),
				account.getIdcardNo(),account.getBirthDate(),account.getGender(),account.getOccUpation(),
				account.getTelephone(),account.getEmail(),account.getMailAddress(),account.getZipCode(),
				account.getQq(),account.getLastLoginTime(),account.getLastLoginIp()
			});
		
	}

	public Account findAccountByIdcardNo(String idcard) throws DAOException {
		List accounts = query(findAccountByIdcardNo,new Object[]{idcard});
		System.out.println(accounts.size());
		if(accounts!=null&&accounts.size()>0){
			return (Account) accounts.get(0);
		}
		return null;
	}

	public int modifyAccount(Account account) throws DAOException {
		Account account1 = createNewAccount(account);
		
		//update account set REAL_NAME=?,TELEPHONE=?,BIRTHDATE=?,EMAIL=?,OCCUPATION =?,GENDER=?,MAILADDRESS=?
		//,ZIPCODE =?,QQ=? where ID=?";
		return update(modifyAccount,new Object[]{
			account1.getRealName(),account1.getLoginPassWD(),account1.getTelephone(),account1.getBirthDate(),account1.getEmail(),account1.getOccUpation(),
			account1.getGender(),account1.getMailAddress(),account1.getZipCode(),account1.getQq(),account1.getId()
				
		});
	}
	public Account createNewAccount(Account account) throws DAOException{
		System.out.println("1"+account.getLoginPassWD());
		
		if(account.getLoginPassWD()==null||account.getLoginPassWD().equals("")){
			List<Account> accounts = query(findAccountById,new Object[]{account.getId()});
			account.setLoginPassWD(accounts.get(0).getLoginPassWD());
			System.out.println("2"+accounts.get(0).getLoginPassWD());
		}
		
		return account;
	}

	public List<Account> findAccountByCondition(
			Map<String, String> mustConditions,
			Map<String, String> listConditions ,int page,int rows) throws DAOException {
			
			int start = (page-1)*rows + 1;
			int end = start + rows;
			String Conditions = createConditions(mustConditions,listConditions,page);
			String sql = "select ID,RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD, STATUS, CREATE_DATE,PAUSE_DATE,CLOSE_DATE, REAL_NAME , IDCARD_NO , BIRTHDATE , GENDER , OCCUPATION , TELEPHONE ,EMAIL , MAILADDRESS , ZIPCODE , QQ , LAST_LOGIN_TIME ,LAST_LOGIN_IP from ( select rownum rn , ID,RECOMMENDER_ID, LOGIN_NAME, LOGIN_PASSWD, STATUS, CREATE_DATE,PAUSE_DATE,CLOSE_DATE, REAL_NAME , IDCARD_NO , BIRTHDATE , GENDER , OCCUPATION , TELEPHONE ,EMAIL , MAILADDRESS , ZIPCODE , QQ , LAST_LOGIN_TIME ,LAST_LOGIN_IP" +
					" from account WHERE "+Conditions+" and rownum < ? )  where rn>= ?";
			System.out.println(sql);
			List accounts = query(sql,new Object[]{end , start});
		return accounts;
	}
	public int setStatus(int status, int id) throws DAOException {
		return update(setStatus,new Object[]{status,id});
	}
	public int StopAccount(String status, int id) throws DAOException {
//		private static final String stopAccountById="update ACCOUNT set STATUS=?,PAUSE_DATE=? where ID ?";
//		private static final String stopServiceByAccountId = "update SERVICE set STATUS=?,PAUSE_DATE=? where ACCOUNT_ID = ?";
		int count = 0;
		Connection conn = null;
		try{
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(stopAccountById);
			ps.setString(1, "0");
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ps.setInt(3, id);
			ps.executeUpdate();
			PreparedStatement ps1 = conn.prepareStatement(stopServiceByAccountId);
			ps1.setString(1, "0");
			ps1.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ps1.setInt(3, id);
			ps1.executeUpdate();
			conn.commit();
			count = 1;
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
		return count ;
	}
	public int startAccount(String status, int id) throws DAOException {
//		private static final String startAccountById = "update Account set STATUS=? , PAUSE_DATE=null where ID = ?";
		return update(startAccountById,new Object[]{status,id})	;
		
		
		
	}
	
	
}





















