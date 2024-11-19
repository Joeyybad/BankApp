package BankManagementSystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
	
	JButton deposit, withdrawl, fastcash, ministatement,pinchange, balance, exit;
	String pinnumber;
	FastCash(String pinnumber){
		this.pinnumber = pinnumber; 
		setLayout(null); 
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD, 16));
		image.add(text); 
		
		deposit = new JButton("20€");
		deposit.setBounds(170,415,150,35);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("30€");
		withdrawl.setBounds(355,415,150,35);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("50€");
		fastcash.setBounds(170,450,150,35);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("100€");
		ministatement.setBounds(355,450,150,35);
		ministatement.addActionListener(this);
		image.add(ministatement);

		pinchange = new JButton("200€");
		pinchange.setBounds(170,485,150,35);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("300€");
		balance.setBounds(355,485,150,35);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("BACK");
		exit.setBounds(355,520 ,150,35);
		exit.addActionListener(this);
		image.add(exit); 


		
		setSize(900,900); 
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
	    if (ae.getSource() == exit) {
	        setVisible(false);
	        new Transactions(pinnumber).setVisible(true);
	    } else {
	        // Récupérer le montant à partir du bouton
	        String amountText = ((JButton) ae.getSource()).getText(); 
	        int amount;

	        try {
	            // Convertir le texte en un nombre entier
	            amount = Integer.parseInt(amountText.replace("€", "").trim());
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Montant invalide.");
	            return;
	        }

	        try {
	            // Initialiser la connexion
	            Conn c = new Conn();
	            DatabaseHandler dbHandler = new DatabaseHandler(c.c);

	            // Calculer le solde actuel
	            String query = "SELECT * FROM bank WHERE pin = ?";
	            ResultSet rs = dbHandler.executeQuery(query, pinnumber);

	            int balance = 0;
	            while (rs.next()) {
	                String type = rs.getString("type");
	                int transactionAmount = Integer.parseInt(rs.getString("amount"));

	                if (type.equals("Deposit")) {
	                    balance += transactionAmount;
	                } else if (type.equals("Withdrawl")) {
	                    balance -= transactionAmount;
	                }
	            }

	            // Vérifier si le solde est suffisant
	            if (balance < amount) {
	                JOptionPane.showMessageDialog(null, "Solde insuffisant pour ce retrait.");
	                return;
	            }

	            // Effectuer le retrait
	            Date date = new Date();
	            String withdrawQuery = "INSERT INTO bank (pin, date, type, amount) VALUES (?, ?, ?, ?)";
	            boolean success = dbHandler.executeUpdate(withdrawQuery, pinnumber, date, "Withdrawl", amount);

	            if (success) {
	                JOptionPane.showMessageDialog(null, "Retrait réussi de " + amount + "€.");
	                setVisible(false);
	                new Transactions(pinnumber).setVisible(true);
	            } else {
	                JOptionPane.showMessageDialog(null, "Erreur lors du retrait.", "Erreur", JOptionPane.ERROR_MESSAGE);
	            }
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur de base de données", JOptionPane.ERROR_MESSAGE);
	            e.printStackTrace();
	        }
	    }
	}

	public static void main(String[] args) {
		new FastCash("");
	}

}
