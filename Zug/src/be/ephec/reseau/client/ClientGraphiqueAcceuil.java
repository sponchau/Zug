package be.ephec.reseau.client;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import be.ephec.global.VariablesGlobales;
import be.ephec.plateau.InitPlateau;
import be.ephec.plateau.Plateau;
import be.ephec.reseau.Lanceur;

public class ClientGraphiqueAcceuil extends JPanel implements ActionListener{
	private JTextField textFieldIp;
	private JTextField textFieldPort;
	private JButton btnConnection;
	private JLabel lblErreur;

	/**
	 * Create the panel.
	 */
	public ClientGraphiqueAcceuil() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{89, 67, 0, 0};
		gridBagLayout.rowHeights = new int[]{70, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnConnection = new JButton("connection");
		btnConnection.addActionListener(this);
		
		JLabel lblIp = new JLabel("adresse IP : ");
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.anchor = GridBagConstraints.EAST;
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 1;
		gbc_lblIp.gridy = 1;
		add(lblIp, gbc_lblIp);
		
		textFieldIp = new JTextField("127.0.0.1");
		GridBagConstraints gbc_textFieldIp = new GridBagConstraints();
		gbc_textFieldIp.anchor = GridBagConstraints.WEST;
		gbc_textFieldIp.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIp.gridx = 2;
		gbc_textFieldIp.gridy = 1;
		add(textFieldIp, gbc_textFieldIp);
		textFieldIp.setColumns(15);
		
		JLabel lblPort = new JLabel("port : ");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.anchor = GridBagConstraints.EAST;
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 1;
		gbc_lblPort.gridy = 2;
		add(lblPort, gbc_lblPort);
		
		textFieldPort = new JTextField("62900");
		GridBagConstraints gbc_textFieldPort = new GridBagConstraints();
		gbc_textFieldPort.anchor = GridBagConstraints.WEST;
		gbc_textFieldPort.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPort.gridx = 2;
		gbc_textFieldPort.gridy = 2;
		add(textFieldPort, gbc_textFieldPort);
		textFieldPort.setColumns(15);
		GridBagConstraints gbc_btnConnection = new GridBagConstraints();
		gbc_btnConnection.anchor = GridBagConstraints.WEST;
		gbc_btnConnection.insets = new Insets(0, 0, 5, 0);
		gbc_btnConnection.gridx = 2;
		gbc_btnConnection.gridy = 3;
		add(btnConnection, gbc_btnConnection);
		
		lblErreur = new JLabel("");
		GridBagConstraints gbc_lblErreur = new GridBagConstraints();
		gbc_lblErreur.gridx = 2;
		gbc_lblErreur.gridy = 4;
		add(lblErreur, gbc_lblErreur);
		
		setBackground(new Color(221, 239, 255));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			VariablesGlobales.joueurQuiJoue = true;	//Le client ne prend pas le premier tour de jeu
			VariablesGlobales.joueur = false;  //on est du côté du client
			
			SocketClient sc = new SocketClient (textFieldIp.getText(), Integer.parseInt(textFieldPort.getText()));
			InitPlateau initPlateau = new InitPlateau();
			Plateau monPlateau = new Plateau("-1,-1");
			
			VariablesGlobales.leLanceur.getInterfaceGraphique().setContentPane(monPlateau);
			VariablesGlobales.leLanceur.getInterfaceGraphique().setSize(700, 700);
			VariablesGlobales.leLanceur.getInterfaceGraphique().setVisible(true);		
			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			lblErreur.setText("la connection n'a pas pu s'établir");
			e1.printStackTrace();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			lblErreur.setText("la connection n'a pas pu s'établir");
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			lblErreur.setText("la connection n'a pas pu s'établir");
			e1.printStackTrace();
		}
		
	}

}
