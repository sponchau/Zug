package be.ephec.reseau.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClient extends Socket implements Runnable{
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void lireEnBoucle () {
		new Thread(this).start();
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!this.isClosed()){
			try {
				Object o = ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
