package com.tarena.netctoss.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.tarena.netctoss.dao.DAOException;
import com.tarena.netctoss.dao.HostDAO;
import com.tarena.netctoss.entity.Entity;
import com.tarena.netctoss.entity.Host;

public class HostDAOImpl extends BaseDAO implements HostDAO{
	private static final String findHostById="select ID , NAME , LOCATION from HOST where ID=?";

	@Override
	public Entity toEntity(ResultSet rs) throws SQLException {
		Host host = new Host();
		host.setId(rs.getString("ID"));
		host.setName(rs.getString("NAME"));
		host.setLocation(rs.getString("LOCATION"));
		return host;
	}

	public Host findHostById(String ip) throws DAOException {
		List hosts = query(findHostById,new Object[]{ip});
		if(hosts.size()>0){
			return (Host) hosts.get(0);
			
		}
		return null;
	}

}
