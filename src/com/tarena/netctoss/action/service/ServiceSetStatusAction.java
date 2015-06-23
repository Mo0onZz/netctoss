package com.tarena.netctoss.action.service;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.ServiceDAO;

public class ServiceSetStatusAction {
	private boolean ok = false;
	private ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
	private int id;
	public String stop(){
		try {
			if(serviceDAO.stopService("0", id)>0){
				ok = true;
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String start(){
		try{
			if(serviceDAO.startService("1", id)>0){
				ok = true;
			}
		}catch(DAOException e){
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
