package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Random;

import javax.swing.*;

public class SignupThree extends JFrame implements ActionListener {
	
	JRadioButton r1, r2, r3, r4;
	JCheckBox c1,c2,c3,c4,c5,c6,c7;
	JButton submit, cancel;
	String formno;

		SignupThree(String formno){
			this.formno = formno;
			
			JLabel l1 = new JLabel("Page 3: Account Details");
			l1.setFont(new Font("Raleway",Font.BOLD, 22));
			l1.setBounds(290,80,400,30);
			add(l1);
			
			JLabel type = new JLabel("Account Type ");
			type.setFont(new Font("Raleway",Font.BOLD, 22));
			type.setBounds(100 ,140,200,30);
			add(type);
			 
			
			r1 = new JRadioButton("Saving Account");
			r1.setFont(new Font("Raleway", Font.BOLD,16));
			r1.setBackground(Color.WHITE);
			r1.setBounds(100,180,200,20);
			add(r1);
			
			r2 = new JRadioButton("Fixed Deposit Account");
			r2.setFont(new Font("Raleway", Font.BOLD,16));
			r2.setBackground(Color.WHITE);
			r2.setBounds(350,180,200,20);
			add(r2);
			
			r3 = new JRadioButton("Current  Account");
			r3.setFont(new Font("Raleway", Font.BOLD,16));
			r3.setBackground(Color.WHITE);
			r3.setBounds(100,220,250,20);
			add(r3);
			
			r4 = new JRadioButton("Recurring Deposing Account");
			r4.setFont(new Font("Raleway", Font.BOLD,16));
			r4.setBackground(Color.WHITE);
			r4 .setBounds(350,220,300,20);
			add(r4);
			
			ButtonGroup groupaccount = new ButtonGroup();
			groupaccount.add(r1);
			groupaccount.add(r2);
			groupaccount.add(r3);
			groupaccount.add(r4);
			
			
			
			JLabel card = new JLabel("Card Number ");
			card.setFont(new Font("Raleway",Font.BOLD, 22));
			card.setBounds(100 ,300 ,200,30);
			add(card);
			
			JLabel number = new JLabel("XXXX-XXXX-XXXX-4817 ");
			number.setFont(new Font("Raleway",Font.BOLD, 22));
			number.setBounds(330 ,300 ,300,30);
			add(number);
			
			JLabel cardDetails = new JLabel("Your 16 Digit Card Number ");
			cardDetails.setFont(new Font("Raleway",Font.BOLD, 12));
			cardDetails.setBounds(100 ,330 ,200,20);
			add(cardDetails); 
			
			JLabel pin = new JLabel("PIN:");
			pin.setFont(new Font("Raleway",Font.BOLD, 22));
			pin.setBounds(100 ,370 ,200,30);
			add(pin);
			
			JLabel pnumber = new JLabel("XXXX");
			pnumber.setFont(new Font("Raleway",Font.BOLD, 22));
			pnumber.setBounds(330 ,370 ,250,30);
			add(pnumber);
			
			JLabel pinDetails = new JLabel("Your 4 Digit Password");
			pinDetails.setFont(new Font("Raleway",Font.BOLD, 12));
			pinDetails.setBounds(100 ,400,200,20);
			add(pinDetails); 
			
			JLabel services = new JLabel("Services Required :");
			services.setFont(new Font("Raleway",Font.BOLD, 22));
			services.setBounds(100 ,450 ,250,30);
			add(services);
			
			c1 = new JCheckBox("ATM CARD");
			c1.setBackground(Color.WHITE);
			c1.setFont(new Font("Raleway",Font.BOLD,16));
			c1.setBounds(100,500,250,30); 
			add(c1);
			
			c2 = new JCheckBox("Internet Banking");
			c2.setBackground(Color.WHITE);
			c2.setFont(new Font("Raleway",Font.BOLD,16));
			c2.setBounds(350,500,250,30); 
			add(c2);	
			
			c3 = new JCheckBox("Mobile Banking");
			c3.setBackground(Color.WHITE);
			c3.setFont(new Font("Raleway",Font.BOLD,16));
			c3.setBounds(100,550,250,30); 
			add(c3);	
			
			c4 = new JCheckBox("Email & Sms alerts");
			c4.setBackground(Color.WHITE);
			c4.setFont(new Font("Raleway",Font.BOLD,16));
			c4.setBounds(350,550,250,30); 
			add(c4);
			
			c5 = new JCheckBox("Check book");
			c5.setBackground(Color.WHITE);
			c5.setFont(new Font("Raleway",Font.BOLD,16));
			c5.setBounds(100,600,250,30); 
			add(c5);
			
			c6 = new JCheckBox("E Statement");
			c6.setBackground(Color.WHITE);
			c6.setFont(new Font("Raleway",Font.BOLD,16));
			c6.setBounds(350,600,250,30); 
			add(c6);	
			
			c7 = new JCheckBox("I declares that all details are corrects");
			c7.setBackground(Color.WHITE);
			c7.setFont(new Font("Raleway",Font.BOLD,12));
			c7.setBounds(100,680,600,30); 
			add(c7);
			
			
			submit = new JButton("Submit");
			submit.setBackground(Color.BLACK);
			submit.setForeground(Color.WHITE);
			submit.setFont(new Font("Raleway", Font.BOLD,14));
			submit.setBounds(250,720,100,30);
			submit.addActionListener(this);
			add(submit);
	        // Forcer le bouton à être opaque pour appliquer le fond noir
			submit.setOpaque(true);

	        // Retirer la bordure par défaut pour que le fond soit plus visible
			submit.setBorderPainted(false);
			 
			cancel = new JButton("Cancel");
			cancel.setBackground(Color.BLACK);
			cancel.setForeground(Color.WHITE);
			cancel.setFont(new Font("Raleway", Font.BOLD,14));
			cancel.setBounds(420,720,100,30);
			// Forcer le bouton à être opaque pour appliquer le fond noir
			cancel.setOpaque(true);

			// Retirer la bordure par défaut pour que le fond soit plus visible
			cancel.setBorderPainted(false);
			cancel.addActionListener(this);
			add(cancel);
			
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			setSize(850,820);
			setLocation(350,0);
			setVisible(true);
			
		}
		
