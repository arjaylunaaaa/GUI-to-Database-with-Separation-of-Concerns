package com.mycompany.myproject;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.mindrot.jbcrypt.BCrypt;

public class Login_Frame extends JFrame {

    private Login_Panel login;
    private UserController controller = new UserController();
    private User user;

    public Login_Frame() {
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
            setUpAction();
        });
    }

    private void setUpAction() {

        String username = login.getUsernameField().getText();
        String password = new String(login.getPasswordField().getPassword());

        User user = new User(username, password);

        String result = controller.login(user);

        if (result.equals("SUCCESS")) {
            JOptionPane.showMessageDialog(this, "Login successfully!");
        } else {
            JOptionPane.showMessageDialog(this, result);
        }
    }
}
