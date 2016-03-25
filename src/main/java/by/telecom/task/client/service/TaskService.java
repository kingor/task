package by.telecom.task.client.service;

import java.util.Date;
import java.util.List;

import by.telecom.task.shared.domain.Employee;
import by.telecom.task.shared.domain.Task;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/taskService")
public interface TaskService extends RemoteService {

	public List<Task> getAll();

	public List<Task> getByEmployee(Employee employee);

	public List<Task> getByEmployeeMonth(Employee employee, Date dateBegin, Date dateEnd);
}
