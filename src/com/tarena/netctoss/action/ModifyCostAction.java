package com.tarena.netctoss.action;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Cost;
	
public class ModifyCostAction {
	private Cost cost;
	public Cost getCost() {
		return cost;
	}
	public void setCost(Cost cost) {
		this.cost = cost;
	}
	private CostDAO costDAO = DAOFactory.getCostDAO();
	public String execute(){
		System.out.println(cost.getCreaTime()+"有创建时间");
		try {
			if(costDAO.ModifyCost(cost)>0){
				return "success";
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "error";
	}
}
