package be.ephec.reseau;

import javax.swing.JPanel;

import be.ephec.reseau.serveur.ClientDuServeur;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Plateau extends JPanel implements ActionListener{

	
	public Plateau(String coordonnee, Lanceur leLanceur) {
		String monTableauS[] = coordonnee.split(",");
		int monTableauI[] = {-1,-1};
		monTableauI[0] = (int) Integer.parseInt(monTableauS[0]);
		monTableauI[1] = (int) Integer.parseInt(monTableauS[1]);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCoucou = new JLabel(monTableauS[0]);
		GridBagConstraints gbc_lblCoucou = new GridBagConstraints();
		gbc_lblCoucou.insets = new Insets(0, 0, 5, 0);
		gbc_lblCoucou.gridx = 6;
		gbc_lblCoucou.gridy = 3;
		add(lblCoucou, gbc_lblCoucou);
		
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(this);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 5;
		add(btnNewButton, gbc_btnNewButton);
		
		//leLanceur.getInterfaceGraphique().setContentPane(this);
		//leLanceur.getInterfaceGraphique().setVisible(true);
	}
	
	public JPanel initPlateau () {
		return this;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		ClientDuServeur.ecrire ("3,2");
		
	}

}
