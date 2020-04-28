package com.xworkz.xworkzcm.dao;

import com.xworkz.xworkzcm.entity.XworkzCMEntity;
import com.xworkz.xworkzcm.exceptions.DAOException;

public interface XworkzLoginDAO {

	public XworkzCMEntity fecthByEmailId(String email)throws DAOException;
	
	public Integer countAndUpdateLoginAttempt (String email , int noOfAttempt)throws DAOException;

	public Integer feachLoginAttempt (String email)throws DAOException;
	
	public String upadtePassByEmail (String password,String encricptedPass ,String email)throws DAOException;
}
