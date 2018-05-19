package org.mainjsp;


import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Mailserv {

public static void send(String to, String subject, String body) {
    Properties props = System.getProperties();
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.user", "<mailid>");
    props.put("mail.smtp.password", "<password>");
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

    Session session = Session.getInstance(props,null);
    MimeMessage message = new MimeMessage(session);

    System.out.println("Port: "+session.getProperty("mail.smtp.port"));

    try {
        InternetAddress from = new InternetAddress("<mailid>");
        message.setSubject(subject);
        message.setFrom(from);
        message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

        Multipart multipart = new MimeMultipart("alternative");

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText("some text to send");

        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();
        String htmlMessage = body;
        messageBodyPart.setContent(htmlMessage, "text/html");

        multipart.addBodyPart(messageBodyPart);

        message.setContent(multipart);

        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.gmail.com", "<mailid>", "<password>");
        System.out.println("Transport: "+transport.toString());
        transport.sendMessage(message, message.getAllRecipients());


    } catch (AddressException e) {
        e.printStackTrace();
    } catch (MessagingException e) {
        e.printStackTrace();
    }
}
}
