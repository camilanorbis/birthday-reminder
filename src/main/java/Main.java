import data.friend.Friend;
import handler.BirthdayHandler;
import handler.FriendsHandler;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        //Create database table and flat file with friend's birthdays
        /*ProcessBuilder processBuilder = new ProcessBuilder("load_data.sh");
        try {
            processBuilder.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        
        //reading provided file
        FriendsHandler friendsHandler = new FriendsHandler();
        friendsHandler.readFile("C:\\Dev\\PersonalProjects\\birthday-reminder\\src\\main\\resources\\friendsBirthdays.txt");

        //Populating friends array
        BirthdayHandler birthdayHandler = new BirthdayHandler();
        List<Friend> friends = friendsHandler.getFriends();

        //Sendind birthday greetings for today
        birthdayHandler.sendBirthdayGreeting(friends);
        //Sending birthday reminders for today
        birthdayHandler.sendBirthdayReminder(friends);
        
        
    }
}