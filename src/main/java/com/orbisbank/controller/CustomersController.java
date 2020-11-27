package com.orbisbank.controller;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.model.Clients;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomersController {

    public void getPersonalizedOffers(int customerId) {

        try {
            Clients customer = DaoFactory.getClientsDao().getClientsById(customerId);

            int age = customer.getAge();
            int income = customer.getIncome();
            boolean owner = customer.isOwner();

            ArrayList<String> personalizedOffers = new ArrayList<>();

            if(age > 60) {
                personalizedOffers.add("Assurance Vie");
            } else if(income >= 30000) {
                if(!owner) {
                    personalizedOffers.add("Crédit Immobilier");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
