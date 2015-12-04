package be.ephec.reseau.serveur;

import java.io.IOException;
import java.net.ServerSocket;

import be.ephec.reseau.Lanceur;


public class SocketServeur extends ServerSocket implements Runnable{
	
	private Lanceur leLanceur;

	public SocketServeur (int port, Lanceur leLanceur) throws IOException {
		super (port);
		this.leLanceur = leLanceur;
		accepterClient ();
	}
	
	public void accepterClient () {
		new Thread(this).start();	
	}

	
	@Override
	public void run() {
		try {
			new ClientDuServeur(this.accept(), leLanceur);
		} catch (IOException e) {
			e.printStackTrace();
		}	
}
}
