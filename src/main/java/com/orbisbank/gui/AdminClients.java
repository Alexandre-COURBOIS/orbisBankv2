package com.orbisbank.gui;

import javax.swing.*;

import static java.awt.Color.black;
import static java.awt.Color.white;

public class AdminClients {
    private JPanel adminClients;
    private JPanel divLeft;
    private JButton utilisateursButton;
    private JButton commerciauxButton;
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
    private JLabel editLabel;
    private JLabel deleteLabel;
    private JLabel emailLabel;
    private JButton editButton;
    private JButton deleteButton;
    private JButton emailButton;
    private JPanel divContent;
    private JLabel name;
    private JLabel id;
    private JLabel phone;
    private JLabel postalcode;
    private JLabel adress;
    private JLabel city;
    private JLabel created_at;
    private JLabel updated_at;
    private JPanel divEdit;
    private JTextField surnameField;
    private JTextField nameField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField postalcodeField;
    private JTextField addressField;
    private JTextField cityField;
    private JTextField created_atField;
    private JLabel idLabel;
    private JLabel email;
    private JTextField updated_atField;

    public AdminClients() {
        utilisateursButton.setBackground(white);
        utilisateursButton.setForeground(black);
        utilisateursButton.setBorder(BorderFactory.createLineBorder(black));

        commerciauxButton.setBackground(white);
        commerciauxButton.setForeground(black);
        commerciauxButton.setBorder(BorderFactory.createLineBorder(black));

        clientsButton.setBackground(white);
        clientsButton.setForeground(black);
        clientsButton.setBorder(BorderFactory.createLineBorder(black));

        buttonLogout.setFocusPainted(false);
        buttonLogout.setBorder(null);
        editButton.setFocusPainted(false);
        editButton.setBorder(null);
        deleteButton.setFocusPainted(false);
        deleteButton.setBorder(null);
        emailButton.setFocusPainted(false);
        emailButton.setBorder(null);
    }

    String[] columns = new String[] {
      "ID", "Nom", "Prénom", "Birth"
    };

    public static void main(String[] args) {
        JFrame admin = new JFrame("AdminClients");
        admin.setContentPane(new AdminClients().adminClients);
        admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        admin.pack();
        admin.setVisible(true);
    }
}
