package com.mycompany.practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Sign_Up_Panel extends JPanel {

    private JTextField usernameField, emailAddressField, contactNumberField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private JButton btnRegister;

    public Sign_Up_Panel() {

        setLayout(new BorderLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(5, 10, 5, 10);

        JPanel center = new JPanel(new GridBagLayout());

        // Fields or user input
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        emailAddressField = new JTextField(20);
        contactNumberField = new JTextField(20);

        // TextField design
        usernameField.setFont(new Font("Arial", Font.PLAIN, 15));
        passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
        emailAddressField.setFont(new Font("Arial", Font.PLAIN, 15));
        contactNumberField.setFont(new Font("Arial", Font.PLAIN, 15));
        
        // Labels 
        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel emailAddressLabel = new JLabel("Email Address: ");
        emailAddressLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        JLabel contactNumberLabel = new JLabel("Contact Number: ");
        contactNumberLabel.setFont(new Font("Arial", Font.PLAIN, 15));

        showPassword = new JCheckBox("Show Password");
        showPassword.setFocusPainted(false);
        showPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        btnRegister = new JButton("Register");
        btnRegister.setFont(new Font("Roboto", Font.PLAIN, 14));
        btnRegister.setFocusPainted(false);
        btnRegister.setBackground(Color.decode("#7993D4"));
        btnRegister.setForeground(Color.WHITE);

        gbc.gridy = 0;
        center.add(usernameLabel, gbc);

        gbc.gridy = 1;
        center.add(usernameField, gbc);

        gbc.gridy = 2;
        center.add(passwordLabel, gbc
        );

        gbc.gridy = 3;
        center.add(passwordField, gbc);

        gbc.gridy = 4;
        center.add(emailAddressLabel, gbc);

        gbc.gridy = 5;
        center.add(emailAddressField, gbc);

        gbc.gridy = 6;
        center.add(contactNumberLabel, gbc);

        gbc.gridy = 7;
        center.add(contactNumberField, gbc);

        gbc.gridy = 8;
        center.add(showPassword, gbc);

        gbc.gridy = 9;
        center.add(btnRegister, gbc);

        JPanel northPanel = new JPanel();
        
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        northPanel.setBackground(Color.decode("#DFE3E4"));

        JLabel title = new JLabel("SIGN UP");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBackground(Color.BLACK);
        northPanel.add(title);
        
        add(northPanel, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        
        showPassword.addActionListener(e -> {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }
        });
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JTextField getEmailAddressField() {
        return emailAddressField;
    }

    public JTextField getContactNumberField() {
        return contactNumberField;
    }

    public JCheckBox getShowPassword() {
        return showPassword;
    }

    public JButton getRegisterButton() {
        return btnRegister;
    }
}