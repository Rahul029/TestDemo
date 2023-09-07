package com.mindtree.utility;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.EmailException;

public class Email {

public static void sendEmail() throws EmailException {
		
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("treeminds9805362169@gmail.com", "rahul@1998");
					}
				});
		try {
			Message message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("rahtha98@gmail.com"));
			message.setSubject("Extent Report");
			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			String filename = "C:\\Users\\rahth\\OneDrive\\Desktop\\BDD CHallenge\\BDD_Challenge_8_June\\Extent_Report\\cucumber-reports\\report.html";
			FileDataSource source = new FileDataSource(filename);
			messageBodyPart1.setDataHandler(new DataHandler(source));
			messageBodyPart1.setFileName(filename);
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);
			message.setContent(multipart);
			Transport.send(message);
			System.out.println("=====Email Sent=====");
		} catch (MessagingException e) {
			e.printStackTrace(); 
		}
	}
}
