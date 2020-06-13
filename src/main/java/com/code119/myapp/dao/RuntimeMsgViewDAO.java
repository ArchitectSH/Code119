package com.code119.myapp.dao;

import java.util.List;

import com.code119.myapp.dto.RuntimeMsgViewDTO;

public interface RuntimeMsgViewDAO extends AbstractDAO<RuntimeMsgViewDTO, RuntimeMsgViewDTO>{
	public List<RuntimeMsgViewDTO> getAllMsg(RuntimeMsgViewDTO RuntimeMsgViewDTO);
	public List<RuntimeMsgViewDTO> getTransMsgByMsg(RuntimeMsgViewDTO RuntimeMsgViewDTO);
}