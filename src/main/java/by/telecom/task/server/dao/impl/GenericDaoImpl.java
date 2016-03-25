package by.telecom.task.server.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import by.telecom.task.server.dao.GenericDao;

/**
 * 
 * @param <T>
 *            Entity class
 * @param <PK>
 *            primary key of entity
 */
@Repository
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger logger = Logger.getLogger(GenericDao.class.getName());

	@Override
	public List<T> getAll(Class classT) {
		logger.info("DAO - caused getAll()");
		List<T> all = entityManager.createQuery("from " + classT.getSimpleName(), classT).getResultList();
		return all;
	}

}
