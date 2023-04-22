package handler;

import data.friend.Friend;
import org.apache.commons.mail.DefaultAuthenticator;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

public class EmailManager  {
    private static Session session;

    public static Session getSession() {
        if (session == null) {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp-relay.sendinblue.com");
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.ssl.trust", "smtp-relay.sendinblue.com");
            properties.put("mail.smtp.starttls.enable", "true");
            properties.put("mail.smtp.auth", "true");
            Authenticator authenticator = new DefaultAuthenticator("camilanorbis@gmail.com", "F4sUtGKEyBR6wkav");
            session = Session.getInstance(properties, authenticator);

        }
        return session;
    }

    public static Message getBirthdayMessage(String email, String name) {
        Session session = getSession();
        Message message = new MimeMessage(session);
        try {
            Address emailAddress = new InternetAddress(email);
            message.setRecipient(Message.RecipientType.TO,emailAddress);
            message.setSubject("Happy Birthday!");
            message.setText("Happy Birthday, dear " + name + "!");
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return message;
    }

    public static Message getRemainderMessage(List<Friend> friends, String birthdaysFriendFirtsName, String birthdaysFriendLastName) {
        Session session = getSession();
        Message message = new MimeMessage(session);
        try {
            for (Friend otherFriend : friends){
                if (otherFriend.getFirstName() != birthdaysFriendFirtsName && otherFriend.getLastName() != birthdaysFriendLastName){
                    Address emailAddress = new InternetAddress(otherFriend.getEmail());
                    message.setRecipient(Message.RecipientType.TO,emailAddress);
                    message.setSubject("Birthday Reminder");
                    message.setText("Dear " + otherFriend.getFirstName() + ", <br> Today is " + birthdaysFriendFirtsName + " " + birthdaysFriendLastName + "'s birthday." +
                            "<br>   Don't forget to send a message!");
                    Transport.send(message);
                }
            }
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return message;
    }

}
