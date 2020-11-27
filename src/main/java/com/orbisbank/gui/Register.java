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

    public Register(JFrame frame) {

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
                char[] password = passwordTextField.getPassword();
                char[] password_verify = confirmPasswordTextField.getPassword();

                String StrPassword = String.valueOf(password);
                String StrNewPassword = String.valueOf(password_verify);

                if (name.isEmpty() || surname.isEmpty() || email.isEmpty() || StrPassword.isEmpty() || StrNewPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(register_panel, "Complete each text field please");

                } else {
                    String passwordEncoded = hash.hashPassword(StrPassword);
                    String passwordVerifyEncoded = hash.hashPassword(StrNewPassword);

                    user.setUsers_name(name);
                    user.setUsers_surname(surname);
                    user.setUsers_email(email);
                    user.setPassword(hash.hashPassword(StrPassword));
                    user.setCreated_at(date_sql);
                    user.setRole("banque");

                    if (passwordEncoded.equals(passwordVerifyEncoded)) {
                        try {
                            int result = JOptionPane.showConfirmDialog(null, "Vous êtes sur le point de créer un nouvel utilisateur êtes-vous sûr ?", "Nouvel utilisateur", JOptionPane.YES_NO_CANCEL_OPTION);

                            if (result == JOptionPane.YES_OPTION) {
                                DaoFactory.getUsersDao().createUsers(user);
                                JOptionPane.showMessageDialog(null, "L'utilisateur a bien été ajouté");
                                frame.dispose();
                            }

                        } catch (Exception throwables) {
                            throwables.printStackTrace();
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


