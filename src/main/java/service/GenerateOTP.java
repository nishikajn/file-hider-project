package service;

import com.sun.mail.imap.Utility;

import java.security.SecureRandom;


  //Utility class for generating secure OTPs.

public final class GenerateOTP {

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final int OTP_LENGTH = 4;

    private GenerateOTP() {
        // Prevent instantiation
    }

    public static String getOTP() {
        int bound = (int) Math.pow(10, OTP_LENGTH);
        int otp = secureRandom.nextInt(bound);
        return String.format("%0" + OTP_LENGTH + "d", otp);
    }
}