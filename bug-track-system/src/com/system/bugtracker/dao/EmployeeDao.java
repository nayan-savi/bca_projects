package com.system.bugtracker.dao;

import java.util.List;

import com.system.bugtracker.model.Employee;

public interface EmployeeDao {
    int save(Employee registration);
    int updatePwd(Employee employee);
    List<Employee> viewEmployees(boolean active);
    Employee getEmployeeById(String id);
    int updateEmployee(Employee employee);
}
