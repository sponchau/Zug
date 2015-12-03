package be.ephec.reseau.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

import be.ephec.reseau.Lanceur;


public class SocketServeur extends ServerSocket implements Runnable{
	
	private ClientDuServeur cds;
	private Lanceur leLanceur;

	public SocketServeur (int port, Lanceur leLanceur) throws IOException {
		super (port);
		accepterClient ();
	}
	
	public void accepterClient () {
		new Thread(this).start();	
	}

	
	@Override
	public void run() {
		try {
			cds = new ClientDuServeur(this.accept(), leLanceur);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}
}
