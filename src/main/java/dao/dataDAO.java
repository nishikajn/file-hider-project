package dao;

import db.MyConnection;
import model.Data;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dataDAO {

    // Fetch all hidden files for a user

    public static List<Data> getAllFiles(String email) throws SQLException {
        List<Data> files = new ArrayList<>();

        String query = "SELECT id, name, path, email FROM data WHERE email = ?";

        try (Connection connection = MyConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                files.add(new Data(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("path"),
                        rs.getString("email")
                ));
            }
        }
        return files;
    }

    // Hide file (store in DB & delete original)

    public static int hideFile(Data file) throws SQLException, IOException {

        String query = "INSERT INTO data(name, path, email, bin_data) VALUES (?, ?, ?, ?)";

        File originalFile = new File(file.getPath());

        try (Connection connection = MyConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             FileInputStream fis = new FileInputStream(originalFile)) {

            ps.setString(1, file.getFileName());
            ps.setString(2, file.getPath());
            ps.setString(3, file.getEmail());
            ps.setBinaryStream(4, fis, originalFile.length());

            int result = ps.executeUpdate();

            if (result > 0) {

                if (originalFile.exists()) {

                    boolean deleted = originalFile.delete();

                    if (deleted) {
                        System.out.println("Original file deleted successfully.");
                    } else {
                        System.out.println("Failed to delete original file. Make sure file is closed.");
                    }
                }
            }

            return result;
        }
    }

    // Unhide file (restore from DB)

    public static void unhide(int id) throws SQLException, IOException {

        String selectQuery = "SELECT path, bin_data FROM data WHERE id = ?";
        String deleteQuery = "DELETE FROM data WHERE id = ?";

        try (Connection connection = MyConnection.getConnection();
             PreparedStatement selectPs = connection.prepareStatement(selectQuery)) {

            selectPs.setInt(1, id);
            ResultSet rs = selectPs.executeQuery();

            if (rs.next()) {
                String path = rs.getString("path");
                InputStream is = rs.getBinaryStream("bin_data");

                try (FileOutputStream fos = new FileOutputStream(path)) {
                    fos.write(is.readAllBytes());
                }

                try (PreparedStatement deletePs = connection.prepareStatement(deleteQuery)) {
                    deletePs.setInt(1, id);
                    deletePs.executeUpdate();
                }

                System.out.println("File Unhidden successfully .");
            }
        }
    }
}