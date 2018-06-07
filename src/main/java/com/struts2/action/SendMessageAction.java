package com.struts2.action;

import com.common.StringCommonUtil;
import com.opensymphony.xwork2.Action;

public class SendMessageAction implements Action{

	private String name;
	private String email;
	private String subject;
	private String message;
	
	public String execute() throws Exception {
		
		System.out.println("this is just test message-------------------------------");
		System.out.println("name : " + getName());
		System.out.println("email : " + getEmail());
		System.out.println("subject : " + getSubject());
		System.out.println("message : "+ getMessage());
		System.out.println("this is just test message-------------------------------");
		
		return StringCommonUtil.STRUTS2_RETURN_SUCCESS;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
