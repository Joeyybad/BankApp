package BankManagementSystem;

import java.awt.Color;
import java.awt.event.*;
import java.sql.ResultSet;
import java.awt.*;

import javax.swing.*;


public class Login extends JFrame implements ActionListener{
	
	JButton loginButton,clearButton,signupButton;
	JTextField cardTextField;
	JPasswordField pinTextField;
	
	Login(){
		
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setFont(new Font ("Osward", Font.BOLD,38));
		text.setBounds(200,40,400,40);
		add(text);
		
		JLabel cardno = new JLabel("Card No:");
		cardno.setFont(new Font ("Raleway", Font.BOLD,28));
		cardno.setBounds(120,150,400,40);
		add(cardno);
		
		cardTextField = new JTextField();
		cardTextField.setFont(new Font("Arial", Font.BOLD,14));
		add(cardTextField); 
		
		cardTextField.setBounds( 300,150,230,40); 
		
		JLabel pin = new JLabel("Pin:");
		pin.setFont(new Font ("Raleway", Font.BOLD,28));
		pin.setBounds(120,220,250,40);
		add(pin);
		
		pinTextField = new JPasswordField();
		pinTextField.setFont(new Font("Arial", Font.BOLD,14)); 
		add(pinTextField); 
		
		pinTextField.setBounds(300,220,230,40); 
		
		
		loginButton = new JButton("SIGN IN");
		loginButton.setBounds(300,300,100,30);
		loginButton.setBackground(Color.BLACK);
        loginButton.setForeground(Color.WHITE);

        // Forcer le bouton à être opaque pour appliquer le fond noir
        loginButton.setOpaque(true);

        // Retirer la bordure par défaut pour que le fond soit plus visible
        loginButton.setBorderPainted(false);
        
        loginButton.addActionListener(this);
        
		add(loginButton);
		
		clearButton = new JButton("CLEAR");
		clearButton.setBounds(430,300,100,30);
		clearButton.setBackground(Color.BLACK);
		clearButton.setForeground(Color.WHITE);

        // Forcer le bouton à être opaque pour appliquer le fond noir
		clearButton.setOpaque(true);

        // Retirer la bordure par défaut pour que le fond soit plus visible
		clearButton.setBorderPainted(false);
		
		
		clearButton.addActionListener(this);
		add(clearButton);
		
		signupButton = new JButton("SIGN UP");
		signupButton.setBounds(300,350,230,30);
		signupButton.setBackground(Color.BLACK);
		signupButton.setForeground(Color.WHITE);

        // Forcer le bouton à être opaque pour appliquer le fond noir
		signupButton.setOpaque(true);

        // Retirer la bordure par défaut pour que le fond soit plus visible
		signupButton.setBorderPainted(false);
		
		signupButton.addActionListener(this);
		add(signupButton);
		 
		 
		 
		
		getContentPane().setBackground(Color.WHITE);
		
		/**
		 *  WindowFormat
		 */
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()== clearButton) {
			cardTextField.setText("");
			pinTextField.setText("");
			
		} else if(ae.getSource()== loginButton) {
			Conn conn = new Conn();
			String cardnumber = cardTextField.getText();
			String pinnumber = pinTextField.getText();
			String query = "select * from login where cardnumber ='"+cardnumber+"' and pinnumber ='"+pinnumber+"'";
			
			try {
				ResultSet rs = conn.s.executeQuery(query);
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinnumber).setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null,"Incorrect card number or pin number");
				}
			}catch(Exception e) {
				System.out.print(e);
			}
			
		} else if (ae.getSource()== signupButton) {
			setVisible(false);
			new Signup().setVisible(true);
		}
		
	}

	public static void main(String[] args) {
		
		new Login();

	}

}
