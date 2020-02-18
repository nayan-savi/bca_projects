package college.custom.dao;

import college.custom.model.Login;

public interface LoginDao {
    Login login(String username, String password);
}
