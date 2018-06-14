package com.common;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.exception.NoPropertiesException;

/**
 * Email Utility
 * @author allandeng
 *
 */
public class MailUtil {

	/**
	 * send email to Allan
	 * @param subject
	 * @param emailMsg
	 */
	public static void sendEmailToAllan(String subject, String emailMsg) {
		String allaEmailAddress = null;
		try {
			allaEmailAddress = PropertiesUtil.getProperties(PropertiesUtil.ALLAN_EMAIL_ADDRESS);
			sendEmail(allaEmailAddress, subject, emailMsg);
		} catch (NoPropertiesException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * send email function
	 * @param sendto
	 * @param subject
	 * @param emailMsg
	 */
	public static void sendEmail(String sendto, String subject, String emailMsg) {
		try {
			//create Session
			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", PropertiesUtil.getProperties(PropertiesUtil.MAIL_TRANSPORT_PROTOCOL));
			props.setProperty("mail.smtp.host", PropertiesUtil.getProperties(PropertiesUtil.MAIL_SMTP_HOST));
			props.setProperty("mail.smtp.port", PropertiesUtil.getProperties(PropertiesUtil.MAIL_SMTP_PORT));
			// need authentication
			props.setProperty("mail.smtp.auth", "true");
			props.setProperty("mail.smtp.timeout","1000");

			//set authentication
			final String userName = PropertiesUtil.getProperties(PropertiesUtil.MAIL_SEND_USER_NAME);
			final String passwd = PropertiesUtil.getProperties(PropertiesUtil.MAIL_SEND_PASSWD);
			Authenticator auth = new Authenticator() {
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, passwd);
			    }
			};
			Session session = Session.getInstance(props, auth);
			// create mail message
			Message message = new MimeMessage(session);
			// set sender
			message.setFrom(new InternetAddress(userName));
			// set receiver
			message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(sendto));
			// set subject
			message.setSubject(subject);
			// set content
			message.setContent(emailMsg, "text/html;charset=utf-8");
			// send message
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (NoPropertiesException npe) {
			npe.printStackTrace();
		}
	}
}
