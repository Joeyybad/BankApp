package BankManagementSystem;

import java.awt.Image;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JButton deposit, withdrawl, fastcash, ministatement,pinchange, balance, exit;
	String pinnumber;
	Transactions(String pinnumber){
		this.pinnumber = pinnumber; 
		setLayout(null); 
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please select your transaction");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD, 16));
		image.add(text); 
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170,415,150,35);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawl = new JButton("Withdrawl");
		withdrawl.setBounds(355,415,150,35);
		withdrawl.addActionListener(this);
		image.add(withdrawl);
		
		fastcash = new JButton("Fast cash");
		fastcash.setBounds(170,450,150,35);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement = new JButton("Mini statement");
		ministatement.setBounds(355,450,150,35);
		ministatement.addActionListener(this);
		image.add(ministatement);

		pinchange = new JButton("Pin change");
		pinchange.setBounds(170,485,150,35);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		balance = new JButton("Balance Enquiry");
		balance.setBounds(355,485,150,35);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Exit");
		exit.setBounds(355,520 ,150,35);
		exit.addActionListener(this);
		image.add(exit); 


		
		setSize(900,900); 
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == exit){
			System.exit(0);
		} else if(ae.getSource()== deposit) {
			setVisible(false);
			new Deposit(pinnumber).setVisible(true);
		} else if(ae.getSource()== withdrawl){
			setVisible(false);
			new Withdrawl(pinnumber).setVisible(true);
		} else if(ae.getSource()== fastcash) {
			setVisible(false);
			new FastCash(pinnumber).setVisible(true);
		}
		if(ae.getSource()== balance) {
			setVisible(false);
			new Balance(pinnumber).setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Transactions("");
	}

}
