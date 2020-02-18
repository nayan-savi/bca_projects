package college.custom.dao;

import college.custom.model.Employee;
import college.custom.model.User;

import java.util.List;

public interface EmployeeDao {
    int saveEmployee(Employee employee);
    List<Employee> viewEmployee();
    Employee modifyEmployee(int employeeId);

    int updateEmployee(Employee employee);

}