		public void actionPerformed(ActionEvent ae) {
		    if (ae.getSource() == submit) {
		        String accountType = null;
		        if (r1.isSelected()) accountType = "Saving Account";
		        else if (r2.isSelected()) accountType = "Fixed Deposit Account";
		        else if (r3.isSelected()) accountType = "Current Account";
		        else if (r4.isSelected()) accountType = "Recurring Deposit Account";

		        if (accountType == null) {
		            JOptionPane.showMessageDialog(null, "Veuillez sélectionner un type de compte.");
		            return;
		        }

		        if (!c7.isSelected()) {
		            JOptionPane.showMessageDialog(null, "Vous devez déclarer que les informations fournies sont correctes.");
		            return;
		        }

		        // Générer un numéro de carte unique
		        Random random = new Random();
		        String cardnumber = String.format("%016d", Math.abs(random.nextLong() % 10000000000000000L));
		        String pinnumber = String.format("%04d", Math.abs(random.nextInt(9000) + 1000));

		        // Vérifier si un service est sélectionné
		        StringBuilder facilityBuilder = new StringBuilder();
		        if (c1.isSelected()) facilityBuilder.append("ATM Card, ");
		        if (c2.isSelected()) facilityBuilder.append("Internet Banking, ");
		        if (c3.isSelected()) facilityBuilder.append("Mobile Banking, ");
		        if (c4.isSelected()) facilityBuilder.append("Email & SMS Alerts, ");
		        if (c5.isSelected()) facilityBuilder.append("Check Book, ");
		        if (c6.isSelected()) facilityBuilder.append("E Statement, ");

		        String facility = facilityBuilder.length() > 0 ? facilityBuilder.substring(0, facilityBuilder.length() - 2) : "";
		        
		        if (facility.isEmpty()) {
		            JOptionPane.showMessageDialog(null, "Veuillez sélectionner au moins un service.");
		            return;
		        }

		        try {
		            Conn c = new Conn();
		            String query = "INSERT INTO signupthree (formno, accounttype, cardnumber, pinnumber, facility) VALUES(?, ?, ?, ?, ?)";
		            PreparedStatement stmt = c.c.prepareStatement(query);
		            stmt.setString(1, formno);
		            stmt.setString(2, accountType);
		            stmt.setString(3, cardnumber);
		            stmt.setString(4, pinnumber);
		            stmt.setString(5, facility);
		            stmt.executeUpdate();
		            
		            JOptionPane.showMessageDialog(null, "Enregistrement réussi! numéro de carte:" + cardnumber + "\n Pin code: " + pinnumber);
		            
		            
		            String query2 = "INSERT INTO login (formno, cardnumber, pinnumber) VALUES(?, ?, ?)";
		            PreparedStatement stmt2 = c.c.prepareStatement(query2);
		            stmt2.setString(1, formno);
		            stmt2.setString(2, cardnumber);
		            stmt2.setString(3, pinnumber);
		            stmt2.executeUpdate();

		        } catch (SQLIntegrityConstraintViolationException e) {
		            JOptionPane.showMessageDialog(null, "Cet enregistrement existe déjà (doublon détecté).", "Erreur", JOptionPane.ERROR_MESSAGE);
		        } catch (SQLException e) {
		            JOptionPane.showMessageDialog(null, "Erreur SQL: " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
		        }
		    } else if (ae.getSource() == cancel) {
		        // Action de cancel
		    }
		}

	 
	public static void main(String[] args) {
		
		new SignupThree("");

	}

}
