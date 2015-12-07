package be.ephec.global;

import javax.swing.JPanel;

import be.ephec.reseau.Lanceur;

public class VariablesGlobales {
	public final static int TAILLE = 17;
	public static boolean joueur; //variable à true si on est du côté du serveur et à false si on est du côté du client
	public static boolean joueurQuiJoue;
	public static JPanel tabPlateau[][]= new JPanel [TAILLE][TAILLE];
	public static Lanceur leLanceur;
	
}
