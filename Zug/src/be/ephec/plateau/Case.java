package be.ephec.plateau;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public abstract class Case extends JPanel{
	protected GridLayout gridCase;
	
	public Case () {
		gridCase = new GridLayout(1,0);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
