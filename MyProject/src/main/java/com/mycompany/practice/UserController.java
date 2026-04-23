package com.mycompany.practice;

public class UserController {

    private UserDAO DATA_ACCESS_OBJECT = new UserDAO();

    public String register(User user) {

        if (user.getUsername().isEmpty() || user.getPassword().isEmpty()
                || user.getEmailAddress().isEmpty() || user.getContactNumber().isEmpty()) {
            return "Please fill up all fields!";
        }
        
        if(DATA_ACCESS_OBJECT.userExists(user.getUsername())){
            return "Username already exist!";
        }
        
        if(DATA_ACCESS_OBJECT.register(user)){
           return "SUCCESS"; 
        }
        return "Error creating account!";
    }
    
}