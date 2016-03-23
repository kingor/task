/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.task.server.dao.impl;

import java.util.List;

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
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Long> implements EmployeeDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<Employee> getByName(String name) {
		List<Employee> all = null;
		String SELECT_SQL = "select * from EMPLOYEE where name=" + name;
		Query query = entityManager.createQuery(SELECT_SQL);
		all = query.getResultList();
		return all;
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> all = null;
		String SELECT_SQL = "select * from EMPLOYEE";
		Query query = entityManager.createQuery(SELECT_SQL);
		all = query.getResultList();
		return all;
	}

}
