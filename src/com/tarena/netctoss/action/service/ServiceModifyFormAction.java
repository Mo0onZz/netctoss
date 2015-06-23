package com.tarena.netctoss.action.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.ServiceDAO;
import com.tarena.netctoss.entity.Cost;
import com.tarena.netctoss.entity.Service;

public class ServiceModifyFormAction {
	private CostDAO costDAO = DAOFactory.getCostDAO();
	private Map<Integer,String> costSelect = new LinkedHashMap();
	
	private ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
	private Service service;
	private Integer id ;
	public String execute(){
		try {
			List<Cost> costs = costDAO.findAll();
			for(Cost cost : costs){
				costSelect.put(cost.getId(), cost.getName());
			}
			service = serviceDAO.findServiceById(id);
			System.out.println("unixHost:"+service.getUnixHost());
			if(service!=null){
				return "success";
			}
			
		} catch (DAOException e) {
			e.printStackTrace();
		} 
		return "error";
	}
	
	
	
	
	
	
	
	
	
	
	public Map<Integer, String> getCostSelect() {
		return costSelect;
	}
	public void setCostSelect(Map<Integer, String> costSelect) {
		this.costSelect = costSelect;
	}
	
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

}
