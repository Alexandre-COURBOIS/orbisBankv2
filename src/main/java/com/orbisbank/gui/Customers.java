package com.orbisbank.gui;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.model.Clients;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
                "Id", "Nom", "Prénom", "Email", "Téléphone", "Age", "Revenu", "Propriétaire", "Adresse"
        };

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };

        for (Clients customer : customers) {

            String owner;

            if (customer.isOwner()) {
                owner = "oui";
            } else {
                owner = "non";
            }

            String address = customer.getAddress() + ' ' + customer.getPostalCode() + ' ' + customer.getCity();

            Object[] data = {

                    customer.getClientsId(),
                    customer.getName(),
                    customer.getSurname(),
                    customer.getEmail(),
                    customer.getPhone(),
                    customer.getAge(),
                    customer.getIncome(),
                    owner,
                    address

            };
            tableModel.addRow(data);
        }


        JTable myTable = new JTable(tableModel);
        myTable.setPreferredScrollableViewportSize(new Dimension(400, 100));

        TableColumn colId = myTable.getColumnModel().getColumn(0);
        colId.setPreferredWidth(10);
        colId.setResizable(false);

        TableColumn colName = myTable.getColumnModel().getColumn(1);
        colName.setPreferredWidth(25);
        colName.setResizable(false);

        TableColumn colSurname = myTable.getColumnModel().getColumn(2);
        colSurname.setPreferredWidth(25);
        colSurname.setResizable(false);

        TableColumn colEmail = myTable.getColumnModel().getColumn(3);
        colEmail.setPreferredWidth(100);
        colEmail.setResizable(true);

        TableColumn colPhone = myTable.getColumnModel().getColumn(4);
        colPhone.setPreferredWidth(35);
        colPhone.setResizable(false);

        TableColumn colAge = myTable.getColumnModel().getColumn(5);
        colAge.setPreferredWidth(10);
        colAge.setResizable(false);

        TableColumn colIncome = myTable.getColumnModel().getColumn(6);
        colIncome.setPreferredWidth(15);
        colId.setResizable(false);

        TableColumn colOwner = myTable.getColumnModel().getColumn(7);
        colOwner.setPreferredWidth(10);
        colOwner.setResizable(false);

        TableColumn colAddress = myTable.getColumnModel().getColumn(8);
        colAddress.setPreferredWidth(175);
        colAddress.setResizable(true);


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

        myTable.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = myTable.getSelectedRow();

                Object objId = GetData(myTable, row, 0);
                Object objSurname = GetData(myTable, row, 1);
                Object objName = GetData(myTable, row, 2);
                Object objEmail = GetData(myTable, row, 3);
                Object objPhone = GetData(myTable,row,4);
                Object objAge = GetData(myTable,row,5);
                Object objIncome = GetData(myTable, row, 6);
                Object objOwner = GetData(myTable, row, 7);
                Object objAddress = GetData(myTable, row,8);

                String userId = objId.toString();
                String userSurname = objSurname.toString();
                String userName = objName.toString();
                String userEmail = objEmail.toString();
                String userPhone = objPhone.toString();
                String userAge = objAge.toString();
                String userIncome = objIncome.toString();
                String userOwner = objOwner.toString();
                String userAdress = objAddress.toString();

                nameCustomers.setText(userSurname + " - " + userName);
                emailCustomers.setText(userEmail + " - " + userPhone);
                addressCustomers.setText(userAdress);

            }
        });
    }

    public Object GetData(JTable table, int row_index, int col_index) {
        return table.getModel().getValueAt(row_index, col_index);
    }

    public static void main(String[] args) throws SQLException {
        JFrame clients = new JFrame("Clients");
        clients.setContentPane(new Customers().clientsPanel);
        clients.pack();
        clients.setVisible(true);


    }


}
