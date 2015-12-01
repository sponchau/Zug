package be.ephec.reseau.serveur;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;


public class SocketServeur extends ServerSocket implements Runnable{
	
	private ClientDuServeur cds;

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
			cds = new ClientDuServeur(this.accept());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
}
}
