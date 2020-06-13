package com.code119.myapp.service;

import com.code119.myapp.dto.UserDTO;

public interface UserService {
	public UserDTO login(String email, String pwd);
	public String searchUser(String email);
	public int insertUser(String email, String pwd);
	public int deleteUser(String email, String pwd);
}