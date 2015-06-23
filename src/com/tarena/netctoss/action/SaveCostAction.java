package com.tarena.netctoss.action;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Cost;

public class SaveCostAction {
	private Cost cost;
	private CostDAO costDAO = DAOFactory.getCostDAO();
	public String execute(){
		try {
			costDAO.saveCost(cost);
		} catch (DAOException e) {
			System.out.println("ÃÌº” ±“Ï≥£");
			e.printStackTrace();
			return "error";
			
		}
		return "success";
	}
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}

}
