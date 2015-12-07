package be.ephec.plateau;

import be.ephec.global.VariablesGlobales;
import be.ephec.reseau.Lanceur;

public class InitPlateau {
	
	public InitPlateau () {
	for (int x = 0; x<VariablesGlobales.TAILLE; x++){
		for (int y=0; y<VariablesGlobales.TAILLE; y++){
			if (x==3 && y==3) VariablesGlobales.tabPlateau[x][y] = new CasePionNoir(x, y);
			else if (x==15 && y==15) VariablesGlobales.tabPlateau[x][y] = new CasePionBlanc(x, y);
			else if ((x % 2)== 0 && (y % 2)== 0 || (y%2!=0 && x%2!=0)){
				VariablesGlobales.tabPlateau[x][y] = new CaseVideNoire();
			}
			else VariablesGlobales.tabPlateau[x][y] = new CaseVideBlanche();
			}
			
		}
	}
}
