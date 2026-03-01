package views;

import model.User;
import service.GenerateOTP;
import service.SendOTPService;
import service.UserService;

import java.util.Scanner;


 //Welcome screen and login/signup flow for File Hider App

public class Welcome {

    private final Scanner sc;

    public Welcome() {
        sc = new Scanner(System.in);
    }


     //Displays the welcome menu and handles user choice

    public void welcomeScreen() {
        boolean running = true;

        while (running) {
            System.out.println("\n=== Welcome to File Hider App ===");
            System.out.println("1 - Login");
            System.out.println("2 - Sign Up");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine();

            switch (input) {
                case "1" -> login();
                case "2" -> signUp();
                case "0" -> {
                    System.out.println("Thank you for using File Hider. Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        sc.close();
    }

      //Handles user login with OTP verification

    private void login() {
        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

        try {
            if (UserService.userExists(email)) {
                String otp = GenerateOTP.getOTP();
                SendOTPService.sendOTP(email, otp);

                System.out.print("Enter the OTP: ");
                String enteredOtp = sc.nextLine();

                if (enteredOtp.equals(otp)) {
                    new views.UserView(email).home();
                } else {
                    System.out.println("Wrong OTP. Login failed.");
                }

            } else {
                System.out.println("User not found. Please sign up first.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Handles user signup with OTP verification

    private void signUp() {
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your email: ");
        String email = sc.nextLine().trim();

        String otp = GenerateOTP.getOTP();
        SendOTPService.sendOTP(email, otp);

        System.out.print("Enter the OTP: ");
        String enteredOtp = sc.nextLine();

        if (!enteredOtp.equals(otp)) {
            System.out.println("Wrong OTP. Signup failed.");
            return;
        }

        User user = new User(name, email);
        UserService.UserStatus status = UserService.saveUser(user);

        switch (status) {
            case SUCCESS -> System.out.println("User registered successfully!");
            case ALREADY_EXISTS -> System.out.println("User already exists. Please login.");
            case ERROR -> System.out.println("Error registering user. Try again later.");
        }
    }
}