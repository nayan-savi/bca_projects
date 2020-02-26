package com.college.facebook.app.dao;


import com.college.facebook.app.model.Login;

public interface LoginDao {
    Login login(String username, String password);
}
