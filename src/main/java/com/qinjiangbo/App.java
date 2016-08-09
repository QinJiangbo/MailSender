package com.qinjiangbo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws Exception {
		
		String rootDir = System.getProperty("user.dir");

		// Recipient's email ID needs to be mentioned.
		String to = "1105351275@qq.com";

		// Sender's email ID needs to be mentioned
		String from = Accounts.Hotmail.getUsername();
		final String username = Accounts.Hotmail.getUsername();// change accordingly
		final String password = Accounts.Hotmail.getPassword();// change accordingly

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", Accounts.Hotmail.getHostname());
		props.put("mail.smtp.port", Accounts.Hotmail.getPort());
		//props.put("mail.smtp.ssl.enable", "true"); //HTTP加密连接
		props.put("mail.smtp.starttls.enable", "true"); //纯文本连接

		// Get the Session object.
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		session.setDebug(true);

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			//message.setFrom(new InternetAddress(from));
			String nick = MimeUtility.encodeText("Richard");
			message.setFrom(new InternetAddress(nick + "<"+from+"> "));

			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

			// Set Subject: header field
			message.setSubject("Java Mail Demo");

			// Send the actual HTML message, as big as you like
			File htmlFile = new File(rootDir + "/data/index.html");
			String htmlStr = "";
			try {
				FileReader reader = new FileReader(htmlFile);
				BufferedReader bReader = new BufferedReader(reader);
				String s = "";
				while ((s = bReader.readLine()) != null) {
					htmlStr = htmlStr + s;
				}
				bReader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			message.setContent(htmlStr, "text/html");

			// Send message
			Transport.send(message);

			System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
