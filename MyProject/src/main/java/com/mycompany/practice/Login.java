package com.mycompany.practice;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

public class Login extends JFrame {

    private Login_Panel login;

    public Login() {
        setSize(1200, 800);
        setTitle("Login");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        getContentPane().setBackground(Color.decode("#AACDDC"));

        login = new Login_Panel();
        add(login);

        getRootPane().setDefaultButton(login.getLoginBtn());

        login.getRegisterBtn().addActionListener(e -> {
            dispose();
            new Create_Account().setVisible(true);
        });

        login.getLoginBtn().addActionListener(e -> {
            if (login()) {
                JOptionPane.showMessageDialog(this, "Login successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Wrong credentials.");
                login.getUsernameField().setText("");
                login.getPasswordField().setText("");
            }
        });
    }

    private boolean login() {

        String username = login.getUsernameField().getText();
        char[] passwordChar = login.getPasswordField().getPassword();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username field is empty!");
            return false;
        }

        if (passwordChar.length == 0) {
            JOptionPane.showMessageDialog(this, "Password field is empty!");
            return false;
        }

        Connection connection = DBConnection.getConnection();
        if (connection != null) {
            System.out.println("Connected");
        }

        String sql = "SELECT * FROM users WHERE username = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String check = rs.getString("Password");
                String inputPassword = new String(passwordChar);

                if (BCrypt.checkpw(inputPassword, check)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }
}
