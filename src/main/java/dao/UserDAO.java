package dao;

import db.MyConnection;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {


    // Check if user already exists

    public static boolean userExists(String email) throws SQLException {

        String query = "SELECT 1 FROM users WHERE email = ?";

        try (Connection connection = MyConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();

            return rs.next(); // true if record exists
        }
    }

    // Save new user

    public static int saveUser(User user) throws SQLException {

        String query = "INSERT INTO users(name, email) VALUES (?, ?)";

        try (Connection connection = MyConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());

            return ps.executeUpdate();
        }
    }
}