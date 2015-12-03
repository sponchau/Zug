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
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void lireEnBoucle () {
		
		t = new Thread(this);
		t.start();
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (!this.isClosed()){
			try {
				Object o = ois.readObject();
				Plateau plat = new Plateau (o.toString(), leLanceur);
				leLanceur.getInterfaceGraphique().setContentPane(plat.initPlateau());
				leLanceur.getInterfaceGraphique().setVisible(true);
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			} catch (IOException e) {
					e.printStackTrace();
			}
				
		}
	}
}
