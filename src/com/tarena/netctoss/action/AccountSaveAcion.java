package com.tarena.netctoss.action;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Account;

public class AccountSaveAcion {
	private String recommenderId;
	
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	public String execute(){
		try {
			Account act = accountDAO.findAccountByIdcardNo(recommenderId);
			if(act!=null){
				account.setRecommenderId(act.getId());
			}
			account.setBirthDate(new java.sql.Date(account.getBirthDate().getTime()));
			if(account.getOccUpation()==null){
				account.setOccUpation("0");
			}
			int count = accountDAO.saveAccount(account);
			if(count>0){
				return "success";
				
			}else{
				return "error";
				
			}
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getRecommenderId() {
		return recommenderId;
	}
	public void setRecommenderId(String recommenderId) {
		this.recommenderId = recommenderId;
	}
	private Account account;
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}
