package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class CookieMain {

    JLabel counterLabel, perSecLabel;
    int cookieCounter;
    Font font1, font2;
    CookieHandler cHandler = new CookieHandler();

    public static void main(String[] args) {
        new CookieMain();
    }

    public CookieMain() {
        cookieCounter = 0;
        createFont();
        createUI();
    }

    public void createFont() {
        font1 = new Font("Helvetica", Font.PLAIN, 32);
        font2 = new Font("Helvetica", Font.PLAIN, 15);
    }

    public void createUI() {
        JFrame window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        JPanel cookiePanel = new JPanel();
        cookiePanel.setBounds(100, 220, 200, 200);
        cookiePanel.setBackground(Color.black);
        window.add(cookiePanel);

        ImageIcon cookie = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("cookie.png")));

        JButton cookieButton = new JButton();
        cookieButton.setBackground(Color.black);
        cookieButton.setFocusPainted(false);
        cookieButton.setBorder(null);
        cookieButton.setIcon(cookie);
        cookieButton.addActionListener(cHandler);
        cookiePanel.add(cookieButton);

        JPanel counterPanel = new JPanel();
        counterPanel.setBounds(100, 100, 200, 100);
        counterPanel.setBackground(Color.black);
        counterPanel.setLayout(new GridLayout(2,1));
        window.add(counterPanel);

        counterLabel = new JLabel(cookieCounter + " cookies");
        counterLabel.setForeground(Color.white);
        counterLabel.setFont(font1);
        counterPanel.add(counterLabel);

        perSecLabel = new JLabel();
        perSecLabel.setForeground(Color.white);
        perSecLabel.setFont(font2);
        counterPanel.add(perSecLabel);

        window.setVisible(true);
    }

    public class CookieHandler implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            cookieCounter++;
            counterLabel.setText(cookieCounter + " cookies");

        }

    }

}