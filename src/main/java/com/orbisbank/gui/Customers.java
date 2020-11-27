package com.orbisbank.gui;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.model.Clients;
import com.orbisbank.model.Contract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

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
    private JButton offresÀProposerButton;

    public Customers(JFrame frame) throws SQLException {

        Date date_util = new Date();
        java.sql.Date date_sql = new java.sql.Date(date_util.getTime());

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

        contractSelect.addItem("--- Offres ---");
        contractSelect.addItem("Compte courant");
        contractSelect.addItem("Livret jeune");
        contractSelect.addItem("Livret A");
        contractSelect.addItem("PEL");
        contractSelect.addItem("Assurance vie");
        contractSelect.addItem("Credit conso");
        contractSelect.addItem("Credit immo");
        contractSelect.addItem("Credit auto");
        contractSelect.addItem("Credit etudiant");

        myTable.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = myTable.getSelectedRow();

                Object objId = GetData(myTable, row, 0);
                Object objSurname = GetData(myTable, row, 1);
                Object objName = GetData(myTable, row, 2);
                Object objEmail = GetData(myTable, row, 3);
                Object objPhone = GetData(myTable, row, 4);
                Object objAge = GetData(myTable, row, 5);
                Object objIncome = GetData(myTable, row, 6);
                Object objOwner = GetData(myTable, row, 7);
                Object objAddress = GetData(myTable, row, 8);

                String userId = objId.toString();
                int requestId = Integer.parseInt(userId);

                String userSurname = objSurname.toString();
                String userName = objName.toString();
                String userEmail = objEmail.toString();
                String userPhone = objPhone.toString();
                String userAge = objAge.toString();
                String userIncome = objIncome.toString();
                String userOwner = objOwner.toString();
                String userAdress = objAddress.toString();


                try {
                    ArrayList<Contract> contracts = DaoFactory.getContractDao().getContractByClientId(requestId);

                    StringBuilder list = new StringBuilder();
                    for (Contract contract : contracts) {

                        list.append(contract.getContract()).append("  ");
                    }

                    contractCustomers.setText(String.valueOf(list));

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

                nameCustomers.setText(userSurname + " - " + userName);
                emailCustomers.setText(userEmail + " - " + userPhone);
                addressCustomers.setText(userAdress);

                contacterButtonMenu.setText("Contacter " + userName);
                offresButtonMenu.setText("Offres pour " + userName);

            }
        });

        addContractButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object item = contractSelect.getSelectedItem();

                if (item != null && item != "" && item != "--- Offres ---") {
                    try {

                        int row = myTable.getSelectedRow();

                        Object objId = GetData(myTable, row, 0);

                        String userId = objId.toString();
                        int requestId = Integer.parseInt(userId);

                        Contract contract = new Contract();

                        contract.setClient_id(requestId);
                        contract.setContract((String) item);
                        contract.setCreated_at(date_sql);

                        DaoFactory.getContractDao().createContract(contract);

                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Merci saisir une offre");
                }
            }
        });

        deconnexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(frame);
                frame.setContentPane(login.getLoginPanel());
                frame.pack();
                frame.setVisible(true);
                frame.setTitle("Login");

            }
        });

        contacterButtonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int row = myTable.getSelectedRow();

                if (row != 1) {

                    String userMail = (String) GetData(myTable, row, 3);

                    JFrame frame = new JFrame("Envoyer un mail");

                    frame.setContentPane(new Contact(frame, userMail).getContactPanel());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);

                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur");
                }
            }
        });
        offresÀProposerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = myTable.getSelectedRow();

                if (row != -1) {

                    int userId = (int) GetData(myTable, row, 0);

                    JFrame frame = new JFrame("Offres conseillées");

                    frame.setContentPane(new CustomerOffer(userId).getCustomerOfferPanel());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur");
                }
            }
        });
        offresButtonMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = myTable.getSelectedRow();

                if (row != -1) {

                    int userId = (int) GetData(myTable, row, 0);

                    JFrame frame = new JFrame("Offres conseillées");

                    frame.setContentPane(new CustomerOffer(userId).getCustomerOfferPanel());
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Veuillez sélectionner un utilisateur");
                }
            }
        });
    }

    public Object GetData(JTable table, int row_index, int col_index) {
        return table.getModel().getValueAt(row_index, col_index);
    }

    public JPanel getClientsPanel() {
        return clientsPanel;
    }
}
