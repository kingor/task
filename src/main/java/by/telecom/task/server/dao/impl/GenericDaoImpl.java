/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 * @author kingor
 * @param <T>
 *            Entity class
 * @param <PK>
 *            primary key of entity
 */
@Repository
public class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {

	@PersistenceContext
	protected EntityManager entityManager;
	private static final Logger logger = Logger.getLogger(GenericDao.class.getName());

	@Override
	public List<T> getAll(Class classT) {
		logger.info("GenericDao");
		List<T> all = entityManager.createQuery("from " + classT.getSimpleName(), classT)
				.getResultList();
		return all;
	}

}
