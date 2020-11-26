package com.orbisbank.gui;

import com.orbisbank.dao.DaoFactory;
import com.orbisbank.dao.impl.UsersDaoJdbc;
import com.orbisbank.model.Users;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private JLabel email;
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

    public Admin(JFrame frame) throws SQLException {
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


        JTable usersTable = new JTable(tableModel);

        usersTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
        scrollPane.setViewportView(usersTable);


        usersTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int row = usersTable.getSelectedRow();
                int column = usersTable.getColumnCount();

                Object objId =  GetData(usersTable, row, 0);
                Object objSurname = GetData(usersTable, row, 1);
                Object objName = GetData(usersTable, row, 2);
                Object objEmail = GetData(usersTable, row, 3);
                String userSurname = objSurname.toString();
                String userName = objName.toString();
                String userEmail = objEmail.toString();
                String userId = objId.toString();

                name.setText(userSurname + " " + userName);
                email.setText(userEmail);
                id.setText(userId);

/*
                for (int i = 0; i < column; i++) {

                    String value = " " + usersTable.getValueAt(row, i).toString();

                    System.out.println(value);

                }
*/


            }
        });

        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Object objId =  GetData(usersTable, usersTable.getSelectedRow(), 0);
                int id = (Integer) objId;

                int result = JOptionPane.showConfirmDialog(null, "Voulez vous vraiment supprimer cet utilisateur ?", "Suppression", JOptionPane.YES_NO_CANCEL_OPTION);

                if(usersTable.getSelectedRow() != -1 && result == JOptionPane.YES_OPTION) {
                    tableModel.removeRow(usersTable.getSelectedRow());
                    try {
                        UsersDaoJdbc usersDaoJdbc = new UsersDaoJdbc();
                        usersDaoJdbc.deleteUsersById(id);
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "L'utilisateur a bien été supprimé");
                }
            }
        });

        utilisateursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // BOUTON UTILISATEURS
            }
        });
        commerciauxButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOUTON COMMERCIAUX
            }
        });
        clientsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //BOUTON CLIENTS
            }
        });
        buttonLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login(frame);
                frame.setContentPane(login.getLoginPanel());
                frame.pack();;
                frame.setVisible(true);
                frame.setTitle("Login");
            }
        });
    }

    public Object GetData(JTable table, int row_index, int col_index) {
        return table.getModel().getValueAt(row_index, col_index);
    }


    public JPanel getAdminPanel() {
        return adminPanel;
    }
}
