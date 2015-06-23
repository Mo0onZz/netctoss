package com.tarena.netctoss.action;

import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Account;

public class AccountListAction {
	private int page = 1;
	private int totalpages;
	private List<Account> accounts;
	private Map accountStatus;
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	public String execute(){
		try {
			totalpages = accountDAO.getTotalPage(5);
			accountStatus = accountDAO.getAccountStatus();
			accounts = accountDAO.findByPage(page, 5);
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










	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}










	public Map getAccountStatus() {
		return accountStatus;
	}










	public void setAccountStatus(Map accountStatus) {
		this.accountStatus = accountStatus;
	}
}
