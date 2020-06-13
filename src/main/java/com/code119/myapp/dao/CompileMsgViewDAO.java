package com.code119.myapp.dao;

import java.util.List;

import com.code119.myapp.dto.CompileMsgViewDTO;

public interface CompileMsgViewDAO extends AbstractDAO<CompileMsgViewDTO, CompileMsgViewDTO>{
	public List<CompileMsgViewDTO> getAllMsg(CompileMsgViewDTO compileMsgViewDTO);
	public List<CompileMsgViewDTO> getTransMsgByMsg(CompileMsgViewDTO compileMsgViewDTO);
}