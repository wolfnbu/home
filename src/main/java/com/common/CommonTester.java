package com.common;

public class CommonTester {

	public static void main(String[] args) {
		try {
//			String value = PropertiesUtil.getProperties(PropertiesUtil.TEST_KEY);
//			System.out.println(value);
			
			String subject = "subject";
			String message = "this is just test message";
			MailUtil.sendEmailToAllan(subject, message);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
