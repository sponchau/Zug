package be.ephec.plateau;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import be.ephec.deplacement.DeplacementPion;
import be.ephec.global.VariablesGlobales;

public class CasePionBlanc extends Case implements MouseListener{
	
	private int x;
	private int y;
	
	
	public CasePionBlanc(int x, int y) {
		super ();
		
		this.x= x;
		this.y = y;
		
		ImageComponent pionImage = new ImageComponent(new ImageIcon("pionBlanc.png").getImage());
		super.add(pionImage);
		setLayout(super.gridCase);
		super.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		if (VariablesGlobales.joueurQuiJoue && VariablesGlobales.joueur == "serveur" && VariablesGlobales.desactiverPions == false){
			new DeplacementPion("blanc", x, y);
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
