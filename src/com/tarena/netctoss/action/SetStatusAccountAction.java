package com.tarena.netctoss.action;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;

public class SetStatusAccountAction {
	private int id = 0;
	private boolean ok = false;
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	public String delete(){
		try {
			int count = accountDAO.deleteAccountById("2",new java.sql.Date(System.currentTimeMillis()),id);
			if(count>0){
				ok = true;
			}
			System.out.println(ok);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
			return "success";
		}
		
		
	}
	public String stop(){
		try {
			int count = accountDAO.StopAccount("0", id);
			if(count>0){
				ok = true;
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String start(){
		try {
			int count = accountDAO.startAccount("1", id);
			if(count>0){
				ok = true;
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	
	
	
	
	
	
	
	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
