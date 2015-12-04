package be.ephec.reseau.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import be.ephec.reseau.Lanceur;
import be.ephec.reseau.Plateau;

public class ClientDuServeur implements Runnable{
		private Socket socket;
		private static ObjectInputStream ois;
		private static ObjectOutputStream oos;
		private Lanceur leLanceur;
		
		public ClientDuServeur(Socket socket, Lanceur leLanceur){
			this.leLanceur = leLanceur;
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
					Plateau plat = new Plateau (o.toString(), leLanceur);
					leLanceur.getInterfaceGraphique().setContentPane(plat);
					leLanceur.getInterfaceGraphique().setVisible(true);
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

