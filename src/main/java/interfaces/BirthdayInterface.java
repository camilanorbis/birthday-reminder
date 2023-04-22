package interfaces;

import data.friend.Friend;

import java.util.List;

public interface BirthdayInterface {
    void sendBirthdayGreeting(List<Friend> friends);

    void sendBirthdayReminder(List<Friend> friends);

    void createBirthdayEmail(String email, String name);

    void createRemainderEmail(List<Friend> friends, String birthdaysFriendFirtsName, String birthdaysFriendLastName);
}
