package be.ephec.reseau.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import be.ephec.deplacement.DeplacementPion;
import be.ephec.deplacement.DeplacementSurbrillance;
import be.ephec.deplacement.FinDeJeu;
import be.ephec.global.VariablesGlobales;
import be.ephec.plateau.CaseSurbrillance;
import be.ephec.plateau.Plateau;
import be.ephec.reseau.Lanceur;

public class SocketClient extends Socket implements Runnable{
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	private Thread t;
	
	public SocketClient (String ip, int port) throws UnknownHostException, IOException{
		super(ip, port);
		ouvertureStream();
	}
	
	public void ouvertureStream () {
		try {
			oos = new ObjectOutputStream(this.getOutputStream());
			ois = new ObjectInputStream(this.getInputStream());
			lireEnBoucle ();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void lireEnBoucle () {
		
		t = new Thread(this);
		t.start();
	}
	
	
	/**
	 * envoie un objet au serveur
	 * @param o  Objet à envoyer au serveur
	 */
	public static void ecrire(Object o){
		try {
			oos.writeObject(o);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (!this.isClosed()){
			try {
				Object o = ois.readObject(); //réception d'un objet venant du serveur
				String monTableauS[] = o.toString().split(","); //séparer les éléments du string reçu et les mettre dans le tableau : monTableauS
				int monTableauI[] = {-1,-1}; //déclaration d'un tableau d'entier qui recevra les coordonnées envoyées par le serveur
				monTableauI[0] = (int) Integer.parseInt(monTableauS[0]); // insertion des coordonnées recupérées au dessus dans le tableau d'entiers
				monTableauI[1] = (int) Integer.parseInt(monTableauS[1]); // insertion des coordonnées recupérées au dessus dans le tableau d'entiers
				
				//répéter les déplacements adverses chez nous lors d'un clic sur une case en subrillance
				if (VariablesGlobales.tabPlateau[monTableauI[0]] [monTableauI[1]] instanceof CaseSurbrillance) {
					new DeplacementSurbrillance(monTableauI[0], monTableauI[1], false);
					}
				//répéter les calculs des cases en subrillance chez nous
				else {DeplacementPion deplacement = new DeplacementPion("blanc", monTableauI[0], monTableauI[1]);}
					
				//tester si la partie est finie
				FinDeJeu fin = new FinDeJeu ();
				fin.testFin("blanc");
				
				
				if (monTableauS[2] != " ") VariablesGlobales.joueurQuiJoue = Boolean.parseBoolean(monTableauS[2]); //prend ou non la main en fonction de ce que le serveur envoie

				
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
			}
				
		}
	}
}
