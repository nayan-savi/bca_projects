package com.voilation.traffic.dao;

import com.voilation.traffic.model.Login;

public interface LoginDao {
    Login login(String username, String password);
}
