package com.common;

import java.io.File;

public class CommonTester {

	public static void main(String[] args) {
		try {
//			String value = PropertiesUtil.getProperties(PropertiesUtil.TEST_KEY);
//			System.out.println(value);
			File directory = new File("");//设定为当前文件夹 
			try{ 
			    System.out.println(directory.getCanonicalPath());//获取标准的路径 
			    System.out.println(directory.getAbsolutePath());//获取绝对路径 
			}catch(Exception e){} 
			
			
			String subject = "subject";
			String message = "this is just test message";
			MailUtil.sendEmailToAllan(subject, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
