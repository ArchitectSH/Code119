package com.code119.myapp.businessLogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileManager {
	
	public void saveFile(String savePath, String contents, String fileName) throws IOException{
		File file = new File(savePath);
		if(!file.exists()){
			file.mkdirs();
		}
		FileWriter fw = new FileWriter(savePath+"/"+fileName);
		PrintWriter	pw = new PrintWriter(fw);
		pw.print(contents);
		pw.flush();
		pw.close();
	}
	public String loadFile(String savePath, String fileName) throws IOException{
		File file = new File(savePath+fileName);
		String contents=null;
		if(file.exists()){
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			contents="";
			String s;
			while((s = br.readLine())!=null){
				contents+=s+'\n';
			}
		}
		return contents;
	}
	public boolean deleteFile(String savePath, String fileName){
		File file = new File(savePath);
		return file.delete();
	}
	
	
	public static void main(String[] args){
		FileManager fm = new FileManager();
		try {
			fm.saveFile("C:\\apache-tomcat-8.0.39\\wtpwebapps\\Code119\\wltmdgk@naver.com\\", "wioenfoiweng", "ABC.java");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}