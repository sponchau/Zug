package be.ephec.reseau.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import be.ephec.deplacement.DeplacementPion;
import be.ephec.global.VariablesGlobales;
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
				Object o = ois.readObject();
				String monTableauS[] = o.toString().split(",");
				int monTableauI[] = {-1,-1};
				monTableauI[0] = (int) Integer.parseInt(monTableauS[0]);
				monTableauI[1] = (int) Integer.parseInt(monTableauS[1]);
				
				DeplacementPion deplacement = new DeplacementPion(true, monTableauI[0], monTableauI[1]);
				
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
			}
				
		}
	}
}
