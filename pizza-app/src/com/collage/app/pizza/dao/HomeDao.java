package com.collage.app.pizza.dao;

public interface HomeDao {
    int like(String postId, String userId);
    int unlike(String postId, String userId);

}
