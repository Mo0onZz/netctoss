package com.tarena.netctoss.action.role;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.RoleDAO;

public class RoleDeleteAction {
	private int id;
	private int page;
	private boolean ok = false;
	private RoleDAO roleDAO = DAOFactory.getRoleDAO();
	public String execute(){
		System.out.println("进来了");
		try {
			System.out.println(id);
			roleDAO.DeleteById(id);
			ok = true;
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
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
}
