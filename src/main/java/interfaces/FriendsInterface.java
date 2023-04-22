package interfaces;

import data.friend.Friend;

import java.util.ArrayList;
import java.util.List;

public interface FriendsInterface {

    List<Friend> friends = new ArrayList<>();

    void readFile(String fileName);

    List<Friend> getFriends();
}
