package com.college.facebook.app.dao;

import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.Registration;

import java.util.List;

public interface NotificationDao {
    List<Registration> getNotification(Login login);

    int confirmNotification(String userId, String friendId);

    int deleteNotification(String userId, String friendId);
}
