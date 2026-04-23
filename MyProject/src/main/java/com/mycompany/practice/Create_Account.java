package com.mycompany.practice;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Create_Account extends JFrame {
    
    private Sign_Up_Panel signUp;
    private UserController controller = new UserController();
    private User user;
    
    public Create_Account() {
        
        setSize(350, 400);
        setTitle("Create Account");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        signUp = new Sign_Up_Panel();
        add(signUp, BorderLayout.CENTER);
        
        getRootPane().setDefaultButton(signUp.getRegisterButton());
        signUp.getRegisterButton().addActionListener(e -> {
            setUpAction();
        });
    }
    
    private void setUpAction() {
        
        String username = signUp.getUsernameField().getText();
        String password = new String(signUp.getPasswordField().getPassword());
        String email_address = signUp.getEmailAddressField().getText();
        String contact_number = signUp.getContactNumberField().getText();
        
        User user = new User(username, password, email_address, contact_number);
        
        String result = controller.register(user);
        
        if (result.equals("SUCCESS")) {
            JOptionPane.showMessageDialog(this, "Account successfully created!");
            dispose();
            new Login().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, result);
        }
        
    }
}