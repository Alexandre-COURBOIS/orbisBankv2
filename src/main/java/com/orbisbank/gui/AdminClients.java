package com.orbisbank.gui;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.model.Users;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.awt.Color.black;
import static java.awt.Color.white;

public class AdminClients {

    private JPanel adminClients;
    private JPanel divLeft;
    private JButton utilisateursButton;
    private JButton clientsButton;
    private JPanel divLogoTop;
    private JPanel divRight;
    private JPanel divTitle;
    private JPanel Log;
    private JLabel log;
    private JPanel ButtonLogout;
    private JButton buttonLogout;
    private JPanel TitleAdmin;
    private JLabel titleAdmin;
    private JPanel divUser;
    private JPanel divH2;
    private JPanel divLabels;
    private JLabel surname;
    private JPanel divButtons;
    private JButton editButton;
    private JButton validateButton;
    private JButton emailButton;
    private JPanel divContent;
    private JLabel name;
    private JLabel id;
    private JLabel created_at;
    private JLabel updated_at;
    private JPanel divEdit;
    private JTextField nameField;
    private JTextField surnameField;
    private JTextField emailField;
    private JLabel created_atField;
    private JLabel idLabel;
    private JLabel email;
    private JLabel updated_atField;
    private JLabel password;
    private JTextField newPassword;
    private JLabel passwordValidate;
    private JTextField validateNewPassword;
    private JButton validerButton;

    public AdminClients(JFrame frame, int id) throws SQLException {
        utilisateursButton.setBackground(white);
        utilisateursButton.setForeground(black);
        utilisateursButton.setBorder(BorderFactory.createLineBorder(black));

        clientsButton.setBackground(white);
        clientsButton.setForeground(black);
        clientsButton.setBorder(BorderFactory.createLineBorder(black));

        buttonLogout.setFocusPainted(false);
        buttonLogout.setBorder(null);
        validateButton.setFocusPainted(false);
        validateButton.setBorder(null);

        Users user = DaoFactory.getUsersDao().getUsersById(id);
        System.out.println(user);

        int userId = user.getUsers_id();

        Date date = user.getCreated_at();
        DateFormat dateFormat = new SimpleDateFormat("yyy-mm-dd");
        String strDate = dateFormat.format(date);

        idLabel.setText(String.valueOf(userId));
        nameField.setText(user.getUsers_name());
        surnameField.setText(user.getUsers_surname());
        emailField.setText(user.getUsers_email());
        created_atField.setText(strDate);
        updated_atField.setText("Ce champ n'est pas renseigné pour cette utilisateur");

        validateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    Date date_util = new Date();
                    java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

                    String newSurname = surnameField.getText();
                    String newName = nameField.getText();
                    String newEmail = emailField.getText();

                    Users user = new Users();


                    user.setUsers_name(newName);
                    user.setUsers_surname(newSurname);
                    user.setUsers_email(newEmail);
                    user.setUpdated_at(date_sql);
                    user.setUsers_id(userId);

                    DaoFactory.getUsersDao().update(user);
                    System.out.println("user updated :D");
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

    }


    public static void main(String[] args) {

        JFrame frame = new JFrame("Modifier l'utilisateur");

        try {

            frame.setContentPane(new AdminClients(frame, 11).getAdminClients());
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public JPanel getAdminClients() {
        return adminClients;
    }

}


