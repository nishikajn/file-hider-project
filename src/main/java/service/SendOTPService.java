package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.Properties;


 //Service responsible for sending OTP emails.

public class SendOTPService {

    private static final Properties config = new Properties();

    static {
        try (InputStream input =
                     SendOTPService.class
                             .getClassLoader()
                             .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("application.properties not found");
            }
            config.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load email configuration", e);
        }
    }

    public static void sendOTP(String recipientEmail, String otp) {

        Properties props = new Properties();
        props.put("mail.smtp.host", config.getProperty("mail.smtp.host"));
        props.put("mail.smtp.port", config.getProperty("mail.smtp.port"));
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.auth", "true");

        String senderEmail = config.getProperty("mail.smtp.username");
        String senderPassword = config.getProperty("mail.smtp.password");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(senderEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
            message.setSubject("Your OTP for Secure File Hider");
            message.setText("Your One-Time Password (OTP) is: " + otp);

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send OTP email", e);
        }
    }
}