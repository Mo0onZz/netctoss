package com.tarena.netctoss.dao;

import com.tarena.netctoss.entity.Host;

public interface HostDAO {
	public Host findHostById(String ip)throws DAOException;
}
