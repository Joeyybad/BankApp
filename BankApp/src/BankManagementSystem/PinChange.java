package BankManagementSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
	JTextField pin, repin;
    JButton change, back;
    String pinnumber;

    PinChange(String pinchange) {
        this.pinnumber = pinchange;
        setLayout(null);

        // Ajouter une image de fond
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Ajouter un titre
        JLabel text = new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        // Nouveau PIN
        JLabel pintext = new JLabel("New PIN :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System", Font.BOLD, 16));
        pintext.setBounds(160, 320, 180, 25);
        image.add(pintext);

        pin = new JTextField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        // Confirmer le nouveau PIN
        JLabel repintext = new JLabel("Re-enter New PIN ");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System", Font.BOLD, 16));
        repintext.setBounds(160, 360, 180, 25);
        image.add(repintext);

        repin = new JTextField();
        repin.setFont(new Font("Raleway", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        // Bouton de changement de PIN
        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        // Bouton retour
        back = new JButton("Back");
        back.setBounds(355, 522, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                if (!npin.equals(rpin)) {
                    throw new IllegalArgumentException("Les PINs ne correspondent pas.");
                }

                if (npin.isEmpty() || rpin.isEmpty()) {
                    throw new IllegalArgumentException("Veuillez remplir tous les champs.");
                }

                Conn c = new Conn();
                DatabaseHandler dbHandler = new DatabaseHandler(c.c);
                PinHandler pinHandler = new PinHandler(dbHandler);

                boolean success = pinHandler.pinChange(pinnumber, npin);

                if (success) {
                    JOptionPane.showMessageDialog(null, "PIN changé avec succès.");
                    setVisible(false);
                    new Transactions(npin).setVisible(true); // Naviguer avec le nouveau PIN
                } else {
                    JOptionPane.showMessageDialog(null, "Erreur lors du changement de PIN.");
                }
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erreur inattendue : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
