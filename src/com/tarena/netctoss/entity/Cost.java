package com.tarena.netctoss.entity;

import java.sql.Date;

public class Cost extends Entity{
	private Integer id; // 资费 ID

	private String name; // 资费名称 NAME

	private Integer baseDuration; // 包在线时长 BASE_DURATION

	private Float baseCost; // 月固定费 BASE_COST

	private Float unitCost; // 单位费用 UNIT_COST

	private String status; // 0：开通；1：暂停；STATUS

	private String descr; // 资费信息说明 DESCR

	
	private Date startTime; // 启用日期 STARTTIME
	private Date creaTime;
	

	public Date getCreaTime() {
		return creaTime;
	}

	public void setCreaTime(Date creaTime) {
		this.creaTime = creaTime;
	}


	public Float getBaseCost() {
		return baseCost;
	}

	public void setBaseCost(Float baseCost) {
		this.baseCost = baseCost;
	}

	public Integer getBaseDuration() {
		return baseDuration;
	}

	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(Float unitCost) {
		this.unitCost = unitCost;
	}


}
