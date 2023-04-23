import data.friend.Friend;
import handler.BirthdayHandler;
import handler.FriendsHandler;

import java.util.List;

public class Main {
    public static void main(String[] args){

        //reading provided file
        FriendsHandler friendsHandler = new FriendsHandler();
        friendsHandler.readFile("..\\birthday-reminder\\src\\main\\resources\\friendsBirthdays.txt");

        //Populating friends array
        BirthdayHandler birthdayHandler = new BirthdayHandler();
        List<Friend> friends = friendsHandler.getFriends();

        //Sendind birthday greetings for today
        birthdayHandler.sendBirthdayGreeting(friends);
        //Sending birthday reminders for today
        birthdayHandler.sendBirthdayReminder(friends);
        
        
    }
}