package be.ephec.plateau;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.JPanel;

import be.ephec.global.VariablesGlobales;
import be.ephec.reseau.Lanceur;

public class Plateau extends JPanel{

	private GridLayout monGrid;
	
	public Plateau (String coordonnees) {
		monGrid = new GridLayout(VariablesGlobales.TAILLE, 0, 0, 0);
		
		//affichage pour le Serveur
		if (VariablesGlobales.joueur == true) {
			for (int x = 0; x<VariablesGlobales.TAILLE; x++){
				for (int y=0; y<VariablesGlobales.TAILLE; y++){
					GridBagConstraints caseG = new GridBagConstraints();
					caseG.gridx = x;
					caseG.gridy = y;
					add(VariablesGlobales.tabPlateau[x][y], caseG);
					}
				}
		}
		
		//affichage inversé pour le client
		else {
			for (int x = VariablesGlobales.TAILLE-1; x>=0; x--){
				for (int y=VariablesGlobales.TAILLE-1; y>=0; y--){
					GridBagConstraints caseG = new GridBagConstraints();
					caseG.gridx = x;
					caseG.gridy = y;
					add(VariablesGlobales.tabPlateau[x][y], caseG);
					}
				}
		}
		
		setLayout(monGrid);
		
		VariablesGlobales.leLanceur.getInterfaceGraphique().setContentPane(this);
		VariablesGlobales.leLanceur.getInterfaceGraphique().setVisible(true);		
		}
}
