package com.orbisbank.gui;

import javax.swing.*;

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

    public Customers() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        this.screenRightBottom = new JPanel();

        String data[][]={ {"101","Amit","670000"},
                {"102","Jai","780000"},
                {"101","Sachin","700000"}};
        String column[]={"ID","NAME","SALARY"};

        JTable tableClients = new JTable(data, column);



    }


    public static void main(String[] args) {
        JFrame clients = new JFrame("Clients");
        clients.setContentPane(new Customers().clientsPanel);
        clients.pack();
        clients.setVisible(true);
    }
}
