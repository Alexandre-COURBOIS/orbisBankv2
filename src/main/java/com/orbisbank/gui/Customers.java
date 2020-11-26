package com.orbisbank.gui;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.model.Clients;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Customers extends JFrame {
    private JPanel clientsPanel;
    private JPanel leftMenu;
    private JPanel screenRight;
    private JPanel screenRightTop;
    private JPanel screenRightBottom;
    private JPanel screenRightMiddle;
    private JLabel logoMenu;
    private JButton contacterButtonMenu;
    private JButton offresButtonMenu;
    private JButton clientsButtonMenu;
    private JButton deconnexionButton;
    private JTextField searchTextField;
    private JButton searchButton;
    private JLabel titlePanel;
    private JTable table1;
    private JScrollPane scrollPane;
    private JPanel divName;
    private JPanel divInformation;
    private JPanel divSearch;
    private JLabel nameCustomers;
    private JLabel emailCustomers;
    private JLabel addressCustomers;
    private JLabel contractCustomers;
    private JComboBox contractSelect;
    private JButton addContractButton;

    public Customers() throws SQLException {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ArrayList<Clients> customers = DaoFactory.getClientsDao().getAllClients();

        String[] columns = new String[]{
                "Id", "Nom", "Prénom", "Email", "Téléphone", "Adresse"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columns,0);

        for (Clients customer:customers) {
            String address = customer.getAddress()+' '+customer.getPostalCode()+' '+customer.getCity();
            Object[] data = {
                    customer.getClientsId(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getEmail(),
                    customer.getPhone(),
                    address
            };
            tableModel.addRow(data);
        }

        JTable myTable = new JTable(tableModel);
        myTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
        scrollPane.setViewportView(myTable);

        contractSelect.addItem("Compte courant");
        contractSelect.addItem("Livret jeune");
        contractSelect.addItem("Livret A");
        contractSelect.addItem("PEL");
        contractSelect.addItem("Assurance vie");
        contractSelect.addItem("Crédit conso");
        contractSelect.addItem("Crédit immo");
        contractSelect.addItem("Crédit auto");
        contractSelect.addItem("Crédit étudiant");


    }


    public static void main(String[] args) throws SQLException {
        JFrame clients = new JFrame("Clients");
        clients.setContentPane(new Customers().clientsPanel);
        clients.pack();
        clients.setVisible(true);




    }


}
