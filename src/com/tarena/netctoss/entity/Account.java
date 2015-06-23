package com.tarena.netctoss.entity;

import java.util.Date;

public class Account extends Entity{
	
	//ID              NOT NULL NUMBER(9)
	private Integer id;
	//RECOMMENDER_ID           NUMBER(9)    
	private Integer recommenderId;
	//LOGIN_NAME      NOT NULL VARCHAR2(30) 
	private String loginName;
	//LOGIN_PASSWD    NOT NULL VARCHAR2(30) 
	private String loginPassWD;
	//STATUS                   CHAR(1)   
	private String status;
	//CREATE_DATE              DATE 
	private Date createDate;
	//PAUSE_DATE               DATE
	private Date pauseDate;
	//CLOSE_DATE               DATE 
	private Date closeDate;
	//REAL_NAME       NOT NULL VARCHAR2(20) 
	private String realName;
	//IDCARD_NO       NOT NULL CHAR(18)   
	private String idcardNo;
	//BIRTHDATE                DATE         
	private Date birthDate;
	//GENDER                   CHAR(1) 
	private String gender;
	//OCCUPATION               VARCHAR2(50) 
	private String occUpation;
	//TELEPHONE       NOT NULL VARCHAR2(15) 
	private String telephone;
	//EMAIL                    VARCHAR2(50) 
	private String email;
	//MAILADDRESS              VARCHAR2(50)
	private String mailAddress;
	//ZIPCODE                  CHAR(6)      
	private String zipCode;
	//QQ                       VARCHAR2(15) 
	private String qq;
	//LAST_LOGIN_TIME          DATE         
	private Date lastLoginTime;
	//LAST_LOGIN_IP            VARCHAR2(15)
	private String lastLoginIp;
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public Date getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassWD() {
		return loginPassWD;
	}
	public void setLoginPassWD(String loginPassWD) {
		this.loginPassWD = loginPassWD;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getOccUpation() {
		return occUpation;
	}
	public void setOccUpation(String occUpation) {
		this.occUpation = occUpation;
	}
	public Date getPauseDate() {
		return pauseDate;
	}
	public void setPauseDate(Date pauseDate) {
		this.pauseDate = pauseDate;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public Integer getRecommenderId() {
		return recommenderId;
	}
	public void setRecommenderId(Integer recommenderId) {
		this.recommenderId = recommenderId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
