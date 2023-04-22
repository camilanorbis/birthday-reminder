package handler;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import data.friend.Friend;
import org.junit.Assert;
import org.junit.Test;
public class FriendsHandlerTest {
    @Test
    public void testReadFile() throws IOException {
        FriendsHandler friendsHandler = new FriendsHandler();
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn("LastName FirstName DateOfBirth Email")
                .thenReturn("David Smith 12-05-1990 david@gmail.com")
                .thenReturn(null);
        FileReader fileReader = mock(FileReader.class);
        friendsHandler.readFile("fileName");

        List<Friend> expectedList = new ArrayList<>();
        expectedList.add(new Friend("David", "Smith", "12-05-1990", "david@gmail.com"));
        Assert.assertEquals(expectedList, friendsHandler.getFriends());
    }
}
