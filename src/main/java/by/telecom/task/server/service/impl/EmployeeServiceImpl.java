package by.telecom.task.server.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.task.client.service.EmployeeService;
import by.telecom.task.server.dao.EmployeeDao;
import by.telecom.task.shared.domain.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeeDao;
	private static final Logger logger = Logger.getLogger(EmployeeService.class.getName());

	@Override
	@Transactional
	public List<Employee> getAll() {
		logger.info("SERVICE - caused getAll()");
		return employeeDao.getAll(Employee.class);
	}

}
