package be.ephec.reseau.client;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JTextField;

import be.ephec.reseau.Lanceur;
import be.ephec.reseau.Plateau;

import javax.swing.JButton;

public class ClientGraphiqueAcceuil extends JPanel implements ActionListener{
	private JTextField textFieldIp;
	private JTextField textFieldPort;
	private JButton btnConnection;
	private JLabel lblErreur;
	private Lanceur leLanceur;

	/**
	 * Create the panel.
	 */
	public ClientGraphiqueAcceuil(Lanceur leLanceur) {
		this.leLanceur = leLanceur;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblIp = new JLabel("adresse IP : ");
		GridBagConstraints gbc_lblIp = new GridBagConstraints();
		gbc_lblIp.anchor = GridBagConstraints.EAST;
		gbc_lblIp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIp.gridx = 1;
		gbc_lblIp.gridy = 0;
		add(lblIp, gbc_lblIp);
		
		textFieldIp = new JTextField();
		GridBagConstraints gbc_textFieldIp = new GridBagConstraints();
		gbc_textFieldIp.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldIp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldIp.gridx = 2;
		gbc_textFieldIp.gridy = 0;
		add(textFieldIp, gbc_textFieldIp);
		textFieldIp.setColumns(10);
		
		JLabel lblPort = new JLabel("port : ");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.anchor = GridBagConstraints.EAST;
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 1;
		gbc_lblPort.gridy = 1;
		add(lblPort, gbc_lblPort);
		
		textFieldPort = new JTextField();
		GridBagConstraints gbc_textFieldPort = new GridBagConstraints();
		gbc_textFieldPort.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPort.gridx = 2;
		gbc_textFieldPort.gridy = 1;
		add(textFieldPort, gbc_textFieldPort);
		textFieldPort.setColumns(15);
		
		btnConnection = new JButton("connection");
		btnConnection.addActionListener(this);
		GridBagConstraints gbc_btnConnection = new GridBagConstraints();
		gbc_btnConnection.insets = new Insets(0, 0, 5, 0);
		gbc_btnConnection.gridx = 2;
		gbc_btnConnection.gridy = 3;
		add(btnConnection, gbc_btnConnection);
		
		lblErreur = new JLabel("");
		GridBagConstraints gbc_lblErreur = new GridBagConstraints();
		gbc_lblErreur.gridx = 2;
		gbc_lblErreur.gridy = 4;
		add(lblErreur, gbc_lblErreur);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			SocketClient sc = new SocketClient (textFieldIp.getText(), Integer.parseInt(textFieldPort.getText()));
			leLanceur.getInterfaceGraphique().setContentPane(new Plateau());
			leLanceur.getInterfaceGraphique().setVisible(true);
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
