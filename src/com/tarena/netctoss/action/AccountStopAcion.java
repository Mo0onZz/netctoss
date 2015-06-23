package com.tarena.netctoss.action;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;

public class AccountStopAcion {
	private boolean ok = false;
	private Integer id;
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	public String execute(){
		try {
			if(accountDAO.setStatus(0, id)>0){
				ok = true;
			}
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	
	
	
	
	
	
	public boolean isOk() {
		return ok;
	}







	public void setOk(boolean ok) {
		this.ok = ok;
	}







	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
