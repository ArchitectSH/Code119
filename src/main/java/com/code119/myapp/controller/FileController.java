package com.code119.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.code119.myapp.dto.FileDTO;
import com.code119.myapp.service.CompileMsgService;
import com.code119.myapp.service.FileService;
import com.code119.myapp.service.RuntimeMsgService;
import com.code119.myapp.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController {
	
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
	
    
    @RequestMapping(value="/save.do", method = RequestMethod.POST)
	public @ResponseBody String saveFile(String fileName, String contents, HttpSession session, Boolean overWrite) throws Exception{
    	int result = -1;
    	String email = (String)session.getAttribute("email");
    	if(email!=null){
    		if(overWrite==null){
	    		String already = null;
	    		already = fileService.openFile(realPath+email+"/", fileName);
	    		if(already==null)
	    			result = fileService.saveFile(realPath+email+"/", contents, email, fileName, true);
	    		else{
	    			return "already";
	    		}
    		}else{
    			fileService.overWriteFile(realPath+email+"/", contents, email, fileName);
    			return "1";
    		}
    	}
		
    	return String.valueOf(result);
    }
    
    @RequestMapping(value="/loadFile.do", method = RequestMethod.GET)
	public ModelAndView loadFile(HttpSession session) throws Exception{
    	String email = (String)session.getAttribute("email");
    	ModelAndView mav = new ModelAndView();
    	List<FileDTO> fileList;
    	if(email!=null){
    		fileList = fileService.openFiles(email);
    		for(FileDTO fDTO : fileList){
    			String path = fDTO.getPath();
    			path = path.substring(path.lastIndexOf("/")+1);
    			fDTO.setPath(path);
    		}
    	}else{
    		fileList = null;
    	}
    	
    	mav.addObject("fileList", fileList);
    	mav.setViewName("manageCode");
    	return mav;
    }
    
    @RequestMapping(value="/openFile.do", method = RequestMethod.GET)
	public ModelAndView openFile(String fileName, HttpSession session) throws Exception{
    	String email = (String)session.getAttribute("email");
    	ModelAndView mav = new ModelAndView();
    	
    	String path = realPath+email+"/";
    	String contents;
    	if(email!=null){
    		contents = fileService.openFile(path,fileName);
    	}else{
    		contents=null;
    	}
    	
    	mav.addObject("fileName", fileName);
    	mav.addObject("contents", contents);
    	mav.setViewName("index");
    	return mav;
    }
    
    @RequestMapping(value="/hideFile.do", method = RequestMethod.GET)
	public @ResponseBody Integer hideFile(String fileName, Boolean hide, HttpSession session) throws Exception{
    	String email = (String)session.getAttribute("email");
    	
    	String path = realPath+email+"/";
    	int result;
    	if(email!=null){
    		result = fileService.hideFile(path+fileName, hide);
    	}else{
    		result=-1;
    	}
    	
    	return result;
    }
    
    @RequestMapping(value="/deleteFile.do", method = RequestMethod.GET)
	public String deleteFile(String fileName, HttpSession session) throws Exception{
    	String email = (String)session.getAttribute("email");
    	String path = realPath+email+"/";
    	
    	fileService.deleteFileByPath(path+fileName);
    	
    	return "redirect:loadFile.do";
    }
    
    @RequestMapping(value="/searchFile.do", method = RequestMethod.GET)
	public ModelAndView searchFile(String fileName, String email) throws Exception{
    	List<FileDTO> fList=null;
    	if(fileName!=null)
    		fList = fileService.searchFileByFileName(fileName);
    	if(email!=null)
    		fList = fileService.searchFileByEmail(email);
    	
    	if(fList!=null)
	    	for(FileDTO fDTO : fList){
				String path = fDTO.getPath();
				path = path.substring(path.lastIndexOf("/")+1);
				logger.info("path{}",path);
				fDTO.setPath(path);
			}
    	
    	ModelAndView mav = new ModelAndView();
    	mav.addObject("fileList", fList);
    	mav.setViewName("searchCode");
    	
    	return mav;
    }
}
