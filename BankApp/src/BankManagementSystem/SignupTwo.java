package BankManagementSystem;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;


public class SignupTwo extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	long random;
	JTextField panText, idNoText;
	JButton next;
	JRadioButton syes,sno,eyes,eno;
	JComboBox<String> religion, category, income , occupation,education;
	String formno;
	
	SignupTwo(String formno) {
		this.formno = formno;
		setLayout(null);
		 
		setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
		
		JLabel additionalDetails = new JLabel("Page 2: Additional Details"); 
		
		additionalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
		additionalDetails.setBounds(290,80,400,30);
		add(additionalDetails );
		
		JLabel religionText = new JLabel("Religion :");  
		religionText.setFont(new Font("Raleway",Font.BOLD, 20));
		religionText.setBounds(100,140,150,30);
		add(religionText);
		
		String[] valReligion = {"Chrétienne","Orthodoxe","Judaïsme","Muslim","Other"};
		religion = new JComboBox<>(valReligion);
		religion.setBounds(300,140,400,30);
		religion.setBackground(Color.WHITE); 
		add(religion); 
		
		
		JLabel categoryText = new JLabel("Category");  
		categoryText.setFont(new Font("Raleway",Font.BOLD, 20));
		categoryText.setBounds(100,190,150,30);
		add(categoryText);
		
		String[] valCategory = {"General","OBC","SC","ST","Other"};
		
		category = new JComboBox<>(valCategory);
		category.setBounds(300,190,400,30);
		category.setBackground(Color.WHITE); 
		add(category);
		
		
		
		JLabel incomeText = new JLabel("Income :");  
		
		incomeText.setFont(new Font("Raleway",Font.BOLD, 20));
		incomeText.setBounds(100,240,150,30);
		add(incomeText);
		
		String incomeCategory[ ] = {"Null","< 1,200€","<1,600€","<2000€","Plus de 2400€"};
		
		income = new JComboBox<>(incomeCategory);
		income.setBounds(300,240,400,30);
		income.setBackground(Color.WHITE); 
		add(income);
		
	
		JLabel educational = new JLabel("Educational");  
		
		educational.setFont(new Font("Raleway",Font.BOLD, 20));
		educational.setBounds(100,290,150,30);
		add(educational);
		
		
		JLabel qualification = new JLabel("Qualification:");  
		qualification.setFont(new Font("Raleway",Font.BOLD, 20));
		qualification.setBounds(100,315,150,30);
		add(qualification);
		
		String educationValues[ ] = {"Non Graduation","Graduate","Post-Graduation","Doctor","Others"};
		
		education = new JComboBox<>(educationValues);
		education.setBounds(300,315,400,30);
		education.setBackground(Color.WHITE); 
		add(education);
		
		JLabel occupations = new JLabel("Occupations:");  
		occupations.setFont(new Font("Raleway",Font.BOLD,20));
		occupations.setBounds(100,390,150,30);
		add(occupations);
		
		String occupationValues[ ] = {"Salaried","Self Employed","Bussiness","Student","Retired","Other"};
		
		occupation = new JComboBox<>(occupationValues);
		occupation.setBounds(300,390,400,30);
		occupation.setBackground(Color.WHITE); 
		add(occupation);
		

		JLabel pan = new JLabel("PAN Number:");  
		pan.setFont(new Font("Raleway",Font.BOLD, 20));
		pan.setBounds(100,440,150,30);
		add(pan);
		
		panText = new JTextField();
		panText.setFont(new Font ("Raleway", Font.BOLD, 14));
		panText.setBounds(300,440,400,30);
		add(panText);
		
		JLabel idNo = new JLabel("ID Card no");  
		idNo.setFont(new Font("Raleway",Font.BOLD, 20));
		idNo.setBounds(100,490,150,30);
		add(idNo);
		
		idNoText = new JTextField();
		idNoText.setFont(new Font ("Raleway", Font.BOLD, 14));
		idNoText.setBounds(300,490,400,30);
		add(idNoText);
		
		JLabel seniorCitizen = new JLabel("Senior Citizen:");  
		seniorCitizen.setFont(new Font("Raleway",Font.BOLD, 20));
		seniorCitizen.setBounds(100,540,150,30);
		add(seniorCitizen);
		
		syes = new JRadioButton("Yes");
		syes.setBounds(300,540,100,30);
		syes.setBackground(Color.WHITE);
		add(syes);
		
		sno = new JRadioButton("No");
		sno.setBounds(500,540,100,30);
		sno.setBackground(Color.WHITE);
		add(sno);
		
		ButtonGroup seniorGroup = new ButtonGroup();
		seniorGroup.add(syes);
		seniorGroup.add(sno);
		
		
		JLabel existingAccount = new JLabel("Existing account");  
		
		existingAccount.setFont(new Font("Raleway",Font.BOLD, 20));
		existingAccount.setBounds(100,590,150,30);
		add(existingAccount);
		
		eyes = new JRadioButton("Yes");
		eyes.setBounds(300,590,100,30);
		eyes.setBackground(Color.WHITE);
		add(eyes);
		
		eno = new JRadioButton("No");
		eno.setBounds(500,590,100,30);
		eno.setBackground(Color.WHITE);
		add(eno );
		
		ButtonGroup emaritalgroup = new ButtonGroup();
		emaritalgroup.add(eyes);
		emaritalgroup.add(eno);
		
		
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
		
		String formno = this.formno;
		
		String sreligion = (String) religion.getSelectedItem();
		String scategory = (String) category.getSelectedItem();
		
		String sincome = (String) income.getSelectedItem();
		if (sincome == null || sincome.trim().isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Le revenu est requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
		    return; 
		}
		
		if (sincome != null) {
		    sincome = sincome.replaceAll("[^\\d.]", ""); // Retire tout sauf les chiffres et le point décimal
		}
		
		String[] parts = sincome.split("\\.");
		if (parts.length > 1) {
		    // Il y a une partie décimale
		    parts[0] = parts[0].replaceAll(",", ""); // Retire la virgule des milliers
		    sincome = parts[0] + "." + parts[1]; // Reconstitue le nombre en format décimal
		} else {
		    // Pas de partie décimale, juste retirer les virgules
		    sincome = sincome.replaceAll(",", ""); // On retire la virgule pour les milliers
		}
		
		BigDecimal incomeValue;
		try {
		    incomeValue = new BigDecimal(sincome);
		} catch (NumberFormatException e) {
		    JOptionPane.showMessageDialog(null, "Le revenu doit être un nombre valide.", "Erreur", JOptionPane.ERROR_MESSAGE);
		    return; // Sortir si la conversion échoue
		}


		
		
		String seducation = (String) education.getSelectedItem(); 
		String soccupation = (String) occupation.getSelectedItem();
		
		
		String seniorcitizen = null;
		seniorcitizen = (syes.isSelected() ? "1" : "0");

		
		String existingaccount = null;
		existingaccount = (eyes.isSelected() ? "1" : "0");
		
		String span = panText.getText();
		if (span == null || span.trim().isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Le numéro de carte bancaire est requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
		    return; // Sortir de la méthode si le PAN est vide
		} else if (!isValidPan(span)) {
		    JOptionPane.showMessageDialog(null, "Le numéro de carte bancaire est invalide ou existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
		    return; // Sortir de la méthode si le PAN est invalide ou déjà présent
		}

		// Vérification du numéro d'identité
		String idNo = idNoText.getText();
		if (idNo == null || idNo.trim().isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Le numéro ID est requis.", "Erreur", JOptionPane.ERROR_MESSAGE);
		    return; // Sortir de la méthode si le numéro d'identité est vide
		} else if (!isValidIdentityNumber(idNo)) {
		    JOptionPane.showMessageDialog(null, "Le numéro ID est invalide ou existe déjà.", "Erreur", JOptionPane.ERROR_MESSAGE);
		    return; // Sortir de la méthode si le numéro ID est invalide ou déjà présent
		}
		
		
		try {
	        Conn c = new Conn();
	        String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, pan, idNo, seniorcitizen, existingaccount) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        PreparedStatement stmt = c.c.prepareStatement(query);
	        stmt.setString(1, formno);
	        stmt.setString(2, sreligion);
	        stmt.setString(3, scategory);
	        stmt.setBigDecimal(4, incomeValue);
	        stmt.setString(5, seducation);
	        stmt.setString(6, soccupation);
	        stmt.setString(7, span);
	        stmt.setString(8, idNo);
	        stmt.setInt(9, Integer.parseInt(seniorcitizen));
	        stmt.setInt(10, Integer.parseInt(existingaccount));
	        
	        stmt.executeUpdate();
	        JOptionPane.showMessageDialog(null, "Enregistrement réussi!");
	        setVisible(false);
	        new SignupThree(formno).setVisible(true);
	    } catch (SQLIntegrityConstraintViolationException e) {
	        // Gérer l'exception pour les doublons
	        JOptionPane.showMessageDialog(null, "Cet enregistrement existe déjà (doublon détecté).", "Erreur", JOptionPane.ERROR_MESSAGE);
	    } catch (Exception e) {
	        // Gérer les autres exceptions
	        System.out.println(e);
	        JOptionPane.showMessageDialog(null, "Erreur lors de l'insertion dans la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private static boolean isValidPan(String pan) {
	    // Vérification si le PAN est vide ou null
	    if (pan == null || pan.trim().isEmpty()) {
	        return false; // PAN n'est pas valide s'il est vide
	    }

	    // Retirer tous les caractères non numériques
	    pan = pan.replaceAll("[^\\d]", ""); 

	    // Regex pour les cartes bancaires
	    String panRegex = "^(?:4[0-9]{12}(?:[0-9]{3})?"      // Visa
	                    + "|5[1-5][0-9]{14}"                // MasterCard
	                    + "|3[47][0-9]{13}"                 // American Express
	                    + "|6(?:011|5[0-9]{2})[0-9]{12}"    // Discover
	                    + "|3(?:0[0-5]|[68][0-9])[0-9]{11}" // Diners Club
	                    + "|(?:2131|1800|35\\d{3})\\d{11})$"; // JCB

	    // Vérification du format du PAN
	    if (!pan.matches(panRegex)) {
	        return false; // Le PAN n'est pas conforme à la regex
	    }

	    // Vérification si le PAN existe déjà dans la base de données
	    return !doesPanExist(pan); // Retourne true si le PAN n'existe pas
	}

	private static boolean doesPanExist(String pan) {
	    try {
	        Conn c = new Conn();
	        String query = "SELECT COUNT(*) FROM signuptwo WHERE pan = ?";
	        PreparedStatement stmt = c.c.prepareStatement(query);
	        stmt.setString(1, pan);
	        ResultSet rs = stmt.executeQuery();

	        return rs.next() && rs.getInt(1) > 0; // Retourne true si le PAN existe déjà
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return true; // Retourne true pour signaler une erreur lors de la vérification
	    }
	}

	private static boolean isValidIdentityNumber(String idNo) {
	    // Regex pour 12 chiffres exacts
	    String identityRegex = "^\\d{12}$";

	    // Vérification de la longueur et du format du numéro d'identité
	    if (!idNo.matches(identityRegex)) {
	        return false; // Le numéro d'identité n'est pas valide
	    }

	    // Vérification si le numéro d'identité existe déjà dans la base de données
	    return !doesIdNoExist(idNo); // Retourne true si le numéro ID n'existe pas
	}

	private static boolean doesIdNoExist(String idNo) {
	    try {
	        Conn c = new Conn();
	        String query = "SELECT COUNT(*) FROM signuptwo WHERE idNo = ?";
	        PreparedStatement stmt = c.c.prepareStatement(query);
	        stmt.setString(1, idNo);
	        ResultSet rs = stmt.executeQuery();

	        return rs.next() && rs.getInt(1) > 0; // Retourne true si le numéro d'identité existe déjà
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return true; // Retourne true pour signaler une erreur lors de la vérification
	    }
	}


	public static void main(String[] args) {
		new SignupTwo("");

	}


}
