package be.ephec.plateau;

import be.ephec.global.VariablesGlobales;
import be.ephec.reseau.Lanceur;

public class InitPlateau {
	
	public InitPlateau () {
		
	//boucles afin de parcourir le tableau
	for (int x =0; x<VariablesGlobales.TAILLE+2; x++){
		for (int y=0; y<VariablesGlobales.TAILLE+2; y++){
			
			
		  //_____________________remplissage cases vides blanches et noires (paire une ligne sur deux et impair une ligne sur deux)________________
			if ((x % 2)== 0 && (y % 2)== 0 || (y%2!=0 && x%2!=0)){
				VariablesGlobales.tabPlateau[x][y] = new CaseVideNoire();
			}
			else VariablesGlobales.tabPlateau[x][y] = new CaseVideBlanche();
		  //_______________________________________________________________________________________________________________________________________
			
			
			
		  //____________________remplissage de la première ligne noire et la première ligne blanche (chacun de son côté du tableau)________________
			for (int i= 0; i<VariablesGlobales.TAILLE; i+=2) {
			if (x==1 && y==i+1) VariablesGlobales.tabPlateau[x][y] = new CasePionNoir(x, y);
			if (x== VariablesGlobales.TAILLE && y==i+1) VariablesGlobales.tabPlateau[x][y] = new CasePionBlanc(x, y);
			}
		  //_______________________________________________________________________________________________________________________________________
			
			
			
		  //____________________remplissage de la deuxième ligne noire et la deuxième ligne blanche (chacun de son côté du tableau)________________
			for (int i= 0; i<VariablesGlobales.TAILLE; i+=6) {
				if (x==2 && y ==i+2) VariablesGlobales.tabPlateau[x][y] = new CasePionNoir(x, y);
				if (x== VariablesGlobales.TAILLE-1 && y==i+4) VariablesGlobales.tabPlateau[x][y] = new CasePionBlanc(x, y);
		  //_______________________________________________________________________________________________________________________________________
				
				
				
		  //______remplissage des contours du tableau (non affichés) avec des cases vides blanches (afin d'éviter les dépassements de tableau)_____	
			if (x==0 || x==VariablesGlobales.TAILLE+1) VariablesGlobales.tabPlateau[x][y] = new CaseVideBlanche();
			if (y==0 || y==VariablesGlobales.TAILLE+1) VariablesGlobales.tabPlateau[x][y] = new CaseVideBlanche();
		  //_______________________________________________________________________________________________________________________________________
			
			
			}
			
			
			
		}
	}
}
}
