package views;

import dao.dataDAO;
import model.Data;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class UserView {

    private final String email;

    public UserView(String email) {
        this.email = email;
    }

    public void home() {
        boolean running = true;
        Scanner sc = new Scanner(System.in);

        while (running) {
            System.out.println("\nWelcome " + this.email);
            System.out.println("1 - Show hidden files");
            System.out.println("2 - Hide a new file");
            System.out.println("3 - Unhide a file");
            System.out.println("0 - Exit");
            System.out.print("Enter your choice: ");

            String input = sc.nextLine();
            switch (input) {
                case "1" -> showHiddenFiles();
                case "2" -> hideNewFile(sc);
                case "3" -> unhideFile(sc);
                case "0" -> {
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }

    private void showHiddenFiles() {
        try {
            List<Data> files = dataDAO.getAllFiles(this.email);
            if (files.isEmpty()) {
                System.out.println("No hidden files found.");
            } else {
                System.out.println("ID - File Name");
                for (Data file : files) {
                    System.out.println(file.getId() + " - " + file.getFileName());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error fetching files. Please try again.");
        }
    }

    private void hideNewFile(Scanner sc) {
        System.out.print("Enter the file path: ");
        String path = sc.nextLine().trim();
        File f = new File(path);

        if (!f.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        Data file = new Data(0, f.getName(), path, this.email);

        try {
            dataDAO.hideFile(file);
            System.out.println("File hidden successfully.");
        } catch (SQLException | IOException e) {
            System.out.println("Failed to hide file. Please try again.");
        }
    }

    private void unhideFile(Scanner sc) {
        try {
            List<Data> files = dataDAO.getAllFiles(this.email);
            if (files.isEmpty()) {
                System.out.println("No hidden files to unhide.");
                return;
            }

            System.out.println("ID - File Name");
            for (Data file : files) {
                System.out.println(file.getId() + " - " + file.getFileName());
            }

            System.out.print("Enter the ID of the file to unhide: ");
            String input = sc.nextLine();
            int id;
            try {
                id = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format.");
                return;
            }

            boolean valid = files.stream().anyMatch(f -> f.getId() == id);
            if (!valid) {
                System.out.println("No file with this ID.");
                return;
            }

            dataDAO.unhide(id);
            System.out.println("File unhidden successfully.");

        } catch (SQLException | IOException e) {
            System.out.println("Error un-hiding file. Please try again.");
        }
    }
}