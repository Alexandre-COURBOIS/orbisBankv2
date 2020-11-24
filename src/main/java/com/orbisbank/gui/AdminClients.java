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
    private JPanel divPhoto;
    private JPanel divName;
    private JLabel name;
    private JLabel stats;
    private JPanel divEdit;
    private JLabel edit;
    private JLabel delete;
    private JLabel contact;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JPanel divContent;

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
        button1.setFocusPainted(false);
        button1.setBorder(null);
        button2.setFocusPainted(false);
        button2.setBorder(null);
        button3.setFocusPainted(false);
        button3.setBorder(null);
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
