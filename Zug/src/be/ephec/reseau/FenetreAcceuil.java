package be.ephec.reseau;

import javax.swing.JPanel;

import be.ephec.reseau.client.ClientGraphiqueAcceuil;
import be.ephec.reseau.serveur.ServeurGraphiqueAcceuil;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FenetreAcceuil extends JPanel implements ActionListener {

	private Lanceur leLanceur;
	private JButton btnCreerPartie;
	private JButton btnRejoindreLeServeur;
	private JButton btnRegle;
	
	public FenetreAcceuil(Lanceur leLanceur) {
		this.leLanceur = leLanceur;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{78, 67, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{35, 35, 52, 0, 57, 24, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnCreerPartie = new JButton("cr\u00E9er une partie");
		btnCreerPartie.addActionListener(this);
		GridBagConstraints gbc_btnCreerPartie = new GridBagConstraints();
		gbc_btnCreerPartie.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreerPartie.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreerPartie.gridx = 6;
		gbc_btnCreerPartie.gridy = 1;
		add(btnCreerPartie, gbc_btnCreerPartie);
		
		btnRejoindreLeServeur = new JButton("rejoindre la partie");
		btnRejoindreLeServeur.addActionListener(this);
		GridBagConstraints gbc_btnRejoindreLeServeur = new GridBagConstraints();
		gbc_btnRejoindreLeServeur.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRejoindreLeServeur.insets = new Insets(0, 0, 5, 0);
		gbc_btnRejoindreLeServeur.gridx = 6;
		gbc_btnRejoindreLeServeur.gridy = 3;
		add(btnRejoindreLeServeur, gbc_btnRejoindreLeServeur);
		
		btnRegle = new JButton("r\u00E8gles du jeu");
		btnRegle.addActionListener(this);
		GridBagConstraints gbc_btnRegle = new GridBagConstraints();
		gbc_btnRegle.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRegle.gridx = 6;
		gbc_btnRegle.gridy = 5;
		add(btnRegle, gbc_btnRegle);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCreerPartie){
			ServeurGraphiqueAcceuil acceuilS = new ServeurGraphiqueAcceuil(leLanceur);
			leLanceur.getInterfaceGraphique().setContentPane(acceuilS);
			leLanceur.getInterfaceGraphique().setVisible(true);
		}
		if (e.getSource() == btnRejoindreLeServeur) {
			ClientGraphiqueAcceuil acceuilC = new ClientGraphiqueAcceuil(leLanceur);
			leLanceur.getInterfaceGraphique().setContentPane(acceuilC);
			leLanceur.getInterfaceGraphique().setVisible(true);
		}
		if (e.getSource() == btnRegle) {}
	}

}
