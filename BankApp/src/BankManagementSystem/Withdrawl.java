package BankManagementSystem;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amountField;
    JButton withdraw, back;
    String pinnumber;

    Withdrawl(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Set up the background image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Add label for instructions
        JLabel text = new JLabel("Enter the amount you want to withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170, 300, 400, 20);
        image.add(text);

        // Add text field for amount input
        amountField = new JTextField();
        amountField.setFont(new Font("Raleway", Font.BOLD, 22));
        amountField.setBounds(170, 350, 320, 25);
        image.add(amountField);

        // Add Deposit button
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(355, 485, 150, 30);
        withdraw.addActionListener(this);
        image.add(withdraw);

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
        if (ae.getSource() == withdraw) {
            handleDeposit();
        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

    private void handleDeposit() {
        String amount = amountField.getText();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);

        if (amount.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
        } else {
            try {
                Conn conn = new Conn();
                DatabaseHandler dbHandler = new DatabaseHandler(conn.c);
                WithdrawHandler withdrawHandler = new WithdrawHandler(dbHandler);
                boolean success = withdrawHandler.withdraw(pinnumber, formattedDate, amount);


                if (success) {
                    JOptionPane.showMessageDialog(null, "Amount Withdraw Successfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Withdrawl failed", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}

