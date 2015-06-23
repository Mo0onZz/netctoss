package com.tarena.netctoss.action;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Account;

public class AccountModifyAction {
	private Account account;
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	private String recommenderIdcardNo;
	public String execute(){
		try {
			System.out.println(recommenderIdcardNo);
			if(recommenderIdcardNo!="")
			account.setRecommenderId(accountDAO.findAccountByIdcardNo(recommenderIdcardNo).getId());
			int count = accountDAO.modifyAccount(account);
			if(count>0){
				return "success";
			}
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		
	
		
		return "error";
	}
	public String getRecommenderIdcardNo() {
		return recommenderIdcardNo;
	}
	public void setRecommenderIdcardNo(String recommenderIdcardNo) {
		this.recommenderIdcardNo = recommenderIdcardNo;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	

}
