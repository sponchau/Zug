package be.ephec.reseau.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientDuServeur implements Runnable{
		private Socket socket;
		private ObjectInputStream ois;
		private ObjectOutputStream oos;

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
		
		
		
		public void ecrire(Object o){
			try {
				oos.writeObject(o);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public Object lire() throws ClassNotFoundException, IOException{
			return ois.readObject();
		}

		@Override
		public void run() {
			while (!socket.isClosed()){
				Object object;
				try {
					object = lire();
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

