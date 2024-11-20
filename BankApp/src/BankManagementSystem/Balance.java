package BankManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Balance extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;

    Balance(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Set up the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Add label for balance display
        JLabel text = new JLabel("Your Balance:");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        // Fetch and display balance
        JLabel balanceLabel = new JLabel();
        balanceLabel.setForeground(Color.WHITE);
        balanceLabel.setFont(new Font("System", Font.BOLD, 22));
        balanceLabel.setBounds(170, 350, 400, 25);
        image.add(balanceLabel);

        try {
            // Create connection and initialize handler
            Conn conn = new Conn();
            DatabaseHandler dbHandler = new DatabaseHandler(conn.c);
            BalanceHandler balanceHandler = new BalanceHandler(dbHandler);

            // Fetch balance
            double balance = balanceHandler.getBalance(pinnumber);
            balanceLabel.setText(balance + " €");

        } catch (Exception e) {
            balanceLabel.setText("Error fetching balance");
            e.printStackTrace();
        }

        // Add Back button
        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        // Frame settings
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Balance("");
    }
}
