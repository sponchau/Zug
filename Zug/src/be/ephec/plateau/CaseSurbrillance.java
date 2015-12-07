package be.ephec.plateau;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CaseSurbrillance extends Case implements MouseListener{
	
	private int x;
	private int y;
	
	public CaseSurbrillance (int x, int y) {
		super ();
		
		this.x= x;
		this.y = y;
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
