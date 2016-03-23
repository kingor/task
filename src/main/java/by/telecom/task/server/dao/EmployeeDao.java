/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.telecom.task.server.dao;

import java.util.List;

import by.telecom.task.shared.domain.Employee;

/**
 *
 * @author ASUP8
 */
public interface EmployeeDao extends GenericDao<Employee, Long> {

	List<Employee> getByName(String name);

	List<Employee> getAll();
}
