package be.ephec.deplacement;

import be.ephec.global.VariablesGlobales;
import be.ephec.reseau.client.SocketClient;
import be.ephec.reseau.serveur.ClientDuServeur;

public class PasserLaMain {
	
	public PasserLaMain (int x, int y, boolean saut) {
		if (VariablesGlobales.joueur == "serveur" && VariablesGlobales.joueurQuiJoue == true) {
			
			if (saut == false) {
				VariablesGlobales.desactiverPions = false;
				VariablesGlobales.joueurQuiJoue = false;
				DeplacementPion.precedentEstUnSaut = false;
				ClientDuServeur.ecrire(x+","+y+",true");
				FinDeJeu fin = new FinDeJeu();
			}
			else {
				VariablesGlobales.desactiverPions = true;
				ClientDuServeur.ecrire(x+","+y+",false");
				new DeplacementPion ("blanc", x, y);
			}
		}
		
		
		else if (VariablesGlobales.joueur == "client" && VariablesGlobales.joueurQuiJoue == true) {
			
			if (saut == false) {
				VariablesGlobales.desactiverPions = false;
				VariablesGlobales.joueurQuiJoue = false;
				DeplacementPion.precedentEstUnSaut = false;
				SocketClient.ecrire(x+","+y+",true");
				FinDeJeu fin = new FinDeJeu();
			}
			else  {
				VariablesGlobales.desactiverPions = true;
				SocketClient.ecrire(x+","+y+",false");
				new DeplacementPion ("noir", x, y);
			}
		}
	}
}
