package be.ephec.deplacement;

import java.net.Socket;

import be.ephec.global.VariablesGlobales;
import be.ephec.plateau.CaseSurbrillance;
import be.ephec.plateau.CaseVideBlanche;
import be.ephec.plateau.CaseVideNoire;
import be.ephec.plateau.Plateau;
import be.ephec.reseau.Lanceur;
import be.ephec.reseau.client.SocketClient;
import be.ephec.reseau.serveur.ClientDuServeur;

public class DeplacementPion {
	public DeplacementPion (boolean couleurPion, int x, int y) {

			//vérifie si c'est bien un de nos pions qui est sélectionné
			if (couleurPion==true) {
				
				//si les case en diagonale son vide, les mettre en surbrillance
				if (VariablesGlobales.tabPlateau[x+1][y+1] instanceof CaseVideNoire || VariablesGlobales.tabPlateau[x+1][y+1] instanceof CaseSurbrillance){
					VariablesGlobales.tabPlateau[x+1][y+1] = new CaseSurbrillance (x+1, y+1);

				}
				//si les cases en diagonales ne sont pas vide, regarder si la suivante sur la diagonale l'es, et si c'est le cas la mettre en surbrillance
				else if (VariablesGlobales.tabPlateau[x+2][y+2] instanceof CaseVideNoire){
					VariablesGlobales.tabPlateau[x+2][y+2] = new CaseSurbrillance (x+2, y+2);
				};
				
				
				//si les case en diagonale son vide, les mettre en surbrillance
				if (VariablesGlobales.tabPlateau[x+1][y-1] instanceof CaseVideNoire|| VariablesGlobales.tabPlateau[x+1][y+1] instanceof CaseSurbrillance){
					VariablesGlobales.tabPlateau[x+1][y-1] = new CaseSurbrillance (x+1, y+1);
				}
				//si les cases en diagonales ne sont pas vide, regarder si la suivante sur la diagonale l'es, et si c'est le cas la mettre en surbrillance
				else if (VariablesGlobales.tabPlateau[x+2][y-2] instanceof CaseVideNoire){
					VariablesGlobales.tabPlateau[x+2][y-2] = new CaseSurbrillance (x+2, y-2);
				};
				
				
					
			}
			
		new Plateau ("-1, -1");
		if (VariablesGlobales.joueur == true) ClientDuServeur.ecrire(x+","+y);
		else SocketClient.ecrire(x+","+y);
		
	}
}
