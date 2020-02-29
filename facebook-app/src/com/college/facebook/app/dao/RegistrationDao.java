package com.college.facebook.app.dao;


import com.college.facebook.app.model.Registration;

import java.util.List;

public interface RegistrationDao {
    int save(Registration registration);

    List<Registration> getActiveUsers(String userId);
    List<Registration> getMyFriends(String userId);

}
