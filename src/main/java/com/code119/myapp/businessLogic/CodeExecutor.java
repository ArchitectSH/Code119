package com.code119.myapp.businessLogic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code119.myapp.controller.HomeController;

public class CodeExecutor {
	
	private Runtime runtime;
	private Process process;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	public String[] compile(String path){
		runtime = Runtime.getRuntime();
		String[] results = new String[2];
		results[0]="";
		results[1]="";
		try {
			process = runtime.exec("javac "+path);
			
			process.waitFor();
			BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			BufferedReader result = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String errStr;
			String resultStr;
			while ((errStr = err.readLine()) != null)
			{
				results[0]+=errStr+"\n";
				
			}
			while((resultStr = result.readLine())!=null)	
			{
				results[1]+=resultStr+"\n";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public String[] run(String path, String className, String input){
		runtime = Runtime.getRuntime();
		String[] results = new String[2];
		results[0]="";
		results[1]="";
		try {
			int lastIndex = className.lastIndexOf('.');
			if(lastIndex==-1){
				process = runtime.exec("java -classpath "+path+" "+className);
			}else{
				process = runtime.exec("java -classpath "+path+" "+className.substring(0, lastIndex));
			}
			if(input!=null){
				OutputStream stdin = process.getOutputStream();
				PrintWriter pw = new PrintWriter(stdin);
				pw.write(input+"\n");
				pw.flush();
				pw.close();
			}
			
			process.waitFor();
			
			//process = runtime.exec("1");
			//process.waitFor();
			
			BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));
			BufferedReader result = new BufferedReader(new InputStreamReader(process.getInputStream()));
			
			String errStr;
			String resultStr;
			while ((errStr = err.readLine()) != null)
			{
				results[0]+=errStr+"\n";
				
			}
			while((resultStr = result.readLine())!=null)	
			{
				results[1]+=resultStr+"\n";
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return results;
	}
	
	public static void main(String[] args){
		String s = "C:/";
		
		CodeExecutor ce = new CodeExecutor();
		String[] result = ce.run(s, "ABC.java", "1");
		System.out.println(result[0]);
		System.out.println(result[1]);
		/*
		//Scanner sc = new Scanner(new FileInputStream("sample_input.txt"));
        
		Scanner sc = new Scanner(System.in);
		
		int T;
		int test_case;

		T = sc.nextInt();  
		System.out.println(T);*/
	}
}
