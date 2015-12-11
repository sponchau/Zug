package be.ephec.global;

import javax.swing.JPanel;

import be.ephec.reseau.Lanceur;

public class VariablesGlobales {
	public final static int TAILLE = 17; // taille du tableau --> entre 9 et 101 et doit être impair
	public static String joueur; //variable à "serveur" si on est du côté du serveur et à "client" si on est du côté du client
	public static boolean joueurQuiJoue; // variable à true si on peut joue, et à false sinon
	public static JPanel tabPlateau[][]= new JPanel [TAILLE+2][TAILLE+2]; //tableau de JPanels contenant l'état du jeu
	public static Lanceur leLanceur; //JFrame du jeu
	public static boolean desactiverPions = false; 
	
}
