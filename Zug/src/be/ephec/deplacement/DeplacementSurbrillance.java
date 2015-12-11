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
		
		new SupprimerSurbrillance();
	
		if (VariablesGlobales.tabPlateau[DeplacementPion.abcisse][DeplacementPion.ordonnee] instanceof CasePionNoir) 
				VariablesGlobales.tabPlateau[x][y] = new CasePionNoir(x, y);
		else if (VariablesGlobales.tabPlateau[DeplacementPion.abcisse][DeplacementPion.ordonnee] instanceof CasePionBlanc) 
				VariablesGlobales.tabPlateau[x][y] = new CasePionBlanc(x, y);
		VariablesGlobales.tabPlateau[DeplacementPion.abcisse][DeplacementPion.ordonnee] = new CaseVideNoire();
		new Plateau ();
		
		if (saut == true)DeplacementPion.precedentEstUnSaut = true;
		
		new PasserLaMain(x, y, saut);
	}
}
