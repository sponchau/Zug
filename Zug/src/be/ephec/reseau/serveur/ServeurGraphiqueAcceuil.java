package be.ephec.reseau.serveur;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;

import be.ephec.reseau.Lanceur;
import be.ephec.reseau.client.SocketClient;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

public class ServeurGraphiqueAcceuil extends JPanel implements ActionListener{
	private JTextField textFieldPort;

	public ServeurGraphiqueAcceuil(Lanceur leLanceur) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblPort = new JLabel("port : ");
		GridBagConstraints gbc_lblPort = new GridBagConstraints();
		gbc_lblPort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPort.gridx = 2;
		gbc_lblPort.gridy = 0;
		add(lblPort, gbc_lblPort);
		
		textFieldPort = new JTextField();
		GridBagConstraints gbc_textFieldPort = new GridBagConstraints();
		gbc_textFieldPort.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPort.gridx = 4;
		gbc_textFieldPort.gridy = 0;
		add(textFieldPort, gbc_textFieldPort);
		textFieldPort.setColumns(10);
		
		JButton btnDemarrer = new JButton("d\u00E9marrer le serveur");
		btnDemarrer.addActionListener(this);
		GridBagConstraints gbc_btnDemarrer = new GridBagConstraints();
		gbc_btnDemarrer.gridx = 4;
		gbc_btnDemarrer.gridy = 2;
		add(btnDemarrer, gbc_btnDemarrer);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {System.out.println("serveur lancé");
			SocketServeur ss = new SocketServeur (Integer.parseInt(textFieldPort.getText()));
			
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}

