package by.telecom.task.server.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import by.telecom.task.server.dao.TaskDao;
import by.telecom.task.shared.domain.Employee;
import by.telecom.task.shared.domain.Task;

@Repository
public class TaskDaoImpl extends GenericDaoImpl<Task, Long> implements TaskDao {

	@PersistenceContext
	private EntityManager entityManager;
	private static final Logger logger = Logger.getLogger(TaskDao.class);

	@Override
	public List<Task> getByEmployee(Employee employee) {
		logger.info("DAO - caused getByEmployee()");

		List<Task> taskList = entityManager.createQuery("from Task t where t.employee = :employee ", Task.class).setParameter("employee", employee)
				.getResultList();

		return taskList;
	}

	@Override
	public List<Task> getByEmployeeMonth(Employee employee, Date monthBegin, Date monthEnd) {
		logger.info("DAO - caused getByEmployeeMonth()");

		List<Task> taskList = entityManager
				.createQuery("from Task t where t.employee = :employee and dateBegin<=:monthEnd and dateEnd>=:monthBegin", Task.class)
				.setParameter("employee", employee).setParameter("monthBegin", monthBegin).setParameter("monthEnd", monthEnd).getResultList();

		return taskList;
	}
}
