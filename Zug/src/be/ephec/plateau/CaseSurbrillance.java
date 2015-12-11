package be.ephec.plateau;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import be.ephec.deplacement.DeplacementSurbrillance;
import be.ephec.global.VariablesGlobales;

public class CaseSurbrillance extends Case implements MouseListener{
	
	private int x;
	private int y;
	private boolean saut;
	
	public CaseSurbrillance (int x, int y, boolean saut) {
		super ();
		
		this.x= x;
		this.y = y;
		this.saut = saut;
		
		super.setBackground(Color.YELLOW);
		setLayout(super.gridCase);
		super.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (VariablesGlobales.joueurQuiJoue == true)
		new DeplacementSurbrillance(x, y, saut);
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
