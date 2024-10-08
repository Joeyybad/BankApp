package BankManagementSystem;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import com.toedter.calendar.*;





public class Signup extends JFrame {
	
	Signup() {
		
		setLayout(null);
		
		Random ran = new Random();
		long random = Math.abs((ran.nextLong()%9000L) + 1000L);
		
		JLabel formno = new JLabel("APPLICATION FORM NO. " + random); 
		
		formno.setFont(new Font("Raleway",Font.BOLD, 38));
		formno.setBounds(140,20,600,40);
		add(formno);
		
		JLabel personDetails = new JLabel("Page 1: Personal Details"); 
		
		personDetails.setFont(new Font("Raleway",Font.BOLD, 22));
		personDetails.setBounds(290,80,400,30);
		add(personDetails);
		
		JLabel fname = new JLabel("Firstname:");  
		fname.setFont(new Font("Raleway",Font.BOLD, 20));
		fname.setBounds(100,140,150,30);
		add(fname);
		
		JTextField fnameText = new JTextField();
		fnameText.setFont(new Font ("Raleway", Font.BOLD, 14));
		fnameText.setBounds(300,140,400,30);
		add(fnameText);
		
		JLabel lname = new JLabel("Lastname:");  
		
		lname.setFont(new Font("Raleway",Font.BOLD, 20));
		lname.setBounds(100,190,150,30);
		add(lname);
		
		JTextField lnameText = new JTextField();
		lnameText.setFont(new Font ("Raleway", Font.BOLD, 14));
		lnameText.setBounds(300,190,400,30);
		add(lnameText);
		
		JLabel DOB = new JLabel("Date of birth:");  
		
		DOB.setFont(new Font("Raleway",Font.BOLD, 20));
		DOB.setBounds(100,240,150,30);
		add(DOB);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);
		
	
		JLabel gender = new JLabel("Gender:");  
		
		gender.setFont(new Font("Raleway",Font.BOLD, 20));
		gender.setBounds(100,290,150,30);
		add(gender);
		
		JRadioButton male = new JRadioButton("Male");
		male.setBounds(300,290,150,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setBounds(450,290,150,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		JLabel email = new JLabel("Email:");  
		email.setFont(new Font("Raleway",Font.BOLD, 20));
		email.setBounds(100,340,150,30);
		add(email);
		
		JTextField emailText = new JTextField();
		emailText.setFont(new Font ("Raleway", Font.BOLD, 14));
		emailText.setBounds(300,340,400,30);
		add(emailText);
		
		JLabel marital = new JLabel("Marital Status:");  
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,390,150,30);
		add(marital);
		
		JRadioButton maried = new JRadioButton("Married");
		maried.setBounds(300,390,100,30);
		maried.setBackground(Color.WHITE);
		add(maried);
		
		
		JRadioButton unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,150,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		JRadioButton other = new JRadioButton("other");
		other.setBounds(630,390,150,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(maried);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);

		JLabel address = new JLabel("Address:");  
		address.setFont(new Font("Raleway",Font.BOLD, 20));
		address.setBounds(100,440,150,30);
		add(address);
		
		JTextField addressText = new JTextField();
		addressText.setFont(new Font ("Raleway", Font.BOLD, 14));
		addressText.setBounds(300,440,400,30);
		add(addressText);
		
		JLabel city = new JLabel("City:");  
		city.setFont(new Font("Raleway",Font.BOLD, 20));
		city.setBounds(100,490,150,30);
		add(city);
		
		JTextField cityText = new JTextField();
		cityText.setFont(new Font ("Raleway", Font.BOLD, 14));
		cityText.setBounds(300,490,400,30);
		add(cityText);
		
		JLabel state = new JLabel("State:");  
		state.setFont(new Font("Raleway",Font.BOLD, 20));
		state.setBounds(100,540,150,30);
		add(state);
		
		JTextField stateText = new JTextField();
		stateText.setFont(new Font ("Raleway", Font.BOLD, 14));
		stateText.setBounds(300,540,400,30);
		add(stateText);
		
		JLabel pincode = new JLabel("Pin C ode:");  
		
		pincode.setFont(new Font("Raleway",Font.BOLD, 20));
		pincode.setBounds(100,590,150,30);
		add(pincode);
		
		JTextField pinText = new JTextField();
		pinText.setFont(new Font ("Raleway", Font.BOLD, 14));
		pinText.setBounds(300,590,400,30);
		add(pinText);
		
		JButton next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.setBounds(620,660,80,30);
		add(next);
        // Forcer le bouton à être opaque pour appliquer le fond noir
		next.setOpaque(true);

        // Retirer la bordure par défaut pour que le fond soit plus visible
		next.setBorderPainted(false);
		 
		 
		
		/**
		 *  WindowFormat
		 */
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Signup();

	}

}
