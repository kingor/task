package by.telecom.task.server.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.telecom.task.client.service.TaskService;
import by.telecom.task.server.dao.TaskDao;
import by.telecom.task.shared.domain.Employee;
import by.telecom.task.shared.domain.Task;

@Service("taskService")
public class TaskServiceImpl implements TaskService {

	private static final Logger logger = Logger.getLogger(TaskService.class.getName());

	@Autowired
	TaskDao taskDao;

	@Override
	@Transactional
	public List<Task> getAll() {
		logger.info("SERVICE - Get tasks all subscriber!");
		return taskDao.getAll();
	}

	@Override
	@Transactional
	public List<Task> getByEmployee(Employee employee) {
		logger.info("SERVICE - Get tasks by employee!");
		return taskDao.getByEmployee(employee);
	}

	@Override
	@Transactional
	public List<Task> getByEmployeeMonth(Employee employee, Date dateBegin, Date dateEnd) {
		logger.info("SERVICE - Get tasks by employee and month!");
		return taskDao.getByEmployeeMonth(employee, dateBegin, dateEnd);
		// return taskDao.getByEmployee(employee);
	}

}
