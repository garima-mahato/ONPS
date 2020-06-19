package pollingPack;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailPro {
	

	public void postMail( String recipient, String subject, String message) throws MessagingException
	{
		boolean debug = false;
     //Set the host smtp address
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.smtp.starttls.enable","true"); 
		    props.put("mail.smtp.EnableSSL.enable","true");
		
		Authenticator auth=new SMTPAuthenticator();
    // create some properties and get the default Session
		Session session = Session.getInstance(props, auth);
		session.setDebug(debug);
    // create a message
		Message msg = new MimeMessage(session);
    // set the from and to address
		InternetAddress addressFrom = new InternetAddress("indiaonps@gmail.com");
		msg.setFrom(addressFrom);
		InternetAddress addressTo = new InternetAddress(recipient); 
		
			//addressTo = new InternetAddress(recipient);
	
		msg.setRecipient(Message.RecipientType.TO, addressTo);
    // Optional : You can also set your custom headers in the Email if you Want
		msg.addHeader("MyHeaderName", "myHeaderValue");
    // Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/plain");
		Transport.send(msg);
	}
 class SMTPAuthenticator extends javax.mail.Authenticator 
	{
	 public PasswordAuthentication getPasswordAuthentication()
	 {
		String user="indiaonps@gmail.com";
		String pwd= "26011951";
		return new PasswordAuthentication(user,pwd);	
	 }		
    }
}
