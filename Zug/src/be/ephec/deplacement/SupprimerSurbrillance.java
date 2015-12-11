package be.ephec.deplacement;

import be.ephec.global.VariablesGlobales;
import be.ephec.plateau.CaseSurbrillance;
import be.ephec.plateau.CaseVideNoire;

public class SupprimerSurbrillance {
	public SupprimerSurbrillance (){
		
		for (int i = 0; i<VariablesGlobales.TAILLE+2; i++){
			for (int j = 0; j<VariablesGlobales.TAILLE+2; j++) {
				if (VariablesGlobales.tabPlateau[i][j] instanceof CaseSurbrillance) {
					VariablesGlobales.tabPlateau[i][j] = new CaseVideNoire();
				}
			}
		}
	}
}
