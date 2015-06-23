package com.tarena.netctoss.action.service;

import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.ServiceLineDAO;
import com.tarena.netctoss.entity.ServiceLine;

public class ServiceListAction {
	private ServiceLineDAO serviceLineDAO = DAOFactory.getSerivceLineDAO();
	private Map<String,String> mustConditions = serviceLineDAO.getMustConditions();
	private Map<String,String> likeConditions = serviceLineDAO.getLikeConditions();
	private int page = 1;
	private int totalpage ;
	private Map<String,String> serviceStatus = serviceLineDAO.getServiceStatus();
	private List<ServiceLine> services;
	public String execute(){
		System.out.println("likeConditions:"+likeConditions.size());
		System.out.println("mustConditions"+mustConditions.toString());
		try {
			totalpage = serviceLineDAO.getTotalPage(mustConditions, likeConditions, 5);
			services = serviceLineDAO.findServiceLineByConditions(mustConditions, likeConditions, page, 5);
			return "success";
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "error";
	}
	
	
	
	
	
	
	
	public Map<String, String> getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(Map<String, String> serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	
	
	
	
	
	
	
	public List<ServiceLine> getServices() {
		return services;
	}
	public void setServices(List<ServiceLine> services) {
		this.services = services;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Map<String, String> getMustConditions() {
		return mustConditions;
	}
	public void setMustConditions(Map<String, String> mustConditions) {
		this.mustConditions = mustConditions;
	}
	
	public Map<String, String> getLikeConditions() {
		return likeConditions;
	}



















	public void setLikeConditions(Map<String, String> likeConditions) {
		this.likeConditions = likeConditions;
	}



















	public int getTotalpage() {
		return totalpage;
	}



















	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}



















	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	

}
