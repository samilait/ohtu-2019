package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;
    private String userAlphabets, passAlphabets;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
        this.userAlphabets = "abcdefghijklmnopqrstuvwxyz";
        this.passAlphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        
        // Check user name
        boolean validUsername = true;
        for (int i = 0; i < username.length(); i++) {
            if (userAlphabets.indexOf(username.charAt(i)) == -1) {
                validUsername = false;
            }
        }
        
        if (username.length() < 3) {
            validUsername = false;
        }                
        
        boolean validPassword = true;
        int numberOfAlphabets = 0; 
        for (int i = 0; i < password.length(); i++) {
            if (this.passAlphabets.indexOf(password.charAt(i)) != -1) {
                numberOfAlphabets++;
            }
        }
        
        if (numberOfAlphabets == password.length()) {
            validPassword = false;
        }
        
        if (password.length() < 8) {
            validPassword = false;
        }
        
        if (!validUsername) {
            return true;
        }
        
        if (!validPassword) {
            return true;
        }
        
        return false;

    }
}
