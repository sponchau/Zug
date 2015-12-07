package be.ephec.reseau.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import be.ephec.deplacement.DeplacementPion;
import be.ephec.global.VariablesGlobales;
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
					Object o = ois.readObject();
					
					String monTableauS[] = o.toString().split(",");
					int monTableauI[] = {-1,-1};
					monTableauI[0] = (int) Integer.parseInt(monTableauS[0]);
					monTableauI[1] = (int) Integer.parseInt(monTableauS[1]);
					
					DeplacementPion deplacement = new DeplacementPion(true, monTableauI[0], monTableauI[1]);
					//Plateau plat = new Plateau (o.toString());
					//VariablesGlobales.leLanceur.getInterfaceGraphique().setContentPane(plat);
					//VariablesGlobales.leLanceur.getInterfaceGraphique().setVisible(true);
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

