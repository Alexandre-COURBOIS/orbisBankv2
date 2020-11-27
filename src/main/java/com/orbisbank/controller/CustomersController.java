package com.orbisbank.controller;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.model.Clients;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomersController {

    private final String compteCourant = "Compte courant";
    private final String livretJeune = "Livret jeune";
    private final String livretA = " Livret A";
    private final String pel = "PEL";
    private final String assuranceVie = "Assurance vie";
    private final String creditConso = "Credit conso";
    private final String creditImmo = "Credit immo";
    private final String creditAuto = "Credit auto";
    private final String creditEtudiant = "Credit etudiant";


    public ArrayList<String> getPersonalizedOffers(int customerId) {

        try {
            Clients customer = DaoFactory.getClientsDao().getClientsById(customerId);

            int age = customer.getAge();
            int income = customer.getIncome();
            boolean owner = customer.isOwner();

            ArrayList<String> personalizedOffers = new ArrayList<>();

            if(age > 60) {
                personalizedOffers.add(assuranceVie);
            } else if(income >= 30000) {
                if(!owner) {
                    personalizedOffers.add(creditImmo);
                    if(!getCustomersContract(customerId, pel)) {
                        personalizedOffers.add(pel);
                    }
                }
               personalizedOffers.add(creditAuto);
            } else if(customer.getAge() < 30) {
                if(customer.getAge() > 18) {
                    personalizedOffers.add(creditEtudiant);
                }
                if(customer.getAge() < 25) {
                    if(!getCustomersContract(customerId, livretJeune)) {
                        personalizedOffers.add(livretJeune);
                    }
                }
                personalizedOffers.add(livretA);
            } else {
                if(customer.getIncome() <= 20000) {
                    personalizedOffers.add(creditConso);
                }
                personalizedOffers.add(livretA);
            }

            return personalizedOffers;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }

    public boolean getCustomersContract(int customerId, String contractName) {
        try {
            return DaoFactory.getContractDao().getAllContractByName(customerId, contractName);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

}
