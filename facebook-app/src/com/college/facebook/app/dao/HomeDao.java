package com.college.facebook.app.dao;

import com.college.facebook.app.model.PostDetails;

import java.util.List;

public interface HomeDao {
    int like(String postId, String userId);
    int unlike(String postId, String userId);

    List<PostDetails> getPosts(String userId);
}
