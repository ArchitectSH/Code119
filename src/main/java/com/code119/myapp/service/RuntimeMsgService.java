package com.code119.myapp.service;

import java.util.List;

import com.code119.myapp.dto.RuntimeMsgViewDTO;

public interface RuntimeMsgService {
	public String transMsg(String runtimeResult);
	public List<RuntimeMsgViewDTO> getAllMsg();
	public List<RuntimeMsgViewDTO> getTransMsgByMsg(String runtimeMsg);
}