package service;

import dao.UserDAO;
import model.User;

import java.sql.SQLException;
import java.util.Optional;


  //Business logic for User management.

public class UserService {


    public static boolean userExists(String email) {
        try {
            return UserDAO.userExists(email);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public enum UserStatus {
        SUCCESS,
        ALREADY_EXISTS,
        ERROR
    }

    public static UserStatus saveUser(User user) {
        try {
            if (UserDAO.userExists(user.getEmail())) {
                return UserStatus.ALREADY_EXISTS;
            } else {
                int rows = UserDAO.saveUser(user);
                return rows > 0 ? UserStatus.SUCCESS : UserStatus.ERROR;
            }
        } catch (SQLException ex) {
            // Log the exception in production
            ex.printStackTrace();
            return UserStatus.ERROR;
        }
    }
}