package com.code119.myapp.service;

import java.util.List;

import com.code119.myapp.dto.CompileMsgViewDTO;

public interface CompileMsgService {
	public String transMsg(String compileResult);
	public List<CompileMsgViewDTO> getAllMsg();
	public List<CompileMsgViewDTO> getTransMsgByMsg(String compileMsg);
}