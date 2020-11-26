package com.orbisbank.gui;

import javax.swing.*;

public class Contact {
    private JLabel contactLabel;
    private JTextField sujetField;
    private JTextField emailDestinataireField;
    private JTextArea emailTextArea;
    private JButton emailButton;
    private JLabel messageLabel;
    private JPanel contactPanel;
    private JLabel sujetLabel;
    private JLabel labelDestinataire;


    public static void main(String[] args) {
        JFrame admin = new JFrame("Contact");
        admin.setContentPane(new Contact().contactPanel);
        admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        admin.pack();
        admin.setVisible(true);
        admin.setLocationRelativeTo(null);
    }
}
