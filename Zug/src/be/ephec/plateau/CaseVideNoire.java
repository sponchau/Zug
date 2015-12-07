package be.ephec.plateau;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CaseVideNoire extends Case{
	
	public CaseVideNoire () {
		super ();
		super.setBackground(new Color (174, 100, 45));
		setLayout(super.gridCase);
		
	}
}
