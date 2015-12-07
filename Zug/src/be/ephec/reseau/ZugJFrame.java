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

	public ZugJFrame() {
		JPanel panelAcceuil = new FenetreAcceuil();
		setResizable(false);
		setContentPane(panelAcceuil);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 10, 1000, 450);
		setBackground(new Color(221, 239, 255));
		this.setTitle("Zug");
		this.setVisible(true);
	}

}
