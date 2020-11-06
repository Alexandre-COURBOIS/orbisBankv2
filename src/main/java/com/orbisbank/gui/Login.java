package com.orbisbank.gui;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.dao.UsersDao;
import com.orbisbank.dao.impl.*;
import com.orbisbank.model.Users;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    private JPanel loginPanel;
    private JTextField emailTextField;
    private JTextField passwordTextField;
    private JLabel passwordLabel;
    private JButton loginButton;
    private JLabel emailLabel;

    public Login(JFrame frame) {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Users user = new Users();
                SecurityDao hash = new SecurityDao();

                String email = emailTextField.getText();
                String password = passwordTextField.getText();

                try {
                    user = DaoFactory.getUsersDao().getUsersByEmail(email);
                    if (hash.hashPassword(password).equals(user.getPassword())) {
                        System.out.println(" Hello " + user.getUsers_surname() + " " + user.getUsers_name());
                        JOptionPane.showMessageDialog(loginPanel, " Hello " + user.getUsers_surname() + " " + user.getUsers_name());
                        Register reg = new Register();
                        frame.setContentPane(reg.getRegister_panel());
                        frame.pack();
                        frame.setVisible(true);
                    } else {
                        System.out.println("Wrong email or password");
                        JOptionPane.showMessageDialog(loginPanel, "Wrong email or password");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login(frame).loginPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
