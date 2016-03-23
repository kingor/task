/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.task.server.dao.impl;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.telecom.task.server.dao.EmployeeDao;
import by.telecom.task.shared.domain.Employee;

/**
 *
 * @author kingor
 */
@Repository
public class EmployeeDaoHibImpl extends GenericDaoHibImpl<Employee, Long> implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	private static final Logger logger = Logger.getLogger(EmployeeDao.class.getName());

	@Override
	public List<Employee> getByName(String name) {
		logger.info("Get by name");
		Session session = null;
		List<Employee> all = null;
		session = sessionFactory.getCurrentSession();
		all = session.createCriteria(Employee.class).add(Restrictions.like("name", "%" + name + "%")).list();
		return all;
	}

}
