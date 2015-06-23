package com.tarena.netctoss.action.service;

import java.util.Map;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.ServiceLineDAO;
import com.tarena.netctoss.entity.ServiceLine;

public class ServiceLineDetail {
	private Integer id;
	private ServiceLine serviceLine;
	private ServiceLineDAO serviceLineDAO = DAOFactory.getSerivceLineDAO();
	private Map<String,String>serviceStatus = serviceLineDAO.getServiceStatus();
	public Map<String, String> getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(Map<String, String> serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public String execute(){
		try {
			serviceLine = serviceLineDAO.findServiceLineById(id);
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public ServiceLine getServiceLine() {
		return serviceLine;
	}
	public void setServiceLine(ServiceLine serviceLine) {
		this.serviceLine = serviceLine;
	}

}
