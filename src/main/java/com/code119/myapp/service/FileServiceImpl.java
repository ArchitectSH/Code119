package com.code119.myapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.code119.myapp.businessLogic.FileManager;
import com.code119.myapp.dao.FileDAO;
import com.code119.myapp.dto.FileDTO;

@Service("fileService") 
//서비스 이름 설정. controller 안의 @Resource와 대응됨.
public class FileServiceImpl implements FileService {
	@Override
	public int hideFile(String path, Boolean hide) {
		// TODO Auto-generated method stub
		FileDTO fileDTO = new FileDTO();
		fileDTO.setPath(path);
		fileDTO.setHide(hide);
		return fileDAO.updateFileHide(fileDTO);
	}

	@Resource(name="fileDAO")
	private FileDAO fileDAO;
	
	@Override
	public List<FileDTO> openFiles(String email) {
		// TODO Auto-generated method stub
		FileDTO fileDTO = new FileDTO();
		fileDTO.setEmail(email);
		return fileDAO.getFileByEmail(fileDTO);
	}
	
	
	
	@Override
	public List<FileDTO> searchFileByFileName(String fileName) {
		// TODO Auto-generated method stub
		FileDTO fileDTO = new FileDTO();
		fileDTO.setPath(fileName);
		List<FileDTO> fList = fileDAO.getFileByFileName(fileDTO);
		List<FileDTO> publicList = new ArrayList<FileDTO>();
		for(FileDTO f : fList){
			if(!f.isHide()){
				publicList.add(f);
			}
		}
		return publicList;
	}



	@Override
	public List<FileDTO> searchFileByEmail(String email) {
		// TODO Auto-generated method stub
		FileDTO fileDTO =new FileDTO();
		fileDTO.setEmail(email);
		List<FileDTO> fList = fileDAO.getFileByEmailLike(fileDTO);
		List<FileDTO> publicList = new ArrayList<FileDTO>();
		for(FileDTO f : fList){
			if(!f.isHide()){
				publicList.add(f);
			}
		}
		
		return publicList;
	}



	@Override
	public String openFile(String savePath, String fileName) throws IOException {
		// TODO Auto-generated method stub
		FileManager fm = new FileManager();
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setPath(savePath+fileName);
		List<FileDTO> f = fileDAO.getFileByPath(fileDTO);
		String contents = null;
		if(f!=null && f.size()>0)
			contents = fm.loadFile(savePath, fileName);
		
		return contents;
	}

	@Override
	public int saveFile(String savePath, String contents, String email, String fileName, boolean hide) throws IOException {
		// TODO Auto-generated method stub
		
		FileManager fm = new FileManager();
		fm.saveFile(savePath, contents, fileName);
		
		FileDTO fileDTO = new FileDTO();
		fileDTO.setEmail(email);
		fileDTO.setPath(savePath+fileName);
		fileDTO.setHide(hide);
		return fileDAO.insertFile(fileDTO);
	}
	
	@Override
	public void overWriteFile(String savePath, String contents, String email, String fileName) throws IOException {
		// TODO Auto-generated method stub
		FileManager fm = new FileManager();
		fm.saveFile(savePath, contents, fileName);
	}

	@Override
	public int deleteFileByEmail(String email) {
		// TODO Auto-generated method stub
		FileDTO fileDTO = new FileDTO();
		fileDTO.setEmail(email);
		return fileDAO.deleteFileByEmail(fileDTO);
	}

	@Override
	public int deleteFileByPath(String path) {
		// TODO Auto-generated method stub
		FileDTO fileDTO = new FileDTO();
		fileDTO.setPath(path);
		return fileDAO.deleteFileByPath(fileDTO);
	}


	
}