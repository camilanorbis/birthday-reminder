package handler;

import data.friend.Friend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.MessagingException;

public class BirthdayHandler {

    public void sendBirthdayGreeting(List<Friend> friends) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String todayString = formatDate.format(today);
        todayString = todayString.substring(5);
        // Iterate over friends list
        for (Friend friend : friends){
            // Check if friends birthday matches actual date
            String birthMonthAndDay = friend.getDateOfBirth().substring(5);
            if (birthMonthAndDay.equals(todayString)){
                createBirthdayEmail(friend.getEmail(), friend.getFirstName());
                //createBirthdaySms();
            }
        }
    }

    public void sendBirthdayReminder(List<Friend> friends) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String todayString = formatDate.format(today);
        todayString = todayString.substring(5);
        // Iterate over friends list
        for (Friend friend : friends){
            String birthMonthAndDay = friend.getDateOfBirth().substring(5);
            if (birthMonthAndDay.equals(todayString)){
                createRemainderEmail(friends, friend.getFirstName(), friend.getLastName());
            }
        }
    }

    public void createBirthdayEmail(String email, String name){
        Message message = EmailManager.getBirthdayMessage(email, name);
        try {
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    /*public void createBirthdaySms(){

    }*/

    public void createRemainderEmail(List<Friend> friends, String birthdaysFriendFirtsName, String birthdaysFriendLastName){
        EmailManager.getRemainderMessage(friends, birthdaysFriendFirtsName, birthdaysFriendLastName);
    }

    public void handleLeapYear(String firstName, String lastName) {
        // Iterate over friends list
        // Check if friend matches firstName and lastName
        // If yes, check if friend has birthday on
    }
}
