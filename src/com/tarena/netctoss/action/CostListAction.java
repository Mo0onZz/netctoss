package com.tarena.netctoss.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Cost;

public class CostListAction {
	private int totalpage;
	private int pages = 1;
	private Map<String,String> costStatus;
	private List<Cost> costs = new ArrayList<Cost>();
	private CostDAO costDAO = DAOFactory.getCostDAO();
	public String execute(){
		try {
			costStatus = costDAO.getCostStatus();
			totalpage = costDAO.findCostPages(5);
			costs = costDAO.findCostByPage(pages, 5);
			System.out.println(costs.get(0).getCreaTime());
		} catch (DAOException e) {
			
			e.printStackTrace();
		}
		
		return "success";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Map<String, String> getCostStatus() {
		return costStatus;
	}















	public void setCostStatus(Map<String, String> costStatus) {
		this.costStatus = costStatus;
	}















	public CostDAO getCostDAO() {
		return costDAO;
	}















	public void setCostDAO(CostDAO costDAO) {
		this.costDAO = costDAO;
	}















	public List<Cost> getCosts() {
		return costs;
	}















	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}















	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}

}
