package be.ephec.reseau;

import javax.swing.JPanel;

import be.ephec.reseau.client.ClientGraphiqueAcceuil;
import be.ephec.reseau.serveur.ServeurGraphiqueAcceuil;

import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;

public class FenetreAcceuil extends JPanel implements ActionListener {

	private Lanceur leLanceur;
	private JButton btnCreerPartie;
	private JButton btnRejoindreLeServeur;
	private JButton btnRegle;
	private JLabel lblBienvenue;
	private JLabel label;
	private JLabel lblNewLabel;
	
	public FenetreAcceuil(Lanceur leLanceur) {
		
		this.leLanceur = leLanceur;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{78, 31, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 35, 52, 0, 57, 24, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		lblBienvenue = new JLabel("Bienvenue dans le jeu Zug !");
		lblBienvenue.setFont(new Font("Trebuchet MS", Font.ITALIC, 40));
		GridBagConstraints gbc_lblBienvenueDansLe = new GridBagConstraints();
		gbc_lblBienvenueDansLe.insets = new Insets(0, 0, 5, 5);
		gbc_lblBienvenueDansLe.gridx = 3;
		gbc_lblBienvenueDansLe.gridy = 1;
		add(lblBienvenue, gbc_lblBienvenueDansLe);
		
		label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 3;
		add(label, gbc_label);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("zug.jpg"));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 4;
		add(lblNewLabel, gbc_lblNewLabel);
		
		btnCreerPartie = new JButton("cr\u00E9er une partie");
		btnCreerPartie.addActionListener(this);
		GridBagConstraints gbc_btnCreerPartie = new GridBagConstraints();
		gbc_btnCreerPartie.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreerPartie.gridx = 2;
		gbc_btnCreerPartie.gridy = 6;
		add(btnCreerPartie, gbc_btnCreerPartie);
		
		btnRejoindreLeServeur = new JButton("rejoindre la partie");
		btnRejoindreLeServeur.addActionListener(this);
		GridBagConstraints gbc_btnRejoindreLeServeur = new GridBagConstraints();
		gbc_btnRejoindreLeServeur.insets = new Insets(0, 0, 0, 5);
		gbc_btnRejoindreLeServeur.gridx = 3;
		gbc_btnRejoindreLeServeur.gridy = 6;
		add(btnRejoindreLeServeur, gbc_btnRejoindreLeServeur);
		
		btnRegle = new JButton("r\u00E8gles du jeu");
		btnRegle.addActionListener(this);
		GridBagConstraints gbc_btnRegle = new GridBagConstraints();
		gbc_btnRegle.insets = new Insets(0, 0, 0, 5);
		gbc_btnRegle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegle.gridx = 4;
		gbc_btnRegle.gridy = 6;
		add(btnRegle, gbc_btnRegle);
		
		setBackground(new Color(221, 239, 255));
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCreerPartie){
			ServeurGraphiqueAcceuil acceuilS = new ServeurGraphiqueAcceuil(leLanceur);
			leLanceur.getInterfaceGraphique().setContentPane(acceuilS);
			leLanceur.getInterfaceGraphique().setSize(400, 250);
			leLanceur.getInterfaceGraphique().setVisible(true);
		}
		if (e.getSource() == btnRejoindreLeServeur) {
			ClientGraphiqueAcceuil acceuilC = new ClientGraphiqueAcceuil(leLanceur);
			leLanceur.getInterfaceGraphique().setContentPane(acceuilC);
			leLanceur.getInterfaceGraphique().setSize(400, 250);
			leLanceur.getInterfaceGraphique().setVisible(true);
		}
		if (e.getSource() == btnRegle) {
			ReglesDuJeu regle = new ReglesDuJeu();
			leLanceur.getInterfaceGraphique().setContentPane(regle);
			leLanceur.getInterfaceGraphique().setSize(800, 700);
			leLanceur.getInterfaceGraphique().setVisible(true);
		}
	}

}
