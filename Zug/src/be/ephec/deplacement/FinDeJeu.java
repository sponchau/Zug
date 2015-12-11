package be.ephec.deplacement;

import javax.swing.JOptionPane;

import be.ephec.global.VariablesGlobales;
import be.ephec.plateau.CasePionBlanc;
import be.ephec.plateau.CasePionNoir;

public class FinDeJeu {

	private int compteur;

	public FinDeJeu(){
		testFin ("");
	}
	
	
	public boolean testFin (String coteTest) {
	if (VariablesGlobales.joueur == "serveur" || coteTest == "blanc"){
		this.compteur = 0;
		for (int x =1; x<5; x++) {
			for (int y =1; y<VariablesGlobales.TAILLE+1; y++) {

				if ( VariablesGlobales.tabPlateau[x][y] instanceof CasePionBlanc) {
					compteur ++;
				}
			}
		}

		if (compteur >= (VariablesGlobales.TAILLE+1)/2) {
			JOptionPane.showMessageDialog(null, "Les blancs ont gagné!!!");
			VariablesGlobales.joueurQuiJoue= false;
			return true;
		}

	}


	if (VariablesGlobales.joueur == "client"  || coteTest == "noir"){
		this.compteur = 0;
		for (int x =VariablesGlobales.TAILLE-3; x<VariablesGlobales.TAILLE+1; x++) {
			for (int y =1; y<VariablesGlobales.TAILLE+1; y++) {

				if ( VariablesGlobales.tabPlateau[x][y] instanceof CasePionNoir) {
					compteur ++;
				}
			}
		}

		if (compteur >= (VariablesGlobales.TAILLE+1)/2) {
			JOptionPane.showMessageDialog(null, "Les noirs ont gagné!!!");
			VariablesGlobales.joueurQuiJoue= false;
			return true;
		}
	}
	return false;
	}
}
