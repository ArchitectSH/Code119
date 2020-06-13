package com.code119.myapp.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.code119.myapp.dto.FileDTO;

@Repository("fileDAO")
public class FileDAOImpl extends AbstractDAOImpl<FileDTO, FileDTO> implements FileDAO{
	private final static String NAMESPACE="file"; //SQL xmlÀÇ namespace °ª
	private final static String SELECT_FILE_BY_PATH_QI="selectFileByPath";
	private final static String SELECT_FILE_BY_EMAIL_QI="selectFileByEmail";
	private final static String SELECT_FILE_BY_FILENAME_QI="selectFileByFileName";
	private final static String SELECT_FILE_BY_EMAIL_LIEK_QI="selectFileByEmailLike";
	private final static String INSERT_FILE_QI="insertFile";
	private final static String DELETE_FILE_BY_EMAIL_QI="deleteFileByEmail";
	private final static String DELETE_FILE_BY_PATH_QI="deleteFileByPath";
	private final static String UPDATE_FILE_HIDE="updateFileHide";
	
	@Override
	public List<FileDTO> getFileByPath(FileDTO fileDTO) {
		// TODO Auto-generated method stub
		return (List<FileDTO>)getList(NAMESPACE+"."+SELECT_FILE_BY_PATH_QI,fileDTO);
	}
	@Override
	public List<FileDTO> getFileByEmail(FileDTO fileDTO) {
		// TODO Auto-generated method stub
		return (List<FileDTO>)getList(NAMESPACE+"."+SELECT_FILE_BY_EMAIL_QI,fileDTO);
	}
		
	@Override
	public List<FileDTO> getFileByFileName(FileDTO fileDTO) {
		// TODO Auto-generated method stub
		return (List<FileDTO>)getList(NAMESPACE+"."+SELECT_FILE_BY_FILENAME_QI,fileDTO);
	}
	
	@Override
	public List<FileDTO> getFileByEmailLike(FileDTO fileDTO) {
		// TODO Auto-generated method stub
		return (List<FileDTO>)getList(NAMESPACE+"."+SELECT_FILE_BY_EMAIL_LIEK_QI,fileDTO);
	}
	@Override
	public int insertFile(FileDTO fileDTO) {
		// TODO Auto-generated method stub
		return insert(INSERT_FILE_QI, fileDTO);
	}
	@Override
	public int deleteFileByEmail(FileDTO fileDTO) {
		// TODO Auto-generated method stub
		return delete(DELETE_FILE_BY_EMAIL_QI, fileDTO);
	}
	@Override
	public int deleteFileByPath(FileDTO fileDTO) {
		// TODO Auto-generated method stub
		return delete(DELETE_FILE_BY_PATH_QI, fileDTO);
	}
	@Override
	public int updateFileHide(FileDTO fileDTO) {
		// TODO Auto-generated method stub
		return update(UPDATE_FILE_HIDE,fileDTO);
	}
	
	
}
