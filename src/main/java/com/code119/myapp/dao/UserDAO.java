package com.code119.myapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.code119.myapp.dto.UserDTO;

public interface UserDAO extends AbstractDAO<UserDTO, UserDTO>{
	public UserDTO getUserByAllInfo(UserDTO userDTO);
	public UserDTO getUserByEmail(UserDTO userDTO);
	public int insertUser(UserDTO userDTO);
	public int deleteUser(UserDTO userDTO);
}