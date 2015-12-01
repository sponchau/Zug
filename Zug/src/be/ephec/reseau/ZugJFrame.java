package be.ephec.reseau;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ZugJFrame extends JFrame {

	private JPanel contentPane;

	public ZugJFrame(Lanceur leLanceur) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setContentPane(new FenetreAcceuil(leLanceur));
		this.setTitle("Zug");
		this.setVisible(true);
	}

}
