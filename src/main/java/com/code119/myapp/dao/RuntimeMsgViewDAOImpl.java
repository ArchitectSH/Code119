package com.code119.myapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.code119.myapp.dto.RuntimeMsgViewDTO;

@Repository("runtimeMsgViewDAO")
public class RuntimeMsgViewDAOImpl extends AbstractDAOImpl<RuntimeMsgViewDTO, RuntimeMsgViewDTO> implements RuntimeMsgViewDAO {
	private final static String NAMESPACE="runtimeMsgView"; //SQL xmlÀÇ namespace °ª
	private final static String SELECT_ALL_MSG_QI="selectAllMsg";
	private final static String SELECT_TRANSMSG_BY_MSG_QI="selectTransMsgByMsg"; 
	
	@Override
	public List<RuntimeMsgViewDTO> getAllMsg(RuntimeMsgViewDTO runtimeMsgViewDTO) {
		// TODO Auto-generated method stub
		return (List<RuntimeMsgViewDTO>)getList(NAMESPACE+"."+SELECT_ALL_MSG_QI,runtimeMsgViewDTO);
	}

	@Override
	public List<RuntimeMsgViewDTO> getTransMsgByMsg(RuntimeMsgViewDTO runtimeMsgViewDTO) {
		// TODO Auto-generated method stub
		return (List<RuntimeMsgViewDTO>)getList(NAMESPACE+"."+SELECT_TRANSMSG_BY_MSG_QI,runtimeMsgViewDTO);
	}
}
