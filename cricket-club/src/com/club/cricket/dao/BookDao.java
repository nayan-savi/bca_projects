package com.club.cricket.dao;

import java.util.List;

import com.club.cricket.model.Book;

public interface BookDao {

	int saveBook(Book book);

    List<Book> viewBooks(String username);

    Book getBookById(String parameter);

    int updateBook(Book book);
}
