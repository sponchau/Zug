package be.ephec.plateau;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.sun.prism.Graphics;

import be.ephec.deplacement.DeplacementPion;
import be.ephec.global.VariablesGlobales;
import be.ephec.reseau.Lanceur;


public class CasePionNoir extends Case implements MouseListener{
	private int x;
	private int y;
	
	public CasePionNoir(int x, int y) {
			super ();
			
			this.x= x;
			this.y = y;
			
			ImageComponent pionImage = new ImageComponent(new ImageIcon("pionNoir.jpg").getImage());
			super.add(pionImage);
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
		// TODO Auto-generated method stub
		//vérifie si c'est bien à notre tour de jouer
				if (VariablesGlobales.joueurQuiJoue && VariablesGlobales.joueur == "client" && VariablesGlobales.desactiverPions == false){
						new DeplacementPion("noir", x, y);
					}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
