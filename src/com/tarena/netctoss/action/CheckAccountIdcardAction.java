package com.tarena.netctoss.action;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Account;

public class CheckAccountIdcardAction {
	private Account account;
	private boolean ok = false;
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	public String execute(){
		System.out.println("idcard"+account.getIdcardNo());
		try {
			if(accountDAO.findAccountByIdcardNo(account.getIdcardNo())==null){
				ok = true;
			}
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
