package com.code119.myapp.dao;

import org.springframework.stereotype.Repository;

import com.code119.myapp.dto.UserDTO;

@Repository("userDAO")	//DAO 이름 설정. Service Impl 안의 @Resource와 대응됨.x
public class UserDAOImpl extends AbstractDAOImpl<UserDTO, UserDTO> implements UserDAO{
	private final static String NAMESPACE="user"; //SQL xml의 namespace 값
	private final static String SELECT_USER_BY_ALL_INFO_QI="selectUserByAllInfo";
	private final static String SELECT_USER_BY_EMAIL_QI="selectUserByEmail";
	private final static String INSERT_USER_QI="insertUser";
	private final static String DELETE_USER_QI="deleteUser";
	
	public UserDTO getUserByAllInfo(UserDTO userDTO){
		return (UserDTO)getOne(NAMESPACE+"."+SELECT_USER_BY_ALL_INFO_QI, userDTO);
	}

	@Override
	public UserDTO getUserByEmail(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return (UserDTO)getOne(NAMESPACE+"."+SELECT_USER_BY_EMAIL_QI, userDTO);
	}
	
	@Override
	public int insertUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return insert(NAMESPACE+"."+INSERT_USER_QI, userDTO);
	}

	@Override
	public int deleteUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return delete(NAMESPACE+"."+DELETE_USER_QI, userDTO);
	}
	
}
