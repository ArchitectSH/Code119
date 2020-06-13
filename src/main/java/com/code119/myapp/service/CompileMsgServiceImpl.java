package com.code119.myapp.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.code119.myapp.businessLogic.KMP;
import com.code119.myapp.controller.HomeController;
import com.code119.myapp.dao.CompileMsgViewDAO;
import com.code119.myapp.dto.CompileMsgViewDTO;

@Service("compileMsgService") 
public class CompileMsgServiceImpl implements CompileMsgService{

	@Resource(name="compileMsgViewDAO")
	private CompileMsgViewDAO compileMsgViewDAO;
	
	@Override
	public String transMsg(String compileResult) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder(compileResult);
		
		List<CompileMsgViewDTO> compileMsgs = getAllMsg();
		
		for(CompileMsgViewDTO compileMsg : compileMsgs){
			compileResult = compileResult.replace(compileMsg.getMessage(), compileMsg.getTransMsg());
			
			List<Integer> indexes = KMP.findSubstring(compileMsg.getMessage(), compileResult);
			for(Integer index : indexes){
				sb.replace(index, index+compileMsg.getMessage().length(), compileMsg.getTransMsg());
			}
		}
		
		return compileResult;
	}

	@Override
	public List<CompileMsgViewDTO> getAllMsg() {
		// TODO Auto-generated method stub
		return compileMsgViewDAO.getAllMsg(null);
	}

	@Override
	public List<CompileMsgViewDTO> getTransMsgByMsg(String compileMsg) {
		// TODO Auto-generated method stub
		CompileMsgViewDTO compileMsgViewDTO = new CompileMsgViewDTO();
		compileMsgViewDTO.setMessage(compileMsg);
		return compileMsgViewDAO.getTransMsgByMsg(compileMsgViewDTO);
	}
	
	
}