package com.tarena.netctoss.entity;

import java.util.Date;

public class ServiceLine extends Entity{
//	业务ID 	
	private Integer id;
//	账务账号ID 
	private Integer accountId;
//	身份证 	
	private String idcardNo;
//	姓名 	
	private String realName;
//	OS 账号 	
	private String osUsername;
//	状态 	
	private String status;
//	服务器 IP 	
	private String unixHost;
	
	private String costName;
	private Date createDate;
	private Date pauseDate;
	private Date closeDate;
	
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
	private String descr;
	private int costId;
	public Integer getId() {
		return id;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public int getCostId() {
		return costId;
	}
	public void setCostId(int costId) {
		this.costId = costId;
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
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getOsUsername() {
		return osUsername;
	}
	public void setOsUsername(String osUsername) {
		this.osUsername = osUsername;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUnixHost() {
		return unixHost;
	}
	public void setUnixHost(String unixHost) {
		this.unixHost = unixHost;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	//	资费

}
