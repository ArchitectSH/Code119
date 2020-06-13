package com.code119.myapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.code119.myapp.dto.CompileMsgViewDTO;

@Repository("compileMsgViewDAO")
public class CompileMsgViewDAOImpl extends AbstractDAOImpl<CompileMsgViewDTO, CompileMsgViewDTO> implements CompileMsgViewDAO {
	private final static String NAMESPACE="compileMsgView"; //SQL xmlÀÇ namespace °ª
	private final static String SELECT_ALL_MSG_QI="selectAllMsg";
	private final static String SELECT_TRANSMSG_BY_MSG_QI="selectTransMsgByMsg"; 
	
	@Override
	public List<CompileMsgViewDTO> getAllMsg(CompileMsgViewDTO compileMsgViewDTO) {
		// TODO Auto-generated method stub
		return (List<CompileMsgViewDTO>)getList(NAMESPACE+"."+SELECT_ALL_MSG_QI,compileMsgViewDTO);
	}

	@Override
	public List<CompileMsgViewDTO> getTransMsgByMsg(CompileMsgViewDTO compileMsgViewDTO) {
		// TODO Auto-generated method stub
		return (List<CompileMsgViewDTO>)getList(NAMESPACE+"."+SELECT_TRANSMSG_BY_MSG_QI,compileMsgViewDTO);
	}
}
