package be.ephec.reseau;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;

public class Plateau extends JPanel {

	/**
	 * Create the panel.
	 */
	public Plateau() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblCoucou = new JLabel("coucou");
		GridBagConstraints gbc_lblCoucou = new GridBagConstraints();
		gbc_lblCoucou.gridx = 6;
		gbc_lblCoucou.gridy = 3;
		add(lblCoucou, gbc_lblCoucou);

	}

}
