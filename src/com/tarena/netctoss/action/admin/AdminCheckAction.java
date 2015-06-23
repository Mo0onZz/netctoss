package com.tarena.netctoss.action.admin;

import com.tarena.netctoss.dao.AdminDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Admin;

public class AdminCheckAction {
	private boolean ok = false;
	private Admin admin;
	private AdminDAO adminDAO = DAOFactory.getAdminDAO();
	public String checkCode(){
		try {
			System.out.println(admin.getAdminCode());
			Admin admin1 = adminDAO.findAdminByCode(admin.getAdminCode());
			if(admin1==null){
				ok = true;
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "success";
	}
	public boolean isOk() {
		return ok;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
}
