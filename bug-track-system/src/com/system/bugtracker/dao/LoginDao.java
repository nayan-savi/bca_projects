package com.system.bugtracker.dao;

import com.system.bugtracker.model.Employee;

public interface LoginDao {
	Employee login(String username, String password);
}
