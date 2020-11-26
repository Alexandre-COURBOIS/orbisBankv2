package com.orbisbank.controller;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.dao.impl.SecurityDao;
import com.orbisbank.model.Clients;

import java.sql.SQLException;
import java.util.ArrayList;


public class ClientsController {

    private Clients clients;

    public static void main(String[] args) throws SQLException {
        setClients("Pierre","Alex","pierroalex@gmail.com","0666666666", 76000, "23 rue des bg","Rouen" );
    }

    public void newClients() throws SQLException {
        DaoFactory.getClientsDao().createClients(clients);
    }

    public static void setClients(String surname, String name, String email, String phone, int postalCode, String Address, String city) throws SQLException {

        Clients client = new Clients();
        SecurityDao security = new SecurityDao();

        java.util.Date date_util = new java.util.Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

        client.setSurname(surname);
        client.setName(name);
        client.setEmail(email);
        client.setPhone(phone);
        client.setPostalCode(postalCode);
        client.setAddress(Address);
        client.setCity(city);
        client.setCreated_at(date_sql);

        DaoFactory.getClientsDao().createClients(client);

    }

    public static void getAllClients() throws SQLException {
        ArrayList<Clients> clients = DaoFactory.getClientsDao().getAllClients();
        clients.forEach(System.out::println);
    }

    public static void getClientById(int clientsId) throws SQLException {
        System.out.println(DaoFactory.getClientsDao().getClientsById(clientsId));
    }

    public static void getClientByEmail(String email) throws SQLException {
        System.out.println(DaoFactory.getClientsDao().getClientsByEmail(email));
    }

    public static void deleteClientById (int clientsId) throws SQLException {
        System.out.println(DaoFactory.getClientsDao().deleteClientsById(clientsId));
    }

}
