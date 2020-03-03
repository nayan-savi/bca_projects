package com.collage.app.pizza.dao;


import com.collage.app.pizza.model.Login;

public interface LoginDao {
    Login login(String username, String password);
}
