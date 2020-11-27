package com.orbisbank.gui;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.model.Clients;


import javax.swing.*;
import java.sql.SQLException;

public class InformationsClient {
    private JPanel InformationsClientPanel;
    private JLabel clientInformationsLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel addressLabel;
    private JLabel phoneLabel;
    private JLabel emailLabel;

    InformationsClient(JFrame frame, int userId) {

        try {
            Clients client = DaoFactory.getClientsDao().getClientsById(userId);

            String name = client.getName();
            String surname = client.getSurname();
            String address = client.getAddress() + " " + client.getPostalCode() + " " + client.getCity();
            String phone = client.getPhone();
            String email = client.getEmail();

            clientInformationsLabel.setText("Informations à propos de :  " + surname);

            nameLabel.setText(name);
            surnameLabel.setText(surname);
            addressLabel.setText(address);
            phoneLabel.setText(phone);
            emailLabel.setText(email);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public JPanel getInformationsClientPanel() {
        return InformationsClientPanel;
    }
}
