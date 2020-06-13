package com.code119.myapp.dao;

import java.util.List;

import com.code119.myapp.dto.FileDTO;

public interface FileDAO extends AbstractDAO<FileDTO, FileDTO>{
	public List<FileDTO> getFileByPath(FileDTO fileDTO);
	public List<FileDTO> getFileByEmail(FileDTO fileDTO);
	public List<FileDTO> getFileByFileName(FileDTO fileDTO);
	public List<FileDTO> getFileByEmailLike(FileDTO fileDTO);
	public int insertFile(FileDTO fileDTO);
	public int deleteFileByEmail(FileDTO fileDTO);
	public int deleteFileByPath(FileDTO fileDTO);
	public int updateFileHide(FileDTO fileDTO);
}