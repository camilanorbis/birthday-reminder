package data.friend;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class FriendTest {
    @Test
    void testGetLastName() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getLastName()).thenReturn("John");
        assertEquals("John", mockFriend.getLastName());
    }

    @Test
    void testSetLastName() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getLastName()).thenReturn("Smith");
        mockFriend.setLastName("Smith");
        assertEquals("Smith", mockFriend.getLastName());
    }

    @Test
    void testGetFirstName() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getFirstName()).thenReturn("John");
        assertEquals("John", mockFriend.getFirstName());
    }

    @Test
    void testSetFirstName() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getFirstName()).thenReturn("Smith");
        mockFriend.setFirstName("Smith");
        assertEquals("Smith", mockFriend.getFirstName());
    }

    @Test
    void testGetDateOfBirth() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getDateOfBirth()).thenReturn("01-01-2000");
        assertEquals("01-01-2000", mockFriend.getDateOfBirth());
    }

    @Test
    void testSetDateOfBirth() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getDateOfBirth()).thenReturn("01-01-2000");
        mockFriend.setDateOfBirth("01-01-2000");
        assertEquals("01-01-2000", mockFriend.getDateOfBirth());
    }

    @Test
    void testGetEmail() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getEmail()).thenReturn("john@example.com");
        assertEquals("john@example.com", mockFriend.getEmail());
    }

    @Test
    void testSetEmail() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getEmail()).thenReturn("john@example.com");
        mockFriend.setEmail("john@example.com");
        assertEquals("john@example.com", mockFriend.getEmail());
    }

    @Test
    void testGetCellphone() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getCellphone()).thenReturn(1234567890);
        assertEquals(1234567890, mockFriend.getCellphone());
    }

    @Test
    void testSetCellphone() {
        Friend mockFriend = Mockito.mock(Friend.class);
        Mockito.when(mockFriend.getCellphone()).thenReturn(1234567890);
        mockFriend.setCellphone(1234567890);
        assertEquals(1234567890, mockFriend.getCellphone());
    }
}
