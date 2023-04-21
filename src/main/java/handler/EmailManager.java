package handler;

import javax.mail.Session;
import java.util.Properties;

public class EmailManager {
    private static Session session;

    public static Session getSession() {
        if (session == null) {
            Properties properties = new Properties();
            properties.put("mail.smtp.host", "smtp.gmail.com");
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.username", "birthdayreminderjava@gmail.com");
            properties.put("mail.smtp.password", "birthdayreminder123");
            session = Session.getInstance(properties);
        }
        return session;
    }

}
