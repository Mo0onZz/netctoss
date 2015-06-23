package com.tarena.netctoss.action.service;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.ServiceDAO;
import com.tarena.netctoss.entity.Service;

public class ServiceModifyAction {
	private Service service;
	private ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
	public String execute(){
		System.out.println(service.getId()+","+service.getCostId());
		try {
			if(serviceDAO.serviceModify(service)>0){
				return "success";
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
