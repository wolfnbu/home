package com.struts2.action;

import com.common.MailUtil;
import com.common.StringCommonUtil;
import com.opensymphony.xwork2.Action;

public class SendMessageAction implements Action{

	private String name;
	private String email;
	private String subject;
	private String message;
	private String returnMessage;
	
	public String execute() throws Exception {
		String name = getName();
		String email = getEmail();
		String subject = getSubject();
		String message = getMessage();
		
		if (subject == null || "".equals(subject)) {
			subject = "there is no subject";
		}

        StringBuffer emailMsg = new StringBuffer();  
        emailMsg.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">")
		        .append("<html>")
		        .append("<head>")
		        .append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
		        .append("<title>Message from " + name +"</title>")
		        .append("<style type=\"text/css\">")
		        .append(".test{font-family:\"Microsoft Yahei\";text-decoration:underline;font-size:15px;color:blue;}")
		        .append("</style>")
		        .append("</head>")
		        .append("<body>")
		        .append("<span class=\"test\">Message from:</span><br/>")
		        .append(name + "<br/><br/>")
		        .append("<span class=\"test\">His/her email is:</span><br/>")
		        .append(email + "<br/><br/>")
		        .append("<span class=\"test\">Below is the message:</span><br/>")
		        .append(message + "<br/><br/>")
		        .append("</body>")
		        .append("</html>");

		if (name == null || "".equals(name)) {
			setReturnMessage("Please at least tell me who you are, and send again.");
			return StringCommonUtil.STRUTS2_RETURN_SUCCESS;
		}
		if (message == null || "".equals(message)) {
			setReturnMessage("What you want to say to me?");
			return StringCommonUtil.STRUTS2_RETURN_SUCCESS;
		}
		try {
			MailUtil.sendEmailToAllan(subject, emailMsg.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return StringCommonUtil.STRUTS2_RETURN_ERROR;
		}

		System.out.println("this is just test message-------------------------------");
		System.out.println("name : " + getName());
		System.out.println("email : " + getEmail());
		System.out.println("subject : " + getSubject());
		System.out.println("message : "+ getMessage());
		System.out.println("this is just test message-------------------------------");

		setReturnMessage("Got your message, thanks.");
		return StringCommonUtil.STRUTS2_RETURN_SUCCESS;
	}

	/**
	 * @return the returnMessage
	 */
	public String getReturnMessage() {
		return returnMessage;
	}

	/**
	 * @param returnMessage the returnMessage to set
	 */
	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
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
