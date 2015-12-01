package be.ephec.reseau;

import javax.swing.JFrame;

public class Lanceur {
	private ZugJFrame interfaceGraphique;
	
	public Lanceur () {
		interfaceGraphique = new ZugJFrame(this);
	}
	
public static void main(String[] args) {
	Lanceur leLanceur = new Lanceur ();
	}

public ZugJFrame getInterfaceGraphique() {
	return interfaceGraphique;
}

public void setInterfaceGraphique(ZugJFrame interfaceGraphique) {
	this.interfaceGraphique = interfaceGraphique;
}


}
