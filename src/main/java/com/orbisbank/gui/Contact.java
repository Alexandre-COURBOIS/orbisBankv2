package com.orbisbank.gui;

import com.orbisbank.controller.MailController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public Contact(JFrame frame, String email) {

        emailDestinataireField.setText(email);

        emailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String emailTo = emailDestinataireField.getText();
                String subject = sujetField.getText();
                String content = emailTextArea.getText();

                if(!emailTo.isEmpty() && !subject.isEmpty() && !content.isEmpty()) {

                    MailController mail = new MailController();

                    mail.sendEmailTo(emailTo, subject, content);

                    frame.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
                }
            }
        });
    }

    public JPanel getContactPanel() {
        return contactPanel;
    }
}
