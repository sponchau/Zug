package be.ephec.plateau;

import java.awt.Color;
import java.awt.event.MouseListener;

public class CaseVideBlanche extends Case{
	public CaseVideBlanche () {
		super ();
		super.setBackground(new Color (255, 244, 141));
		setLayout(super.gridCase);
	}
}
