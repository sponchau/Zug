package be.ephec.reseau.serveur;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.ephec.global.VariablesGlobales;
import be.ephec.plateau.InitPlateau;
import be.ephec.plateau.Plateau;
import be.ephec.reseau.Lanceur;

public class ServeurGraphiqueAcceuil extends JPanel implements ActionListener{
	private JTextField textFieldPort;


	public ServeurGraphiqueAcceuil() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{84, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{55, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JButton btnDemarrer = new JButton("d\u00E9marrer le serveur");
		btnDemarrer.addActionListener(this);
		
		JLabel lblPort = new JLabel("port : ");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 2;
		gbc_lblPort.gridy = 1;
		add(lblPort, gbc_lblPort);
		
		textFieldPort = new JTextField("62900");
		GridBagConstraints gbc_textFieldPort = new GridBagConstraints();
		gbc_textFieldPort.anchor = GridBagConstraints.WEST;
		gbc_textFieldPort.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPort.gridx = 4;
		gbc_textFieldPort.gridy = 1;
		add(textFieldPort, gbc_textFieldPort);
		textFieldPort.setColumns(15);
		GridBagConstraints gbc_btnDemarrer = new GridBagConstraints();
		gbc_btnDemarrer.anchor = GridBagConstraints.WEST;
		gbc_btnDemarrer.gridx = 4;
		gbc_btnDemarrer.gridy = 2;
		add(btnDemarrer, gbc_btnDemarrer);

		setBackground(new Color(221, 239, 255));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			
			VariablesGlobales.joueurQuiJoue = false;  //le serveur ne peut pas joueur tant que le client n'est pas connect�
			VariablesGlobales.joueur = "serveur"; // on est du c�t� du serveur
			
			SocketServeur ss = new SocketServeur (Integer.parseInt(textFieldPort.getText())); //ouverture d'un socket pour le client
			
			InitPlateau initPlateau = new InitPlateau(); // initialisation du plateau de jeu
			Plateau monPlateau = new Plateau();  // affichage du plateau de jeu
			
			VariablesGlobales.leLanceur.getInterfaceGraphique().setContentPane(monPlateau); //chargement de l'affichage du plateau dans la JFrame
			VariablesGlobales.leLanceur.getInterfaceGraphique().setSize(700, 700); //redimentionnement de la JFrame pour l'adapter � la taille du plateau
			VariablesGlobales.leLanceur.getInterfaceGraphique().setVisible(true); // afficher la JFrame
			
			JOptionPane.showMessageDialog(null, "En attente du client"); //demander au serveur de patienter en attendant le client
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}

