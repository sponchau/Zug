package be.ephec.reseau.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.SwingUtilities;

import be.ephec.reseau.Lanceur;
import be.ephec.reseau.Plateau;

public class SocketClient extends Socket implements Runnable{
	private static ObjectOutputStream oos;
	private static ObjectInputStream ois;
	private Lanceur leLanceur;
	private Thread t;
	
	public SocketClient (String ip, int port, Lanceur leLanceur) throws UnknownHostException, IOException{
		super(ip, port);
		this.leLanceur = leLanceur;
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
				Plateau plat = new Plateau (o.toString(), leLanceur);
				leLanceur.getInterfaceGraphique().setContentPane(plat);
				leLanceur.getInterfaceGraphique().setVisible(true);
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
			}
				
		}
	}
}
