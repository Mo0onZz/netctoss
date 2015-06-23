package com.tarena.netctoss.action.service;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.ServiceDAO;

public class ServiceDeleteAction {
	private boolean ok = false;
	private Integer id;
	private ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
	public String execute(){
		try {
			if(serviceDAO.ServiceDelete(id)>0){
				ok = true;
				return "success";
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "error";
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
