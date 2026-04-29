package com.mycompany.myproject;

import javax.swing.JOptionPane;

public class UserController {

    private UserDAO DATA_ACCESS_OBJECT = new UserDAO();

    public String register(User user) {

        if (user.getUsername().isEmpty()
                || user.getPassword().isEmpty()
                || user.getEmailAddress().isEmpty()
                || user.getContactNumber().isEmpty()) {
            return "Please fill up all fields!";
        }

        if (DATA_ACCESS_OBJECT.userExists(user.getUsername())) {
            return "User already exist!";
        }

        if (DATA_ACCESS_OBJECT.register(user)) {
            return "SUCCESS";
        }

        return "Error to create account";
    }

    public String login(User user) {
        if (user.getUsername().isEmpty()) {
            return "Username field is empty!";
        }
        if (user.getPassword().isEmpty()) {
            return "Password field is empty!";
        }
        
        if(DATA_ACCESS_OBJECT.login(user)){
            return "SUCCESS";
        }
        
        return "Failed to login!";
    }
}
