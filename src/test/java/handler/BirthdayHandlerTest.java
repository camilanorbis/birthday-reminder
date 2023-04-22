package handler;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import data.friend.Friend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

public class BirthdayHandlerTest {
    @Mock
    private List<Friend> friends;

    private BirthdayHandler birthdayHandler;

    private Friend friend1;
    private Friend friend2;

    @Before
    public void setUp() {
        friends = mock(ArrayList.class);
        birthdayHandler = new BirthdayHandler();

        friend1 = new Friend("John", "Doe", "john@doe.com", "1994-04-29");
        friend2 = new Friend("Jane", "Doe", "jane@doe.com", "1992-04-29");

        when(friends.get(0)).thenReturn(friend1);
        when(friends.get(1)).thenReturn(friend2);
    }

    @Test
    public void testSendBirthdayGreeting() {
        birthdayHandler.sendBirthdayGreeting(friends);
        verify(friends).get(0);
        verify(friends).get(1);
    }

    @Test
    public void testSendBirthdayReminder() {
        birthdayHandler.sendBirthdayReminder(friends);
        verify(friends).get(0);
        verify(friends).get(1);
    }

    @Test
    public void testCreateBirthdayEmail() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String todayString = formatDate.format(today);
        todayString = todayString.substring(5);

        if(friend1.getDateOfBirth().substring(5).equals(todayString)) {
            birthdayHandler.createBirthdayEmail(friend1.getEmail(), friend1.getFirstName());
        }
    }

    @Test
    public void testCreateRemainderEmail() {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String todayString = formatDate.format(today);
        todayString = todayString.substring(5);

        if(friend1.getDateOfBirth().substring(5).equals(todayString)) {
            birthdayHandler.createRemainderEmail(friends, friend1.getFirstName(), friend1.getLastName());
        }
    }
}
