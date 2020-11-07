package com.orbisbank.launcher;

import com.orbisbank.gui.Login;
import com.orbisbank.gui.Register;

import javax.swing.*;

public class Launcher extends JFrame {

    public Launcher() {

        Register register = new Register();

    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Register");
        frame.setContentPane(new Register().getRegister_panel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
