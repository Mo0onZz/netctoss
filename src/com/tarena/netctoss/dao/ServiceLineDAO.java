package com.tarena.netctoss.dao;

import java.util.List;
import java.util.Map;

import com.tarena.netctoss.entity.ServiceLine;

public interface ServiceLineDAO {
	public ServiceLine findServiceLineById(int id)throws DAOException;
	public List<ServiceLine> findServiceLineByConditions(Map<String , String> mustConditions , Map<String , String> likeConditions,int page,int rows )throws DAOException;
	public Map<String,String> getMustConditions();
	public Map<String,String> getLikeConditions();
	public int getTotalPage(Map<String , String> mustConditions , Map<String , String> likeConditions,int rows )throws DAOException;
	public Map<String,String> getServiceStatus();
}
