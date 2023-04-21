package handler;

import data.friend.Friend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class BirthdayHandler {
    private List<Friend> friends = new ArrayList<>();

    //readFile method reads the flat file with friends birthdays information and populates freinds ArrayList with
    //the information it gets from the file
    public void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(" ");
                String lastName = values[0];
                String firstName = values[1];
                String dateOfBirth = values[2];
                String email = values[3];

                Friend friend = new Friend(lastName, firstName, dateOfBirth, email);
                friends.add(friend);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Friend> getFriends() {
        return this.friends;
    }

    public void sendBirthdayGreeting(String firstName, String lastName) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String todayString = formatDate.format(today);
        // Iterate over friends list
        for (Friend friend : friends){
            // Check if friends birthday matches actual date
            if (friend.getDateOfBirth().equals(todayString)){
                createAndSendBirthdayEmail(friend.getEmail(), friend.getFirstName());
            }
        }
    }

    public void sendBirthdayReminder(String firstName, String lastName) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String todayString = formatDate.format(today);
        // Iterate over friends list
        for (Friend friend : friends){
            if (friend.getDateOfBirth().equals(todayString)){
                createRemainderEmail(friend.getFirstName(), friend.getLastName());
            }
        }
    }

    public void createAndSendBirthdayEmail(String email, String name){
        Session session = EmailManager.getSession();
        Message message = new MimeMessage(session);

        try {
            Address emailAddress = new InternetAddress(email);
            message.setRecipient(Message.RecipientType.TO,emailAddress);
            message.setSubject("Happy Birthday!");
            message.setText("Happy Birthday, dear " + name + "!");
            Transport.send(message);
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void createRemainderEmail(String birthdayFirtsName, String birthdayLastName){
        Session session = EmailManager.getSession();
        Message message = new MimeMessage(session);

        try {
            for (Friend otherFriend : friends){
                if (otherFriend.getFirstName() != birthdayFirtsName && otherFriend.getLastName() != birthdayLastName){
                    Address emailAddress = new InternetAddress(otherFriend.getEmail());
                    message.setRecipient(Message.RecipientType.TO,emailAddress);
                    message.setSubject("Birthday Reminder");
                    message.setText("Dear " + otherFriend.getFirstName() + ", <br> Today is " + birthdayFirtsName + " " + birthdayLastName + "'s birthday." +
                            "<br>   Don't forget to send him a message!");
                    Transport.send(message);
                }
            }
        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleLeapYear(String firstName, String lastName) {
        // Iterate over friends list
        // Check if friend matches firstName and lastName
        // If yes, check if friend has birthday on
    }
}
