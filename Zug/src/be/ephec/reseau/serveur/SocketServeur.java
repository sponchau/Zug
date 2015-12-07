package be.ephec.reseau.serveur;

import java.io.IOException;
import java.net.ServerSocket;

import be.ephec.global.VariablesGlobales;
import be.ephec.reseau.Lanceur;


public class SocketServeur extends ServerSocket implements Runnable{

	public SocketServeur (int port) throws IOException {
		super (port);
		accepterClient ();
	}
	
	public void accepterClient () {
		new Thread(this).start();	
	}

	
	@Override
	public void run() {
		try {
			new ClientDuServeur(this.accept());
		} catch (IOException e) {
			e.printStackTrace();
		}	
}
}
