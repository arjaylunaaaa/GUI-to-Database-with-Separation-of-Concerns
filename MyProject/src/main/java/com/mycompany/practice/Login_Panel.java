package com.mycompany.practice;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Login_Panel extends JPanel {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPassword;
    private JButton btnLogin, btnRegister;

    public Login_Panel() {

        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(400, 400));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(4, 10, 4, 10);

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setFont(new Font("Sans Seriff", Font.PLAIN, 15));
        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setFont(new Font("Sans Seriff", Font.PLAIN, 15));
        JLabel title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.BOLD, 24));

        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);

        showPassword = new JCheckBox("Show Password");
        showPassword.setFocusPainted(false);

        btnLogin = new JButton("Login");
        btnLogin.setFocusPainted(false);
        btnLogin.setBackground(Color.decode("#7993D4"));
        btnLogin.setForeground(Color.WHITE);

        btnRegister = new JButton("Sign Up");
        btnRegister.setFocusPainted(false);
        btnRegister.setBackground(Color.RED);
        btnRegister.setForeground(Color.WHITE);

        JPanel north = new JPanel();
        north.setLayout(new FlowLayout(FlowLayout.CENTER));
        north.add(title);

        JPanel center = new JPanel();
        center.setLayout(new GridBagLayout());

        gbc.gridy = 0;
        center.add(usernameLabel, gbc);

        gbc.gridy = 1;
        center.add(usernameField, gbc);

        gbc.gridy = 2;
        center.add(passwordLabel, gbc);

        gbc.gridy = 3;
        center.add(passwordField, gbc);

        gbc.gridy = 4;
        center.add(showPassword, gbc);

        gbc.gridy = 5;
        center.add(btnLogin, gbc);

        gbc.gridy = 6;
        center.add(btnRegister, gbc);

        add(north, BorderLayout.NORTH);
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

    public JButton getLoginBtn() {
        return btnLogin;
    }

    public JButton getRegisterBtn() {
        return btnRegister;
    }
}