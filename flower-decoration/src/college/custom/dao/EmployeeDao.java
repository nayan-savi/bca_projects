package college.custom.dao;

import college.custom.model.Employee;
import college.custom.model.User;

import java.util.List;

public interface EmployeeDao {

    List<User> getSupports();
    List<User> getResolveSupports(int userId);
    int startSupportRequest(int userId,int supportId);
    User modifySupportRequest(int supportId);
    int updateSupportRequest(int supportId, String reply);
    List<User> getReplies(int userId);

    int saveEmployee(Employee employee);

}
