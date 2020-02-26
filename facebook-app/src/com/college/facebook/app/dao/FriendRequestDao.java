package com.college.facebook.app.dao;

import com.college.facebook.app.model.FriendRequest;

public interface FriendRequestDao {
    int sendRequest(FriendRequest friendRequest);
}
