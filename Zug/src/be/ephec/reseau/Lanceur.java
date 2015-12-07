package be.ephec.reseau;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import be.ephec.global.VariablesGlobales;

public class Lanceur {
	private ZugJFrame interfaceGraphique;
	
	public Lanceur () {
		VariablesGlobales.leLanceur = this;
		interfaceGraphique = new ZugJFrame();
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
