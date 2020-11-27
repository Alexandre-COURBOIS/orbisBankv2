package com.orbisbank.gui;

import com.orbisbank.controller.CustomersController;

import javax.swing.*;
import java.util.ArrayList;

public class CustomerOffer {
    private JPanel customerOfferPanel;
    private JLabel offerLabel;
    private JLabel offerListLabel;
    private JLabel offerTitleLabel;


    public CustomerOffer (int userId) {

        CustomersController controller = new CustomersController();

        ArrayList<String> personalizedOffers = controller.getPersonalizedOffers(userId);

        System.out.println(personalizedOffers.toString());

        StringBuilder listOffers = new StringBuilder();

        for(String offer : personalizedOffers) {
            listOffers.append(offer).append(" ");
        }
        offerListLabel.setText(String.valueOf(listOffers));

    }

    public JPanel getCustomerOfferPanel() {
        return customerOfferPanel;
    }
}
