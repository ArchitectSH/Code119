package com.code119.myapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.code119.myapp.businessLogic.KMP;
import com.code119.myapp.dao.RuntimeMsgViewDAO;
import com.code119.myapp.dto.RuntimeMsgViewDTO;
import com.code119.myapp.dto.RuntimeMsgViewDTO;

@Service("runtimeMsgService") 
public class RuntimeMsgServiceImpl implements RuntimeMsgService{

	@Resource(name="runtimeMsgViewDAO")
	private RuntimeMsgViewDAO runtimeMsgViewDAO;
	
	@Override
	public String transMsg(String runtimeResult) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(runtimeResult);
		
		List<RuntimeMsgViewDTO> runtimeMsgs = getAllMsg();
		
		for(RuntimeMsgViewDTO runtimeMsg : runtimeMsgs){
			runtimeResult = runtimeResult.replace(runtimeMsg.getMessage(), runtimeMsg.getTransMsg());
			
			List<Integer> indexes = KMP.findSubstring(runtimeMsg.getMessage(), runtimeResult);
			for(Integer index : indexes){
				sb.replace(index, index+runtimeMsg.getMessage().length(), runtimeMsg.getTransMsg());
			}
		}
		
		return runtimeResult;
	}

	@Override
	public List<RuntimeMsgViewDTO> getAllMsg() {
		// TODO Auto-generated method stub
		return runtimeMsgViewDAO.getAllMsg(null);
	}

	@Override
	public List<RuntimeMsgViewDTO> getTransMsgByMsg(String runtimeMsg) {
		// TODO Auto-generated method stub
		RuntimeMsgViewDTO runtimeMsgViewDTO = new RuntimeMsgViewDTO();
		runtimeMsgViewDTO.setMessage(runtimeMsg);
		return runtimeMsgViewDAO.getTransMsgByMsg(runtimeMsgViewDTO);
	}
	
	
}