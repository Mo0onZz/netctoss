package com.tarena.netctoss.dao;

import java.util.List;
import java.util.Map;

import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.entity.Service;

public interface AccountDAO {
	public int getTotalPage(int rows)throws DAOException;
	
	
	public List<Account> findByPage(int pages,int rows)throws DAOException;
	
	public Map<String,String> getAccountStatus();
	
	public Account findAccountById(int id)throws DAOException;
	
	public Map<String,String> getSex()throws DAOException;
	
	public Map<String,String> getZhiye()throws DAOException;
	
	public int deleteAccountById(String status,java.sql.Date date,int id)throws DAOException;
	
	public Account findAccountByLoginName(String name)throws DAOException;
	
	public int saveAccount(Account account)throws DAOException;
	
	public Account findAccountByIdcardNo(String idcard)throws DAOException;
	
	public int modifyAccount(Account account)throws DAOException;
	
	public List<Account> findAccountByCondition(Map<String,String> mustConditions,Map<String,String> likeConditions,int page,int rows)throws DAOException;
	
	public Map<String,String> getmustConditions();
	
	public Map<String,String> getlikeConditions();
	
	public int setStatus(int status , int id )throws DAOException;
	
	public int StopAccount(String status,int id)throws DAOException;
	
	public int startAccount(String status , int id)throws DAOException;
}
