package com.tarena.netctoss.action.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Cost;

public class ServiceAddFormAction {
	private Map<Integer,String> costSelect = new LinkedHashMap<Integer,String>();
	private CostDAO costDAO = DAOFactory.getCostDAO();
	
	public String execute(){
		try {
			List<Cost> costs = costDAO.findAll();
			for(Cost cost : costs){
				costSelect.put(cost.getId(), cost.getName());
			}
			System.out.println(costSelect);
		} catch (DAOException e) {
			e.printStackTrace();
		}
		
		return "success";
	}

	public Map<Integer, String> getCostSelect() {
		return costSelect;
	}

	public void setCostSelect(Map<Integer, String> costSelect) {
		this.costSelect = costSelect;
	}

}
