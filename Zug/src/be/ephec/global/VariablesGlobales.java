package be.ephec.global;

import javax.swing.JPanel;

import be.ephec.reseau.Lanceur;

public class VariablesGlobales {
	public final static int TAILLE = 17; // taille du tableau --> entre 9 et 101 et doit �tre impair
	public static String joueur; //variable � "serveur" si on est du c�t� du serveur et � "client" si on est du c�t� du client
	public static boolean joueurQuiJoue; // variable � true si on peut joue, et � false sinon
	public static JPanel tabPlateau[][]= new JPanel [TAILLE+2][TAILLE+2]; //tableau de JPanels contenant l'�tat du jeu
	public static Lanceur leLanceur; //JFrame du jeu
	public static boolean desactiverPions = false; 
	
}
