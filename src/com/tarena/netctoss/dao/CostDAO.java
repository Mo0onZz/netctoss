package com.tarena.netctoss.dao;

import java.util.List;
import java.util.Map;

import com.tarena.netctoss.entity.Cost;

public interface CostDAO {
	public List<Cost> findCostByPage(int page,int rows)throws DAOException;
	public int findCostPages(int rows)throws DAOException;
	public Map<String,String> getCostStatus()throws DAOException;
	public Cost findCostById(int id)throws DAOException;
	public int saveCost(Cost cost)throws DAOException;
	public Cost findCostByName(String name)throws DAOException;
	public int deleteById(int id)throws DAOException;
	public int ModifyCost(Cost cost)throws DAOException;
	public List<Cost> findAll()throws DAOException;

}
