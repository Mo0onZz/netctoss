package com.tarena.netctoss.action;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Cost;

public class CheckCostNameAction {
	private boolean ok = false;
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	private Cost cost = new Cost();
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}

	
	private CostDAO costDAO = DAOFactory.getCostDAO();
	public String execute(){
		try {
			Cost cost1 = costDAO.findCostByName(cost.getName());
			if(cost1==null){
				ok = true;
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}

}
