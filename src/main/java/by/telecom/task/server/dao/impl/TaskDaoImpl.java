package by.telecom.task.server.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Task> cq = builder.createQuery(Task.class);
		Root<Task> root = cq.from(Task.class);
		cq.select(root);
		return entityManager.createQuery(cq).getResultList();
	}

	@Override
	public List<Task> getByEmployeeMonth(Employee employee, Date monthBegin, Date monthEnd) {
		List<Task> all = null;

		all = entityManager.createQuery("from Task t where t.employeeId = :employeeId", Task.class).setParameter("employeeId", employee.getId()).getResultList();

		// .setParameter("employeeId", String.valueOf(employee.getId())).getResultList();
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
