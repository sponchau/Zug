package be.ephec.reseau;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ZugJFrame extends JFrame {

	private JPanel contentPane;

	public ZugJFrame(Lanceur leLanceur) {
		JPanel panelAcceuil = new FenetreAcceuil(leLanceur);
		setResizable(false);
		setContentPane(panelAcceuil);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100, 1000, 450);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Zug");
		this.setVisible(true);
	}

}
