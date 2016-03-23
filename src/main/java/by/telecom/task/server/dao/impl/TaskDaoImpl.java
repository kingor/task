package by.telecom.task.server.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import by.telecom.task.server.dao.TaskDao;
import by.telecom.task.shared.domain.Employee;
import by.telecom.task.shared.domain.Task;

@Repository
public class TaskDaoImpl implements TaskDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public List<Task> getByEmployee(Employee employee) {
		List<Task> all = null;
		String SELECT_SQL = "select * from TASK where employeeId=" + employee.getId();
		Query query = entityManager.createQuery(SELECT_SQL);

		all = query.getResultList();
		return all;
	}

	@Override
	public List<Task> getByEmployeeMonth(Employee employee, Date monthBegin, Date monthEnd) {
		List<Task> all = null;
		String SELECT_SQL = "select * from TASK where employeeId=" + employee.getId();
		Query query = entityManager.createQuery(SELECT_SQL);

		all = query.getResultList();
		return all;
	}

	@Override
	public List<Task> getAll() {
		List<Task> all = null;
		String SELECT_SQL = "select * from TASK";
		Query query = entityManager.createQuery(SELECT_SQL);
		all = query.getResultList();
		return all;
	}
}
