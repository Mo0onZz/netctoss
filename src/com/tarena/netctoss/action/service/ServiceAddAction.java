package com.tarena.netctoss.action.service;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.ServiceDAO;
import com.tarena.netctoss.entity.Service;

public class ServiceAddAction {
	private Service service;
	private ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
	public String execute(){
		try {
			System.out.println("进入action");
			if(serviceDAO.serviceAdd(service)>0){
				return  "success";
			}
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "error";
	}
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}

}
