package com.orbisbank.launcher;

import com.orbisbank.gui.Login;
import com.orbisbank.gui.Register;

import javax.swing.*;

public class Launcher extends JFrame {

    public Launcher() {

        Register register = new Register();

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login(frame).getLoginPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}
