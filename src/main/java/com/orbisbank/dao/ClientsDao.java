package com.orbisbank.dao;

import com.orbisbank.model.Clients;

import java.util.ArrayList;
public interface ClientsDao {

    public void createClients(Clients clients);
    public ArrayList<Clients> getAllClients();
    public Clients getClientsById(int clientsId);
    public Clients getClientsByEmail(String clientsEmail);
    public boolean deleteClientsById(int clientsId);

}
