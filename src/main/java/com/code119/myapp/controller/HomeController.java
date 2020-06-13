package com.code119.myapp.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.code119.myapp.businessLogic.CodeExecutor;
import com.code119.myapp.businessLogic.FileManager;
import com.code119.myapp.dto.UserDTO;
import com.code119.myapp.service.CompileMsgService;
import com.code119.myapp.service.FileService;
import com.code119.myapp.service.RuntimeMsgService;
import com.code119.myapp.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller //��Ʈ�ѷ� ��ü���� ����
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	private static final String realPath="C:/codes/";
	
	@Autowired
	ServletContext context; 
	  
	@Resource(name="userService")
    private UserService userService;
	@Resource(name="fileService")
	private FileService fileService;
	@Resource(name="compileMsgService")
	private CompileMsgService compileMsgService;
	@Resource(name="runtimeMsgService")
	private RuntimeMsgService runtimeMsgService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/run.do", method = RequestMethod.POST)
	public @ResponseBody Map<String , String> compile(String fileName, String contents, String input) {
		Map<String, String> data = new HashMap<String, String>();
	    
	    FileManager fileManager = new FileManager();
	    try {
			fileManager.saveFile(realPath, contents, fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
    	CodeExecutor ce = new CodeExecutor();
    	String[] compileResults = ce.compile(realPath+fileName);
    	if(compileResults[0].equals("")){
    		String[] runResults = ce.run(realPath,fileName,input);
    		fileManager.deleteFile(realPath, fileName);
    		if(runResults[0].equals("")){
    			data.put("result", runResults[1]);
    			return data;
    		}else{
    			while(runResults[0].contains(realPath)){
    				runResults[0] = runResults[0].replace(realPath, "");
    			}
    			data.put("originRunErr", runResults[0]);
    			data.put("transRunErr", runtimeMsgService.transMsg(runResults[0]));
    			return data;
    		}
    	}else{
    		while(compileResults[0].contains(realPath)){
    			compileResults[0] = compileResults[0].replace(realPath, "");
    		}
    		data.put("originCompileErr", compileResults[0]);
    		data.put("transCompileErr", compileMsgService.transMsg(compileResults[0]));
    		fileManager.deleteFile(realPath, fileName);
    		return data;
    	}
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(String email, String pwd, HttpSession session, ServletRequest request) {
    	UserDTO userDTO = userService.login(email, pwd);
    	if(userDTO==null){
    		request.setAttribute("loginResult", false);
    	}else{
    		session.setAttribute("email", email);
    	}
    	return "index";
	}
	
	
    @RequestMapping(value="/join.do", method = RequestMethod.POST)  
    public String join(String email, String pwd, HttpSession session, ServletRequest request) throws Exception{
    	   	
    	String already  = userService.searchUser(email);
    	if(already==null){
    		userService.insertUser(email, pwd);
    		request.setAttribute("joinResult", true);
    	}else{
    		request.setAttribute("joinResult", false);
    	}
    	
    	return "index";
    }
    
    @RequestMapping(value="/logout.do", method = RequestMethod.POST)
	public String logout(HttpSession session) throws Exception{
		session.invalidate();
		
		return "index";
    }
    
    @RequestMapping(value="/home.do", method = RequestMethod.GET)
	public String home(HttpSession session) throws Exception{
		
		return "index";
    }
}
