/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.task.server.dao.impl;

import java.util.List;
//import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
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
	private static final Logger logger = Logger.getLogger(EmployeeDao.class.getSimpleName());

	@Override
	public List<Employee> getAll() {
		logger.info("DAO - EmployeeDao!");
		List<Employee> employeeList = entityManager.createQuery("from Employee ", Employee.class)
				.getResultList();
		return employeeList;

	}
}
