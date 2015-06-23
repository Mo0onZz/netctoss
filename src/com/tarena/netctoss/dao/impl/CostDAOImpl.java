package com.tarena.netctoss.dao.impl;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.tarena.netctoss.dao.CostDAO;
import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.entity.Cost;

public class CostDAOImpl extends BaseDAO implements CostDAO{
	private static String findCostByCodeAndPwd = "select ID, NAME, BASE_DURATION, BASE_COST, BASE_COST, CREATIME, STARTIME, STATUS, DESCR from COST";
	private static String findCostByPage="select id,name,base_duration,base_cost,unit_cost,status,descr,creatime,startime from " +
			"(select rownum rn,id,name,base_duration,base_cost,unit_cost,status,descr,creatime,startime from cost where rownum<?)where rn>=?";
	private static String findCostPage = "select count(*) from cost";	
	private static String findCostById = "select ID, NAME, BASE_DURATION, BASE_COST, UNIT_COST, CREATIME, STARTIME, STATUS, DESCR from COST where ID=?";
	private static String saveCost = "insert into cost(ID,NAME,BASE_DURATION,BASE_COST,UNIT_COST,STATUS,descr,CREATIME,STARTIME) " + "values(cost_sequence.nextval,?,?,?,?,0,?,?,null)";
	private static String findCostByName= "select ID, NAME, BASE_DURATION, BASE_COST, UNIT_COST, CREATIME, STARTIME, STATUS, DESCR from COST where name=?";
	private static String deleteById="delete from cost where id = ?";
	private static String modifyCost="update COST set NAME=?,BASE_DURATION=?,BASE_COST=?,UNIT_COST=?,DESCR=? where id=?";
	private static String findAll="select ID, NAME, BASE_DURATION, BASE_COST, UNIT_COST, CREATIME, STARTIME, STATUS, DESCR from COST";
	public Cost toEntity(ResultSet rs) throws SQLException{
		Cost cost = new Cost();
		cost.setId(rs.getInt("ID"));
		cost.setName(rs.getString("NAME"));
		cost.setBaseDuration(rs.getInt("BASE_DURATION"));
		cost.setBaseCost(rs.getFloat("BASE_COST"));
		cost.setUnitCost(rs.getFloat("UNIT_COST"));
		cost.setStartTime(rs.getDate("STARTIME"));
		cost.setCreaTime(rs.getDate("CREATIME"));
		cost.setStatus(rs.getString("STATUS"));
		cost.setDescr(rs.getString("DESCR"));
		return cost;
	}
	public List<Cost> findCostByPage(int page,int rows) throws DAOException {
		int start = (page-1)*rows+1;
		int end = start +rows;
		List<Cost> costs = query(findCostByPage,new Object[]{end,start});
		
		return costs;
	}
	public int findCostPages(int rows) throws DAOException {
		return query2(findCostPage,rows);
		
	}
	public Map<String, String> getCostStatus() throws DAOException {
		Map<String,String> costStatus = new LinkedHashMap<String,String>();
		costStatus.put("1", "开通");
		costStatus.put("0", "暂停");
		return costStatus;
	}
	public Cost findCostById(int id) throws DAOException {
		System.out.println(id+"id");
		List<Cost> costs = query(findCostById,new Object[]{id});
		Cost cost=null;
		if(costs!=null&&costs.size()>0){
			cost = costs.get(0);
		}
		return cost;
	}
	public int saveCost(Cost cost) throws DAOException {
		
		return update(saveCost,new Object[]{
				cost.getName(),
				cost.getBaseDuration(),
				cost.getBaseCost(),
				cost.getUnitCost(),
				cost.getDescr(),
				new java.sql.Date(System.currentTimeMillis())
				
		});
		
		
	}
	public Cost findCostByName(String name) throws DAOException {
		List<Cost> costs = query(findCostByName,new Object[]{name});
		if(costs!=null&&costs.size()>0){
			return costs.get(0);
		}
		return null;
	}
	public int deleteById(int id) throws DAOException {
		int count = 0 ;
		
		count = update(deleteById,new Object[]{id});
		return count;
	}
	public int ModifyCost(Cost cost) throws DAOException {
	//	"update COST set NAME=?,BASE_DURATION=?,BASE_COST=?,UNIT_COST=?,DESCR=? where id=?";
		return update(modifyCost,new Object[]{
				cost.getName(),
				cost.getBaseDuration(),
				cost.getBaseCost(),
				cost.getUnitCost(),
				cost.getDescr(),
				cost.getId()
		});
		
	}
	public List<Cost> findAll() throws DAOException {
		
		return query(findAll,null);
	}


	
	
	
}
