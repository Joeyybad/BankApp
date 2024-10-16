package BankManagementSystem;

import java.awt.*;
import java.util.*;
import javax.swing.*;

import com.toedter.calendar.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.time.*;

import java.util.regex.*;






public class Signup extends JFrame implements ActionListener {
	
	long random;
	
	JTextField fnameText, lnameText,dobText, emailText, addressText, cityText, stateText,pinText;
	JButton next;
	JRadioButton male, female, other, married, unmarried;
	JDateChooser dateChooser;
	private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(EMAIL_REGEX);
	
	Signup() {
		
		setLayout(null);
		
		Random ran = new Random();
		random = Math.abs((ran.nextLong()%9000L) + 1000L);
		
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
		
		fnameText = new JTextField();
		fnameText.setFont(new Font ("Raleway", Font.BOLD, 14));
		fnameText.setBounds(300,140,400,30);
		add(fnameText);
		
		JLabel lname = new JLabel("Lastname:");  
		
		lname.setFont(new Font("Raleway",Font.BOLD, 20));
		lname.setBounds(100,190,150,30);
		add(lname);
		
		lnameText = new JTextField();
		lnameText.setFont(new Font ("Raleway", Font.BOLD, 14));
		lnameText.setBounds(300,190,400,30);
		add(lnameText);
		
		JLabel DOB = new JLabel("Date of birth:");  
		
		DOB.setFont(new Font("Raleway",Font.BOLD, 20));
		DOB.setBounds(100,240,150,30);
		add(DOB);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(300,240,400,30);
		dateChooser.setForeground(new Color(105, 105, 105));
		add(dateChooser);
		
	
		JLabel gender = new JLabel("Gender:");  
		
		gender.setFont(new Font("Raleway",Font.BOLD, 20));
		gender.setBounds(100,290,150,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300,290,150,30);
		male.setBackground(Color.WHITE);
		add(male);
		
		female = new JRadioButton("Female");
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
		
		emailText = new JTextField();
		emailText.setFont(new Font ("Raleway", Font.BOLD, 14));
		emailText.setBounds(300,340,400,30);
		add(emailText);
		
		JLabel marital = new JLabel("Marital Status:");  
		marital.setFont(new Font("Raleway",Font.BOLD,20));
		marital.setBounds(100,390,150,30);
		add(marital);
		
		married = new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.WHITE);
		add(married);
		
		
		unmarried = new JRadioButton("Unmarried");
		unmarried.setBounds(450,390,150,30);
		unmarried.setBackground(Color.WHITE);
		add(unmarried);
		
