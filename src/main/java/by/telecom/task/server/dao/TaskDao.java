package by.telecom.task.server.dao;

import java.util.Date;
import java.util.List;

import by.telecom.task.shared.domain.Employee;
import by.telecom.task.shared.domain.Task;

public interface TaskDao {

	List<Task> getByEmployee(Employee employee);

	List<Task> getByEmployeeMonth(Employee employee, Date monthBegin, Date monthEnd);

	List<Task> getAll();

}
