package by.telecom.task.server.dao;

import java.util.Date;
import java.util.List;

import by.telecom.task.shared.domain.Employee;
import by.telecom.task.shared.domain.Task;

public interface TaskDao extends GenericDao<Task, Long> {

	/*
	 * Returns task list for this employee
	 */
	List<Task> getByEmployee(Employee employee);

	/*
	 * Returns task list for this employee and this month
	 */
	List<Task> getByEmployeeMonth(Employee employee, Date monthBegin, Date monthEnd);

}
