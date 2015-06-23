package com.tarena.netctoss.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Account;


public class AccountListForFindByConditionsAction {
	private int totalpages;
	private int page = 1;
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	private Map<String,String> mustConditions = accountDAO.getmustConditions();
	private Map<String,String> likeConditions = accountDAO.getlikeConditions();
	private List<Account> accounts = new ArrayList<Account>();
	private Map<String,String> accountStatus = accountDAO.getAccountStatus();
	


	public String execute(){
		System.out.println(likeConditions.toString());
		try {
			totalpages = accountDAO.getTotalPage(5);
			accounts = accountDAO.findAccountByCondition(mustConditions, likeConditions, page, 5);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
		
	
	
	}


	public List<Account> getAccounts() {
		return accounts;
	}


	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}


	public int getPage() {
		return page;
	}


	public void setPage(int page) {
		this.page = page;
	}


	public Map<String, String> getMustConditions() {
		return mustConditions;
	}


	public void setMustConditions(Map<String, String> mustConditions) {
		this.mustConditions = mustConditions;
	}


	
	public Map<String, String> getLikeConditions() {
		return likeConditions;
	}


	public void setLikeConditions(Map<String, String> likeConditions) {
		this.likeConditions = likeConditions;
	}


	public Map<String, String> getAccountStatus() {
		return accountStatus;
	}


	public void setAccountStatus(Map<String, String> accountStatus) {
		this.accountStatus = accountStatus;
	}
	public int getTotalpages() {
		return totalpages;
	}


	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}




}
