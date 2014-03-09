package tn.esprit.projet.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tn.esprit.projet.controler.ReclamationController;

public class MailClass {

    // Recipient's email ID needs to be mentioned.
    String to ;

    // Sender's email ID needs to be mentioned
    String from ;

    // Assuming you are sending email from localhost
    String host = "localhost";
    String FromNom;
    String ToNom;
    Session session;

    // Get system properties
    Properties props;
    String Sujet;
    String Messagetext;

    public MailClass() {
 props= System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("gamtestej.nimda@gmail.com","jetsetadmin");
				}
			});

    }

    public void Setmail(String sujet, String message) {
        Sujet = sujet;
        Messagetext = message;

    }

    public void SendMyMail(String fromadress, String toadress, String fromnom, String tonom) throws UnsupportedEncodingException, MessagingException {
      
            from = fromadress;
            to = toadress;
            FromNom = fromnom;
            ToNom = tonom;
            
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);
            
            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from,FromNom));
            
            
            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to,ToNom));

            // Set Subject: header field
            message.setSubject(Sujet);

            // Now set the actual message
            message.setText(Messagetext);

            // Send message
            Transport.send(message);
        System.out.println("Sent message successfully....");
        


    }

//    public static void main(String[] args) {
//        
//        
//        MailClass class1 = new MailClass();
//        class1.Setmail("New ", "this is a tne w accoun t");
//        try {
//            class1.SendMyMail("clientjetsetmag@gmail.com","espritjetset@gmail.com","yahya","Administrateur");
//        } catch (UnsupportedEncodingException ex) {
//            Logger.getLogger(MailClass.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MessagingException ex) {
//            Logger.getLogger(MailClass.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}