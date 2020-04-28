package com.xworkz.xworkzcm.dao;

import com.xworkz.xworkzcm.entity.XworkzCMEntity;
import com.xworkz.xworkzcm.exceptions.DAOException;

public interface XworkzRegisterDAO {

	public void saveUser(XworkzCMEntity dto) throws DAOException;
	
	public boolean fetchUserId(String user)throws DAOException;
	
	public boolean fetchEmail(String email)throws DAOException;
	
	

	
}
