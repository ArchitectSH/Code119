package com.code119.myapp.service;

import java.io.IOException;
import java.util.List;

import com.code119.myapp.dto.FileDTO;

public interface FileService {
	public List<FileDTO> openFiles(String email);
	public List<FileDTO> searchFileByFileName(String fileName);
	public List<FileDTO> searchFileByEmail(String email);
	public String openFile(String savePath, String fileName) throws IOException;
	public int saveFile(String savePath, String contents, String email, String fileName, boolean hide) throws IOException;
	public void overWriteFile(String savePath, String contents, String email, String fileName) throws IOException;
	public int deleteFileByEmail(String email);
	public int deleteFileByPath(String path);
	public int hideFile(String path, Boolean hide);
}