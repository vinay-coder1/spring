<<<<<<< HEAD
package com.xworkz.xworkzcm.dao;

import java.util.Objects;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.xworkzcm.entity.XworkzCMEntity;
import com.xworkz.xworkzcm.exceptions.DAOException;
import lombok.Setter;

@Setter
@Repository
public class XworkzLoginDAOImpl implements XworkzLoginDAO {

	private static final Logger logger = LogManager.getLogger(XworkzLoginDAOImpl.class);
	
	@Autowired
	private SessionFactory factory;

	public XworkzLoginDAOImpl() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@Override
	public XworkzCMEntity fecthByEmailId(String email) throws DAOException {
		Session session = factory.openSession();

		try {
			Query query = session.getNamedQuery("byemail");
			query.setParameter("mail", email);

			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				logger.info("entity found for =" + email);

				XworkzCMEntity entity = (XworkzCMEntity) result;
				logger.info("nofattempt at dao=" + entity.getNoOfAttempt());
				return entity;
			}

			else {
				logger.info("entity not found for =" + email);
				logger.info("emailID is wrong!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			DAOException daoException = new DAOException();
			logger.error(daoException.getMessage(), daoException);
			throw daoException;
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				logger.info("session closed");
			}

		}
	}

	@Override
	public Integer countAndUpdateLoginAttempt(String email, int noOfAttempt) throws DAOException {
		logger.info("invoked updateLoginAttempt()");
		Session session = factory.openSession();
		Integer count = 0;
		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("incAttemptByEmail");
			query.setParameter("mail", email);
			query.setParameter("noa", noOfAttempt);

			Object result = query.executeUpdate();
			session.getTransaction().commit();
			logger.info("Transaction commited.");
			logger.info("EMAIL=" + email + " ,AND UPDATED NOFATTEMPTS=" + noOfAttempt);

			if (Objects.nonNull(count)) {
				logger.info("entity available=" + email);

				count = (Integer) result;
				logger.info("Upadte noOfAttempt Result Count=" + count);
				return count;

			} else {
				logger.info("entity not available=" + email);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			DAOException daoException = new DAOException();			
			logger.error(daoException.getMessage(), daoException);
			throw daoException;
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				logger.info("session closed");
			}
		}

		return count;

	}

	@Override
	public Integer feachLoginAttempt(String email) throws DAOException {
		logger.info("invoked feachLoginAttempt()");
		Session session = factory.openSession();
		Integer count = 0;
		try {
			Query query = session.getNamedQuery("feachAttemptByEmail");
			query.setParameter("mail", email);

			Object result = query.uniqueResult();
			logger.info("feacth count=" + result);
			if (Objects.nonNull(result)) {
				count = (Integer) result;
				logger.info("entity available=" + email);
				logger.info("Feach Result Count=" + count);
				return count;
			} else {
				logger.info("entity not available=" + email);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			DAOException daoException = new DAOException();			
			logger.error(daoException.getMessage(), daoException);
			throw daoException;
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				logger.info("session closed");
			}
		}

		return count;

	}

	@Override
	public String upadtePassByEmail(String password,String encricptedPass, String email) throws DAOException {
		logger.info("invoked upadtePassByEmail()");
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("updatePassByEmail");
			query.setParameter("mail", email);
			query.setParameter("pass", password);
			query.setParameter("enp", encricptedPass);

			Object result = query.executeUpdate();
			session.getTransaction().commit();
			logger.info("Transaction commited.");
			logger.info("EMAIL=" + email + " ,AND UPDATED PASSWORD=" + password);

			if (Objects.nonNull(result)) {
				logger.info("entity available=" + email);

				Integer count = (Integer) result;
				logger.info("Upadted password Result Count=" + count);

			} else {
				logger.info("entity not available=" + email);
			}

		}

		catch (Exception e) {
			DAOException daoException = new DAOException();			
			logger.error(daoException.getMessage(), daoException);
			throw daoException;
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				logger.info("session closed");
			}
		}

		return null;

	}
}
=======
package com.xworkz.xworkzcm.dao;

import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.xworkzcm.entity.XworkzCMEntity;
import com.xworkz.xworkzcm.exceptions.DAOException;
import lombok.Setter;

@Setter
@Repository
public class XworkzLoginDAOImpl implements XworkzLoginDAO {

	@Autowired
	private SessionFactory factory;

	public XworkzLoginDAOImpl() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public XworkzCMEntity fecthByEmailId(String email) throws DAOException {
		Session session = factory.openSession();

		try {
			Query query = session.getNamedQuery("byemail");
			query.setParameter("mail", email);

			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				System.out.println("entity found for =" + email);

				XworkzCMEntity entity = (XworkzCMEntity) result;
				System.out.println("nofattempt at dao=" + entity.getNoOfAttempt());
				return entity;
			}

			else {
				System.out.println("entity not found for =" + email);
				System.out.println("emailID is wrong!");
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("exeception occurd " + e.getMessage());
			DAOException daoException = new DAOException();
			throw daoException;
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session closed");
			}

		}
	}

	@Override
	public Integer countAndUpdateLoginAttempt(String email, int noOfAttempt) throws DAOException {
		System.out.println("invoked updateLoginAttempt()");
		Session session = factory.openSession();
		Integer count = 0;
		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("incAttemptByEmail");
			query.setParameter("mail", email);
			query.setParameter("noa", noOfAttempt);

			Object result = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Transaction commited.");
			System.out.println("EMAIL=" + email + " ,AND UPDATED NOFATTEMPTS=" + noOfAttempt);

			if (Objects.nonNull(count)) {
				System.out.println("entity available=" + email);

				count = (Integer) result;
				System.out.println("Upadte noOfAttempt Result Count=" + count);
				return count;

			} else {
				System.out.println("entity not available=" + email);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exeception occurd " + e.getMessage());
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session closed");
			}
		}

		return count;

	}

	@Override
	public Integer feachLoginAttempt(String email) throws DAOException {
		System.out.println("invoked feachLoginAttempt()");
		Session session = factory.openSession();
		Integer count = 0;
		try {
			Query query = session.getNamedQuery("feachAttemptByEmail");
			query.setParameter("mail", email);

			Object result = query.uniqueResult();
			System.out.println("feacth count=" + result);
			if (Objects.nonNull(result)) {
				count = (Integer) result;
				System.out.println("Feach Result Count=" + count);
				return count;
			} else {
				System.out.println("entity not available=" + email);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exeception occurd =" + e.getMessage());
			DAOException daoException = new DAOException();
			throw daoException;
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session closed");
			}
		}

		return count;

	}

	@Override
	public String upadtePassByEmail(String password,String encricptedPass, String email) throws DAOException {
		System.out.println("invoked upadtePassByEmail()");
		Session session = factory.openSession();
		try {
			session.beginTransaction();
			Query query = session.getNamedQuery("updatePassByEmail");
			query.setParameter("mail", email);
			query.setParameter("pass", password);
			query.setParameter("enp", encricptedPass);

			Object result = query.executeUpdate();
			session.getTransaction().commit();
			System.out.println("Transaction commited.");
			System.out.println("EMAIL=" + email + " ,AND UPDATED PASSWORD=" + password);

			if (Objects.nonNull(result)) {
				System.out.println("entity available=" + email);

				Integer count = (Integer) result;
				System.out.println("Upadted password Result Count=" + count);

			} else {
				System.out.println("entity not available=" + email);
			}

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println("exeception occurd " + e.getMessage());
		}

		finally {
			if (Objects.nonNull(session)) {
				session.close();
				System.out.println("session closed");
			}
		}

		return null;

	}
}
>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
