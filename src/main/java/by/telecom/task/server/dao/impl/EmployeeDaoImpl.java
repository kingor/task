/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.task.server.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import by.telecom.task.server.dao.EmployeeDao;
import by.telecom.task.shared.domain.Employee;

/**
 *
 * @author kingor
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	protected EntityManager entityManager;
	private static final Logger logger = Logger.getLogger(EmployeeDao.class.getName());

	@Override
	public List<Employee> getByName(String name) {
		logger.info("SERVICE - EmployeeService Get all subscriber!");
		List<Employee> all = null;
		String SELECT_SQL = "select * from EMPLOYEE where name=" + name;
		Query query = entityManager.createQuery(SELECT_SQL);
		all = query.getResultList();
		return all;
	}

	@Override
	public List<Employee> getAll() {
		logger.info("Dao - EmployeeService Get all subscriber!");
		List<Employee> all = null;
		String SELECT_SQL = "select * from EMPLOYEE";
		Query query = entityManager.createQuery(SELECT_SQL);
		all = query.getResultList();
		return all;
	}

}
