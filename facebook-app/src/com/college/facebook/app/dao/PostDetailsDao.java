package com.college.facebook.app.dao;

import com.college.facebook.app.model.Login;
import com.college.facebook.app.model.PostDetails;

import java.util.List;

public interface PostDetailsDao {
    int postDetails(PostDetails postDetails);

    List<PostDetails> getMyBlogs(Login user);

    int deletePost(String postId);

    PostDetails editPost(String postId);

    int updatePostDetails(PostDetails postDetails);
}
