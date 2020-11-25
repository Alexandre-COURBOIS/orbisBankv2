package com.orbisbank.gui;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.model.Users;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.awt.Color.*;


public class Admin extends JFrame {
    private JPanel adminPanel;
    private JPanel divLeft;
    private JPanel divRight;
    private JPanel divTitle;
    private JPanel divUser;
    private JPanel divContent;
    private JButton utilisateursButton;
    private JButton commerciauxButton;
    private JButton clientsButton;
    private JPanel divLogoTop;
    private JLabel titleAdmin;
    private JButton buttonLogout;
    private JPanel divPhoto;
    private JPanel divName;
    private JPanel divEdit;
    private JPanel divId;
    private JLabel photo;
    private JLabel name;
    private JLabel stats;
    private JLabel edit;
    private JLabel delete;
    private JLabel contact;
    private JLabel id;
    private JPanel Log;
    private JLabel log;
    private JPanel ButtonLogout;
    private JPanel TitleAdmin;
    private JButton buttonEdit;
    private JButton buttonDelete;
    private JButton buttonMail;
    private JTextField textField1;
    private JTextField textField2;
    private JScrollPane scrollPane;
    private JScrollPane scrollClients;
    private JTextField searchCommerciaux;
    private JScrollPane scrollContrats;
    private JLabel IDClient;
    private JLabel nomClient;
    private JLabel prenomClient;

    public Admin() throws SQLException {
        utilisateursButton.setBackground(white);
        utilisateursButton.setForeground(black);
        utilisateursButton.setBorder(BorderFactory.createLineBorder(black));

        commerciauxButton.setBackground(white);
        commerciauxButton.setForeground(black);
        commerciauxButton.setBorder(BorderFactory.createLineBorder(black));

        clientsButton.setBackground(white);
        clientsButton.setForeground(black);
        clientsButton.setBorder(BorderFactory.createLineBorder(black));

        buttonLogout.setFocusPainted(false);
        buttonLogout.setBorder(null);
        buttonEdit.setFocusPainted(false);
        buttonEdit.setBorder(null);
        buttonDelete.setFocusPainted(false);
        buttonDelete.setBorder(null);
        buttonMail.setFocusPainted(false);
        buttonMail.setBorder(null);


        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ArrayList<Users> users = DaoFactory.getUsersDao().getAllUsers();

        String[] columns = new String[]{
                "Id", "Name", "Surname", "Email",
        };

        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        for (Users user : users) {
            Object[] data = {user.getUsers_id(), user.getUsers_name(), user.getUsers_surname(), user.getUsers_email()};
            tableModel.addRow(data);
        }


        JTable myTable = new JTable(tableModel);

        myTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
        scrollPane.setViewportView(myTable);


        ArrayList objs = new ArrayList();

        myTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = myTable.getSelectedRow();
                int column = myTable.getColumnCount();

                for (int i = 0; i < column; i++ ) {

                    String value = "" + myTable.getValueAt(row, i).toString();

                    System.out.println(value);
                }


/*                Object[] val = new Object[column];
                for (int k = 0; k < val.length - 1; k++) {
                    for (int j = 0; j < row; j++) {
                        for (int i = 0; i < column; i++) {
                        val[k] = myTable.getValueAt(j,i);
                            System.out.println(val[k]);
                        }
                    }
                }*/

            }
        });

    }


    public static void main(String[] args) throws SQLException {
        JFrame admin = new JFrame("Admin");
        admin.setContentPane(new Admin().adminPanel);
        admin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        admin.pack();
        admin.setVisible(true);
    }

    public JPanel getAdminPanel() {
        return adminPanel;
    }
}
