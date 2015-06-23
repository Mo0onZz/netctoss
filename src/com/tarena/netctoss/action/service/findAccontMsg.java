package com.tarena.netctoss.action.service;

import com.tarena.netctoss.dao.AccountDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.DAOFactory;
import com.tarena.netctoss.dao.HostDAO;
import com.tarena.netctoss.dao.ServiceDAO;
import com.tarena.netctoss.entity.Account;
import com.tarena.netctoss.entity.Service;

public class findAccontMsg {
	private String osUsername;
	private String unixHost;
	private String idcardNo;
	private String ip;
	private String loginName;
	private int accountId;
	private boolean ok = false;
	private AccountDAO accountDAO = DAOFactory.getAccountDAO();
	private ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
	private HostDAO hostDAO = DAOFactory.getHostDAO();
	
	public String findLoginName(){
		try {
			
			Account account = accountDAO.findAccountByIdcardNo(idcardNo);
			if(account!=null){
				loginName = account.getLoginName();
				accountId = account.getId();
			}
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public String checkLoginName(){
		try {
			Account account = accountDAO.findAccountByLoginName(loginName);
			if(account!=null){
				accountId = account.getId();
				System.out.println(accountId+"accountId");
				ok =true;
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String checkUnixHost(){
		try {
			if(hostDAO.findHostById(ip)!=null){
				ok = true;
			}
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}
	public String checkOsAndIp(){
		try {
			Service service = serviceDAO.findServiceByOsAndIp(osUsername, unixHost);
			if(service==null){
				ok = true;
				
			}
		} catch (DAOException e) {
			e.printStackTrace();
			return "error";
		}
		return "success";
	}
	
	public String getOsUsername() {
		return osUsername;
	}
	public void setOsUsername(String osUsername) {
		this.osUsername = osUsername;
	}
	public String getUnixHost() {
		return unixHost;
	}
	public void setUnixHost(String unixHost) {
		this.unixHost = unixHost;
	}
	
	
	
	
	
	
	
	
	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
