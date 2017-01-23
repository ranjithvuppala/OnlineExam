package tarun.bth.App;

import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;
import javax.mail.*;
import javax.mail.internet.*;
import com.sun.mail.smtp.*;
public class SendMail {
     public static void main(String args[]) throws Exception {
         Properties props = System.getProperties();
         props.put("mail.smtps.host","smtp.mailgun.org");
         props.put("mail.smtps.auth","true");
         Session session = Session.getInstance(props, null);
         Message msg = new MimeMessage(session);
         msg.setFrom(new InternetAddress("ranjithalekhya@gmail.com"));
         msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ranjithalekhya@gmail.com", false));
         msg.setSubject("Hello");
         msg.setText("Testing some Mailgun awesomness");
         msg.setSentDate(new Date());
         SMTPTransport t = (SMTPTransport)session.getTransport("smtps");
         t.connect("smtp.mailgun.org", "Mailgun-ID", "Mailgun-Key");
         t.sendMessage(msg, msg.getAllRecipients());
         System.out.println("Response: " + t.getLastServerResponse());
         t.close();
     }
 }
