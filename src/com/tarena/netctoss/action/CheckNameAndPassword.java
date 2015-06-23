package com.tarena.netctoss.action;

import com.tarena.netctoss.dao.AdminDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.entity.Admin;

public class CheckNameAndPassword {
	private Admin admin;
	private String msg_login;
	private AdminDAO adminDAO = DAOFactory.getAdminDAO();
	public String execute(){
		try {
			
			System.out.println(admin.getPassword());
			if(adminDAO.findAdminByCodeAndPwd(admin.getAdminCode(), admin.getPassword())!=null){
				return "success";
			}else{
				msg_login = "账号密码错误";
				return "fail";
			}
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
	}
	public String getMsg_login() {
		return msg_login;
	}
	public void setMsg_login(String msgLogin) {
		msg_login = msgLogin;
	}
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
