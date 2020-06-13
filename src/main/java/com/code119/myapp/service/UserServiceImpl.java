package com.code119.myapp.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.code119.myapp.dao.UserDAO;
import com.code119.myapp.dto.UserDTO;

@Service("userService") 
//서비스 이름 설정. controller 안의 @Resource와 대응됨.
public class UserServiceImpl implements UserService{

	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Override
	public UserDTO login(String email, String pwd){
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(email);
		userDTO.setPwd(pwd);
		return userDAO.getUserByAllInfo(userDTO);
	}

	@Override
	public String searchUser(String email) {
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(email);
		UserDTO ret = userDAO.getUserByEmail(userDTO);
		if(ret==null){
			return null;
		}else{
			return ret.getEmail();
		}
	}

	@Override
	public int insertUser(String email, String pwd) {
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(email);
		userDTO.setPwd(pwd);
		return userDAO.insertUser(userDTO);
	}

	@Override
	public int deleteUser(String email, String pwd) {
		// TODO Auto-generated method stub
		UserDTO userDTO = new UserDTO();
		userDTO.setEmail(email);
		userDTO.setPwd(pwd);
		return userDAO.deleteUser(userDTO);
	}
	
}
