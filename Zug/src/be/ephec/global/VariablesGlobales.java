package be.ephec.global;

import javax.swing.JPanel;

import be.ephec.reseau.Lanceur;

public class VariablesGlobales {
	public final static int TAILLE = 17;
	public static boolean joueur; //variable � true si on est du c�t� du serveur et � false si on est du c�t� du client
	public static boolean joueurQuiJoue;
	public static JPanel tabPlateau[][]= new JPanel [TAILLE][TAILLE];
	public static Lanceur leLanceur;
	
}
