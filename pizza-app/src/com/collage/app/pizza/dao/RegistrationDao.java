package com.collage.app.pizza.dao;


import com.collage.app.pizza.model.Registration;

import java.util.List;

public interface RegistrationDao {
    int save(Registration registration);

    List<Registration> getActiveUsers(String userId);
    List<Registration> getMyFriends(String userId);

}
