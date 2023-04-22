package handler;

import data.friend.Friend;
import interfaces.FriendsInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FriendsHandler implements FriendsInterface {
    private List<Friend> friends = new ArrayList<>();

    //readFile method reads the flat file with friends birthdays information and populates friends ArrayList with
    //the information it gets from the file
    @Override
    public void readFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            boolean isFirstLine = true;
            String line;
            while ((line = br.readLine()) != null) {
                if (isFirstLine){
                    isFirstLine = false;
                    continue;
                }
                String[] values = line.trim().split("\\s+");
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

}
