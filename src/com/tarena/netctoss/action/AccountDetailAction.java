package com.tarena.netctoss.action;

import java.util.Map;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Account;

public class AccountDetailAction {
	private int id ;
	private Account account;
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	private int page;
	private Map sex;
	private Map zhiye;
	public Map getZhiye() {
		return zhiye;
	}











	public void setZhiye(Map zhiye) {
		this.zhiye = zhiye;
	}











	public Map getSex() {
		return sex;
	}











	public void setSex(Map sex) {
		this.sex = sex;
	}


	public Map getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(Map accountStatus) {
		this.accountStatus = accountStatus;
	}
	private Map<String,String> accountStatus;
	public String execute(){
		try {
			sex = accountDAO.getSex();
			System.out.println(sex);
			zhiye = accountDAO.getZhiye();
			accountStatus = accountDAO.getAccountStatus();
			account = accountDAO.findAccountById(id);
			return "success";
		} catch (DAOException e) {

			e.printStackTrace();
			return "error";
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
}
