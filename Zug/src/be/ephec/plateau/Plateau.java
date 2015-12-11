package be.ephec.plateau;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;

import be.ephec.global.VariablesGlobales;

public class Plateau extends JPanel{

	private GridLayout monGrid;
	
	public Plateau () {
		monGrid = new GridLayout(VariablesGlobales.TAILLE, 0, 0, 0);
		
		//affichage pour le Serveur
		if (VariablesGlobales.joueur == "serveur") {
			for (int x = 1; x<VariablesGlobales.TAILLE+1; x++){
				for (int y=1; y<VariablesGlobales.TAILLE+1; y++){
					GridBagConstraints caseG = new GridBagConstraints();
					caseG.gridx = x;
					caseG.gridy = y;
					
					if (x == 4 || x == VariablesGlobales.TAILLE-4) {
						VariablesGlobales.tabPlateau[x][y].setBorder(new CompoundBorder	(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED),
																BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK)));
					
					}
					add(VariablesGlobales.tabPlateau[x][y], caseG);
					}
				}
		}
		
		//affichage inversé pour le client
		else {
			for (int x = VariablesGlobales.TAILLE; x>0; x--){
				for (int y=VariablesGlobales.TAILLE; y>0; y--){
					GridBagConstraints caseG = new GridBagConstraints();
					caseG.gridx = x;
					caseG.gridy = y;
					
					if (x == 5 || x == VariablesGlobales.TAILLE-3) {
						VariablesGlobales.tabPlateau[x][y].setBorder(new CompoundBorder	(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.RED),
																BorderFactory.createMatteBorder(1, 1, 0, 1, Color.BLACK)));
					
					}
					
					add(VariablesGlobales.tabPlateau[x][y], caseG);
					}
				}
		}
		
		setLayout(monGrid);
		
		VariablesGlobales.leLanceur.getInterfaceGraphique().setContentPane(this);
		VariablesGlobales.leLanceur.getInterfaceGraphique().setVisible(true);		
		}
}
