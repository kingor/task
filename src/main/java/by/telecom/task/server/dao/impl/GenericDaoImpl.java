/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.task.server.dao.impl;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import by.telecom.task.server.dao.GenericDao;
//import org.apache.log4j.Logger;

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

	@Override
	public T read(Class<T> classT, PK id) {
		T objectT = (T) entityManager.find(classT, id);
		return objectT;
	}

}
