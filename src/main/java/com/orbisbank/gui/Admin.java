package com.orbisbank.gui;

import javax.swing.*;
import static java.awt.Color.*;


public class Admin extends JFrame {
    private JPanel adminPanel;
    private JPanel divLeft;
    private JPanel divRight;
    private JPanel divTitle;
    private JPanel divUser;
    private JPanel divContent;
    private JButton utilisateursButton;
    private JButton commerciauxButton;
    private JButton clientsButton;
    private JPanel divLogoTop;
    private JLabel titleAdmin;
    private JButton buttonLogout;
    private JPanel divPhoto;
    private JPanel divName;
    private JPanel divEdit;
    private JPanel divId;
    private JLabel photo;
    private JLabel name;
    private JLabel stats;
    private JLabel edit;
    private JLabel delete;
    private JLabel contact;
    private JLabel id;
    private JPanel Log;
    private JLabel log;
    private JPanel ButtonLogout;
    private JPanel TitleAdmin;
    private JButton buttonEdit;
    private JButton buttonDelete;
    private JButton buttonEmail;
    private JTextField searchCommerciaux;
    private JScrollPane scrollCommerciaux;
    private JScrollPane scrollContrats;
    private JLabel IDClient;
    private JLabel nomClient;
    private JLabel prenomClient;
    private JScrollPane scrollClients;

    public Admin() {
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
        buttonEdit.setFocusPainted(false);
        buttonEdit.setBorder(null);
        buttonDelete.setFocusPainted(false);
        buttonDelete.setBorder(null);
        buttonEmail.setFocusPainted(false);
        buttonEmail.setBorder(null);
    }

    public static void main(String[] args) {
        JFrame admin = new JFrame("Admin");
        admin.setContentPane(new Admin().adminPanel);
        admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        admin.pack();
        admin.setVisible(true);
    }
}
