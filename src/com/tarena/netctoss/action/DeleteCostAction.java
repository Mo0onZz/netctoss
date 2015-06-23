package com.tarena.netctoss.action;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;

public class DeleteCostAction {
	private boolean cc = false;
	private int id ;
	private CostDAO costDAO = DAOFactory.getCostDAO();
	public String execute(){
		try {
			if(costDAO.deleteById(id)>0){
				cc = true;
			}
		} catch (DAOException e) {
			e.printStackTrace();
			
			
		}
		return "success";
		
	}
	public boolean isCc() {
		return cc;
	}
	public void setCc(boolean cc) {
		this.cc = cc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
