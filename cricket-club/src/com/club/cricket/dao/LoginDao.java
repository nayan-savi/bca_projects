package com.club.cricket.dao;

import com.club.cricket.model.Login;

public interface LoginDao {
    Login login(String username, String password);
}
