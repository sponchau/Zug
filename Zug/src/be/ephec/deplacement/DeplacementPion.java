package be.ephec.deplacement;

import java.net.Socket;

import be.ephec.global.VariablesGlobales;
import be.ephec.plateau.CasePionBlanc;
import be.ephec.plateau.CasePionNoir;
import be.ephec.plateau.CaseSurbrillance;
import be.ephec.plateau.CaseVideBlanche;
import be.ephec.plateau.CaseVideNoire;
import be.ephec.plateau.Plateau;
import be.ephec.reseau.Lanceur;
import be.ephec.reseau.client.SocketClient;
import be.ephec.reseau.serveur.ClientDuServeur;

public class DeplacementPion {
	public static int abcisse;
	public static int ordonnee;
	public static boolean saut;
	public static boolean precedentEstUnSaut = false;
	private boolean finTour = true;
	
	public DeplacementPion (String couleurPion, int x, int y) {
		
			this.abcisse = x;
			this.ordonnee = y;
			
			new SupprimerSurbrillance();
			
			if (couleurPion=="noir") {
				calculSurbrillance(x, y, 1, 1);
				calculSurbrillance(x, y, 1, -1);
			}
			
			else {
				calculSurbrillance(x, y, -1, -1);
				calculSurbrillance(x, y, -1, 1);
			}
		
		new Plateau ();
		
		if (finTour) new PasserLaMain(x, y, false);
		
		if (VariablesGlobales.joueur == "serveur" && VariablesGlobales.joueurQuiJoue==true) ClientDuServeur.ecrire(x+","+y+", ");
		else if (VariablesGlobales.joueur == "client" && VariablesGlobales.joueurQuiJoue==true) SocketClient.ecrire(x+","+y+", ");
	}
	
	
	
	public void calculSurbrillance (int abcisse, int ordonnee, int directionX, int directionY) {
		abcisse +=directionX;
		ordonnee +=directionY;
		
		if (VariablesGlobales.tabPlateau[abcisse][ordonnee] instanceof CaseVideNoire ||VariablesGlobales.tabPlateau[abcisse][ordonnee] instanceof CaseSurbrillance){
			saut = false;
			finTour = false;
			VariablesGlobales.tabPlateau[abcisse][ordonnee] = new CaseSurbrillance (abcisse, ordonnee, saut);
			}
		
		else if (VariablesGlobales.tabPlateau[abcisse][ordonnee] instanceof CaseVideBlanche) {}
		
		//si les cases en diagonales ne sont pas vide, regarder si la suivante sur la diagonale l'es, et si c'est le cas la mettre en surbrillance
		else if (VariablesGlobales.tabPlateau[abcisse+directionX][ordonnee+directionY] instanceof CaseVideNoire){
			finTour = false;
			saut = true;
			VariablesGlobales.tabPlateau[abcisse+directionX][ordonnee+directionY] = new CaseSurbrillance (abcisse+directionX, ordonnee+directionY, saut);	
		};
	}
	
}
