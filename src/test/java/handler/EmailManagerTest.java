package handler;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import data.friend.Friend;
import handler.EmailManager;

public class EmailManagerTest {
    @Mock
    private Session session;

    @Mock
    private Friend friend;

    @Mock
    private Transport transport;

    @Mock
    private MimeMessage message;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSession() {
        when(EmailManager.getSession()).thenReturn(session);
        assertEquals(session, EmailManager.getSession());
    }

    @Test
    public void testGetBirthdayMessage() {
        when(EmailManager.getBirthdayMessage("John@test.test", "John")).thenReturn(message);
        assertEquals(message, EmailManager.getBirthdayMessage("John@test.test", "John"));
    }

    @Test
    public void testGetRemainderMessage() {
        when(EmailManager.getRemainderMessage(null, "John", "Doe")).thenReturn(message);
        assertEquals(message, EmailManager.getRemainderMessage(null, "John", "Doe"));
    }
}
