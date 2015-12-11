package be.ephec.reseau.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import be.ephec.deplacement.DeplacementPion;
import be.ephec.deplacement.DeplacementSurbrillance;
import be.ephec.deplacement.FinDeJeu;
import be.ephec.global.VariablesGlobales;
import be.ephec.plateau.CaseSurbrillance;
import be.ephec.plateau.Plateau;
import be.ephec.reseau.Lanceur;

public class ClientDuServeur implements Runnable{
		private Socket socket;
		private static ObjectInputStream ois;
		private static ObjectOutputStream oos;
		
		public ClientDuServeur(Socket socket){
			this.socket = socket;
			try {
				ois = new ObjectInputStream(socket.getInputStream());
				oos = new ObjectOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new Thread(this).start();
		}
		
		
		/**
		 * envoie un objet au client
		 * @param o  Objet à envoyer au client
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
			while (!socket.isClosed()){
				try {
					
					Object o = ois.readObject(); //réception d'un objet venant du client
					
					String monTableauS[] = o.toString().split(","); //séparer les éléments du string reçu et les mettre dans le tableau : monTableauS
					int monTableauI[] = {-1,-1}; //déclaration d'un tableau d'entier qui recevra les coordonnées envoyées par le client
					monTableauI[0] = (int) Integer.parseInt(monTableauS[0]); // insertion des coordonnées recupérées au dessus dans le tableau d'entiers
					monTableauI[1] = (int) Integer.parseInt(monTableauS[1]); // insertion des coordonnées recupérées au dessus dans le tableau d'entiers
					
					// si monTableauI[1] = -1 c'est que le client vient de se connecter, donc le seveur à le droit de commencer
					if (monTableauI[1]==-1) {
						VariablesGlobales.joueurQuiJoue = true;
						JOptionPane.showMessageDialog(null, "Le client est connecté, vous pouvez jouer"); // on prévient le serveur qu'il peut commencer
					}
					
					if (VariablesGlobales.joueurQuiJoue == false) {
						if (VariablesGlobales.tabPlateau[monTableauI[0]] [monTableauI[1]] instanceof CaseSurbrillance) {new DeplacementSurbrillance(monTableauI[0], monTableauI[1], false);}
						else {DeplacementPion deplacement = new DeplacementPion("noir", monTableauI[0], monTableauI[1]);}
					}
					
					FinDeJeu fin = new FinDeJeu ();
					fin.testFin("noir");
					
					if (monTableauS[2] != " ") VariablesGlobales.joueurQuiJoue = Boolean.parseBoolean(monTableauS[2]);

				
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		
	}

