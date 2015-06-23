package com.tarena.netctoss.action;

import java.util.Map;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Cost;

public class CostDetailAction {
	private int pages;
	
	private int id;
	private Cost cost;
	private CostDAO costDAO = DAOFactory.getCostDAO();
	private Map<String,String> costStatus ;
	public String execute(){
		try {
			costStatus =  costDAO.getCostStatus();
			System.out.println(id);
			cost = costDAO.findCostById(id);
			System.out.println(cost.getId());
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
		
	}
	
	
	
	
	
	
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	
	public Map<String, String> getCostStatus() {
		return costStatus;
	}
	public void setCostStatus(Map<String, String> costStatus) {
		this.costStatus = costStatus;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

}
