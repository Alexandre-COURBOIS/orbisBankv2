package com.orbisbank.gui;

import com.orbisbank.model.Users;
import com.orbisbank.dao.impl.SecurityDao;
import com.orbisbank.dao.DaoFactory;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Register {

    private JPanel register_panel;
    private JTextField nameTextField;
    private JTextField surnameTextField;
    private JTextField emailTextField;
    private JPasswordField passwordTextField;
    private JButton registerButton;
    private JLabel logo_orbisbank;
    private JPanel logo;
    private JPanel form_register;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel emailLabel;
    private JLabel passwordLabel;
    private JPanel submit_form_register;
    private JLabel confimPasswordLabel;
    private JPasswordField confirmPasswordTextField;

    public Register() {

        registerButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                SecurityDao hash = new SecurityDao();
                Users user = new Users();

                Date date_util = new Date();
                java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

                String name = nameTextField.getText();
                String surname = surnameTextField.getText();
                String email = emailTextField.getText();
                String password = passwordTextField.getText();
                String password_verify = confirmPasswordTextField.getText();

                if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || password.isEmpty() || password_verify.isEmpty()) {
                    JOptionPane.showMessageDialog(register_panel, "Complete each text field please");
                } else {
                    String passwordEncoded = hash.hashPassword(password);
                    String passwordVerifyEncoded = hash.hashPassword(password_verify);

                    user.setUsers_name(name);
                    user.setUsers_surname(surname);
                    user.setUsers_email(email);
                    user.setPassword(hash.hashPassword(password));
                    user.setCreated_at(date_sql);

                    if (passwordEncoded.equals(passwordVerifyEncoded)) {
                        try {

                            DaoFactory.getUsersDao().createUsers(user);

                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        passwordLabel.setText("Les mots de passe ne correspondent pas.");
                    }
                }
            }
        });
    }


    public JPanel getRegister_panel() {
        return register_panel;
    }

}


