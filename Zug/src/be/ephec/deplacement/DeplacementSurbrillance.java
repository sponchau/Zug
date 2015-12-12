package be.ephec.deplacement;

import be.ephec.global.VariablesGlobales;
import be.ephec.plateau.CasePionBlanc;
import be.ephec.plateau.CasePionNoir;
import be.ephec.plateau.CaseSurbrillance;
import be.ephec.plateau.CaseVideNoire;
import be.ephec.plateau.Plateau;
import be.ephec.reseau.client.SocketClient;
import be.ephec.reseau.serveur.ClientDuServeur;

public class DeplacementSurbrillance {
	
	private int x;
	private int y;
	private boolean saut;
	
	public DeplacementSurbrillance (int x, int y, boolean saut){
		
		this.x = x;
		this.y = y;
		this.saut = saut;
		
		new SupprimerSurbrillance(); //supprime toutes les autres cases en surbrillance
	
		//si on a précedemment cliqué sur un pion noir, la case en surbrillance sur laquelle on vient de cliquer deviendra une case avec un pion noir
		if (VariablesGlobales.tabPlateau[DeplacementPion.getAbcisse()][DeplacementPion.getOrdonnee()] instanceof CasePionNoir) 
				VariablesGlobales.tabPlateau[x][y] = new CasePionNoir(x, y);
		
		//si on a précedemment cliqué sur un pion blanc, la case en surbrillance sur laquelle on vient de cliquer deviendra une case avec un pion blanc
		else if (VariablesGlobales.tabPlateau[DeplacementPion.getAbcisse()][DeplacementPion.getOrdonnee()] instanceof CasePionBlanc) 
				VariablesGlobales.tabPlateau[x][y] = new CasePionBlanc(x, y);
		
		//on retire le pion qui était sur l'ancienne position
		VariablesGlobales.tabPlateau[DeplacementPion.getAbcisse()][DeplacementPion.getOrdonnee()] = new CaseVideNoire();
		
		new Plateau (); //on réaffiche le plateau avec les modifications
		
		if (saut == true)DeplacementPion.setPrecedentEstUnSaut(true); //si un saut a été effectue, la variable saut passe à true
		
		new PasserLaMain(x, y, saut); //on appelle la méthode passerLaMain qui va passer la main à l'autre si il a fini son tour
	}
}
