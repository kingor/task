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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
	protected EntityManager myEmf;
	private static final Logger logger = Logger.getLogger(EmployeeDao.class.getName());

	@Override
	public List<Employee> getByName(String name) {
		logger.info("SERVICE - EmployeeService Get all subscriber45456456!");
		List<Employee> all = null;
		// String SELECT_SQL = "select * from EMPLOYEE where name=" + name;
		// Query query = myEmf.createQuery(SELECT_SQL);
		// all = query.getResultList();
		return all;
	}

	@Override
	public List<Employee> getAll() {
		logger.info("DAO - EmployeeDao!");
		// List<Employee> all = new ArrayList<Employee>();
		// Employee empl = new Employee();
		// empl.setId(5L);
		// empl.setName("Name");
		// logger.info("Name - " + empl.getName());
		// all.add(empl);
		// logger.info("ALL - " + all.toString());
		// String SELECT_SQL = "SELECT e FROM employee e";
		// Query query = myEmf.createQuery(SELECT_SQL);
		// logger.info("QUERY - " + query.toString());
		// all = query.getResultList();
		CriteriaBuilder builder = myEmf.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = builder.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root);
		return myEmf.createQuery(cq).getResultList();

		// return all;
	}
}
