package com.tarena.netctoss.entity;

import java.util.Date;

public class Service extends Entity{
//	ID           NOT NULL NUMBER(10)   
	private Integer id;
//	ACCOUNT_ID   NOT NULL NUMBER(9)  
	private Integer accountId;
//	UNIX_HOST    NOT NULL VARCHAR2(15) 
	private String unixHost;
//	OS_USERNAME  NOT NULL VARCHAR2(8)
	private String osUsername;
//	LOGIN_PASSWD NOT NULL VARCHAR2(8)
	private String loginPassWD;
//	STATUS                CHAR(1)
	private String status;
//	CREATE_DATE           DATE
	private Date createDate;
//	PAUSE_DATE            DATE
	private Date pauseDate;
//	CLOSE_DATE            DATE
	private Date closeDate;
//	COST_ID      NOT NULL NUMBER(4)
	private Integer costId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getUnixHost() {
		return unixHost;
	}
	public void setUnixHost(String unixHost) {
		this.unixHost = unixHost;
	}
	
	public String getOsUsername() {
		return osUsername;
	}
	public void setOsUsername(String osUsername) {
		this.osUsername = osUsername;
	}
	public String getLoginPassWD() {
		return loginPassWD;
	}
	public void setLoginPassWD(String loginPassWD) {
		this.loginPassWD = loginPassWD;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getPauseDate() {
		return pauseDate;
	}
	public void setPauseDate(Date pauseDate) {
		this.pauseDate = pauseDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}

}
