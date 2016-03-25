package by.telecom.task.server.dao.impl;

import org.springframework.stereotype.Repository;

import by.telecom.task.server.dao.EmployeeDao;
import by.telecom.task.shared.domain.Employee;

@Repository
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Long> implements EmployeeDao {

}
