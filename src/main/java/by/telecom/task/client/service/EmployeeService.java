package by.telecom.task.client.service;

import java.util.List;

import by.telecom.task.shared.domain.Employee;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("springGwtServices/employeeService")
public interface EmployeeService extends RemoteService {

	public List<Employee> getAll();
}
