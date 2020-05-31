package college.custom.dao;

import java.util.List;

import college.custom.model.Employee;

public interface EmployeeDao {
    int saveEmployee(Employee employee);
    List<Employee> viewEmployee();
    Employee modifyEmployee(int employeeId);

    int updateEmployee(Employee employee);

}
