package com.common;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.exception.NoPropertiesException;

public class PropertiesUtil {

	public static String TEST_KEY = "test.key";
	
	//main properties
	public static String MAIN_PROPERTIES = "/conf.properties";
	
	//mail sender user name
	public static String MAIL_SEND_USER_NAME = "mail.163.username";

	//mail sender passwd
	public static String MAIL_SEND_PASSWD = "mail.163.passwd";
	
	//mail transport protocal
	public static String MAIL_TRANSPORT_PROTOCOL = "mail.transport.protocol";

	//mail smtp host
	public static String MAIL_SMTP_HOST = "mail.smtp.host";

	//mail smtp port
	public static String MAIL_SMTP_PORT = "mail.smtp.port";
	
	//allan email address
	public static String ALLAN_EMAIL_ADDRESS = "mail.allandengjl.address";
	
	//broadcast image folder
	public static String PATH_BROADCAST_IMAGE = "path.broadcast.image";

	/**
	 * Get value from property 
	 * @param key
	 * @return
	 * @throws NoPropertiesException
	 */
	@SuppressWarnings("finally")
	public static String getProperties(String key) throws NoPropertiesException{
		String value = null;
		InputStream propertiesFile = null;
		try {
			if (key == null || "".equals(key)) {
				throw new NoPropertiesException("Key can't be empty.");
			}
			Properties pps = new Properties();
			propertiesFile = PropertiesUtil.class.getResourceAsStream(MAIN_PROPERTIES);
			//propertiesFile = new FileInputStream(MAIN_PROPERTIES_PATH);
			pps.load(propertiesFile);
			value = pps.getProperty(key);
			if (value == null) {
				throw new NoPropertiesException("Nothing value found for Key : " + key);
			}
			if (propertiesFile != null) {
				propertiesFile.close();
			}
		} catch (FileNotFoundException fnfe) {
			throw new NoPropertiesException("The properties file is not found.");
		} catch (IOException ioe) {
			throw new NoPropertiesException("There is IO error when reading properties file.");
		} finally {
			return value;
		}
	}
}