		other = new JRadioButton("other");
		other.setBounds(630,390,150,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(unmarried);
		maritalgroup.add(other);

		JLabel address = new JLabel("Address:");  
		address.setFont(new Font("Raleway",Font.BOLD, 20));
		address.setBounds(100,440,150,30);
		add(address);
		
		addressText = new JTextField();
		addressText.setFont(new Font ("Raleway", Font.BOLD, 14));
		addressText.setBounds(300,440,400,30);
		add(addressText);
		
		JLabel city = new JLabel("City:");  
		city.setFont(new Font("Raleway",Font.BOLD, 20));
		city.setBounds(100,490,150,30);
		add(city);
		
		cityText = new JTextField();
		cityText.setFont(new Font ("Raleway", Font.BOLD, 14));
		cityText.setBounds(300,490,400,30);
		add(cityText);
		
		JLabel state = new JLabel("State:");  
		state.setFont(new Font("Raleway",Font.BOLD, 20));
		state.setBounds(100,540,150,30);
		add(state);
		
		stateText = new JTextField();
		stateText.setFont(new Font ("Raleway", Font.BOLD, 14));
		stateText.setBounds(300,540,400,30);
		add(stateText);
		
		JLabel pincode = new JLabel("Pin Code:");  
		
		pincode.setFont(new Font("Raleway",Font.BOLD, 20));
		pincode.setBounds(100,590,150,30);
		add(pincode);
		
		pinText = new JTextField();
		pinText.setFont(new Font ("Raleway", Font.BOLD, 14));
		pinText.setBounds(300,590,400,30);
		add(pinText);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD,14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
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
	
	public void actionPerformed(ActionEvent ae) {
		
		String formno = ""+ random;
		
		String fname = fnameText.getText();
		if (fname == null || fname.trim().isEmpty()) {
		        JOptionPane.showMessageDialog(null, "Le prénom est requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
		        return; 
		}
		
		String lname = lnameText.getText();
		if (lname == null || lname.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Le nom est requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        return; 
		}
		
		Date dob = dateChooser.getDate();
		String dobFormatted = null;
		
		if (dob == null) {
		        JOptionPane.showMessageDialog(null, "La date de naissance est requise.", "Erreur", JOptionPane.ERROR_MESSAGE);
		        return;
		   } else {
		        if (!isAgeValid(dob)) {
		            JOptionPane.showMessageDialog(null, "Vous devez avoir au moins 18 ans.", "Erreur", JOptionPane.ERROR_MESSAGE);
		            return; 
		        }
		        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		        dobFormatted = sdf.format(dob);
		   }
		
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}else if (female.isSelected()){
			gender = "Female";
		}
		
		String email = emailText.getText();
		
		if (email == null || email.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Le mail est requis", "Erreur", JOptionPane.ERROR_MESSAGE);
	        return; // Sortir de la méthode si l'e-mail est null ou vide
	    } else if (!isValidEmail(email)) {
	        JOptionPane.showMessageDialog(null, "Veuillez entrer un e-mail valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        return; // Sortir de la méthode si l'e-mail est invalide
	    }
		
		String marital = null;
		
		if(married.isSelected()) {
			marital = "Married";
		} else if(unmarried.isSelected()){
			marital = "Unmarried";
		}else if (other.isSelected()) {
			marital = "Other";
		}
		
		String address = addressText.getText();
		if (address == null || address.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "L'adresse est requise.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        return; 
		}
		
		String city = cityText.getText(); 
		if (city == null || city.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "La ville est requise.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        return; 
		}
		
		String state = stateText.getText();
		if (state == null || state.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "L'état est requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        return; 
		}
		String pin = pinText.getText(); 
		if (pin == null || pin.trim().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Le code est requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        return; 
		}
		
		try {
	        Conn c = new Conn();
	        String query = "INSERT INTO signup(formno, fname, lname, dob, gender, email, marital_status, address, city, state, pincode) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        PreparedStatement stmt = c.c.prepareStatement(query);
	        stmt.setString(1, formno);
	        stmt.setString(2, fname);
	        stmt.setString(3, lname);
	        stmt.setString(4, dobFormatted);
	        stmt.setString(5, gender);
	        stmt.setString(6, email);
	        stmt.setString(7, marital);
	        stmt.setString(8, address);
	        stmt.setString(9, city);
	        stmt.setString(10, state);
	        stmt.setString(11, pin);
	        
	        stmt.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Enregistrement réussi!");
	        setVisible(false);
	        new SignupTwo(formno).setVisible(true);
	    } catch (SQLIntegrityConstraintViolationException e) {
	        // Gérer l'exception pour les doublons
	        JOptionPane.showMessageDialog(null, "Cet enregistrement existe déjà (doublon détecté).", "Erreur", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception e) {
	        // Gérer les autres exceptions
	        System.out.println(e);
	        JOptionPane.showMessageDialog(null, "Erreur lors de l'insertion dans la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
	    }
	}
	private boolean isAgeValid(Date dob) {
	    // Convertir Date en LocalDate
	    LocalDate birthDate = new java.sql.Date(dob.getTime()).toLocalDate();
	    LocalDate today = LocalDate.now(); // Obtenir la date actuelle

	    // Calculer l'âge en années
	    Period age = Period.between(birthDate, today);

	    return age.getYears() >= 18; // Vérifie si l'âge est supérieur ou égal à 18
	}
	
	private static boolean isValidEmail(String email) {
        if (email == null) {
            return false; // Email null
        }
        Matcher matcher = pattern.matcher(email);
        return matcher.matches(); // Vérifie si l'email correspond au modèle
    }

	public static void main(String[] args) {
		new Signup();

	}

}
