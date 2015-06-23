package com.tarena.netctoss.action;

import java.util.Map;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;

public class AccountAddFormAction {
	public Map<String, String> getZhiye() {
		return zhiye;
	}
	public void setZhiye(Map<String, String> zhiye) {
		this.zhiye = zhiye;
	}
	public Map<String, String> getSex() {
		return sex;
	}
	public void setSex(Map<String, String> sex) {
		this.sex = sex;
	}
	private Map<String,String> zhiye ;
	private Map<String,String> sex;
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	public String execute(){
		try {
			zhiye = accountDAO.getZhiye();
			sex = accountDAO.getSex();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}

}
