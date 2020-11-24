package com.orbisbank.gui;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;

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

    public Customers() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = new String[]{
                "Id", "Nom", "Prénom", "Email", "Téléphone", "Adresse"
        };

        Object[][] data = new Object[][]{

        };

        JTable myTable = new JTable(data, columns);
        myTable.setPreferredScrollableViewportSize(new Dimension(400, 100));
        scrollPane.setViewportView(myTable);
    }


    public static void main(String[] args) {
        JFrame clients = new JFrame("Clients");
        clients.setContentPane(new Customers().clientsPanel);
        clients.pack();
        clients.setVisible(true);


    }


}
