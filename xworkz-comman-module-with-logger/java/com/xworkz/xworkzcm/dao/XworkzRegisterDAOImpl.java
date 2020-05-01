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
public class XworkzRegisterDAOImpl implements XworkzRegisterDAO {

	private static final Logger logger = LogManager.getLogger(XworkzRegisterDAOImpl.class);

	@Autowired
	private SessionFactory factory;

	public XworkzRegisterDAOImpl() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@Override
	public void saveUser(XworkzCMEntity entity) throws DAOException {
		logger.info("invoked saveUser()...");
		Session session = factory.openSession();
		try {
			if (Objects.nonNull(session)) {
				session.beginTransaction();
				logger.info("transcation stared..");
				session.save(entity);
				session.getTransaction().commit();
				logger.info("Transaction commited");
				logger.info("Entity is not null , the entity is saved");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
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
	public boolean fetchUserId(String userId) throws DAOException {
		logger.info("invoked fetchUserId");

		Session session = factory.openSession();

		try {
			Query query = session.getNamedQuery("userCheck");
			query.setParameter("user", userId);

			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				logger.info("entity found " + userId);
				return true;

			} else {
				logger.info("entity not found " + userId);
				return false;
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

	}

	@Override
	public boolean fetchEmail(String email) throws DAOException {
		logger.info("invoked fetchEmail");

		Session session = factory.openSession();

		try {
			Query query = session.getNamedQuery("emailCheck");
			query.setParameter("mail", email);

			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				logger.info("entity found " + email);
				return true;

			} else {
				logger.info("entity not found " + email);
				return false;
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
public class XworkzRegisterDAOImpl implements XworkzRegisterDAO {

	@Autowired
	private SessionFactory factory;

	public XworkzRegisterDAOImpl() {
		System.out.println("created " + this.getClass().getSimpleName());
	}

	@Override
	public void saveUser(XworkzCMEntity entity) throws DAOException {
		System.out.println("invoked saveUser()...");
		Session session = factory.openSession();
		try {
			if (Objects.nonNull(session)) {
				session.beginTransaction();
				System.out.println("transcation stared..");
				session.save(entity);
				session.getTransaction().commit();
				System.out.println("Transaction commited");
				System.out.println("Entity is not null , the entity is saved");
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
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
	public boolean fetchUserId(String userId) throws DAOException {
		Session session = factory.openSession();

		try {
			Query query = session.getNamedQuery("userCheck");
			query.setParameter("user", userId);

			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				System.out.println("entity found " + userId);
				return true;

			} else {
				System.out.println("entity not found " + userId);
				return false;
			}
		}

		catch (Exception e) {
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
	public boolean fetchEmail(String email) throws DAOException {
		Session session = factory.openSession();

		try {
			Query query = session.getNamedQuery("emailCheck");
			query.setParameter("mail", email);

			Object result = query.uniqueResult();
			if (Objects.nonNull(result)) {
				System.out.println("entity found " + email);
				return true;

			} else {
				System.out.println("entity not found " + email);
				return false;
			}
		}

		catch (Exception e) {
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

	

}
>>>>>>> 78f9debd4658a027688d5dfe997e8af36dfc3c23
