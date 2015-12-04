package be.ephec.reseau;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;


public class ReglesDuJeu extends JPanel {

	
public ReglesDuJeu () {
	setLayout(new BorderLayout(0, 0));
	setBackground(new Color(221, 239, 255));
	
	
	JLabel lblNewLabel = new JLabel("<html>\r\n\r\n<body bgcolor=\"#D7EFFF\">\r\n\r\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"760\" align=\"center\">\r\n  <tr>\r\n        <td width=\"760\">\r\n          \r\n      <div align=\"center\"><b><font face=\"Calisto MT\" size=\"7\" color=\"#FF9800\">LE \r\n        ZUG</font></b></div>\r\n        </td>\r\n      </tr>\r\n      <tr> \r\n        <td width=\"760\"> \r\n          \r\n     \r\n    </td>\r\n      </tr>\r\n      <tr> \r\n        <td width=\"760\" height=\"25\"></td>\r\n      </tr>\r\n      <tr> \r\n        <td width=\"760\"> \r\n          <p align=\"center\"><b><i><font face=\"Arial\" size=\"5\" color=\"#FF0000\">COMPOSITION \r\n            DU JEU:</font></i></b>\r\n        </td>\r\n      </tr>\r\n      <tr> \r\n        <td width=\"760\" height=\"25\"></td>\r\n      </tr>\r\n    </table>\r\n\r\n<table width=\"760\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n  <tr> \r\n    <td><font face=\"Arial, Helvetica, sans-serif\" size=\"3\"><b>1 Plateau de jeu \r\n      </b></font><font face=\"Arial, Helvetica, sans-serif\" size=\"2\">\r\n      Un damier carr&eacute; de 17 cases de cot&eacute;, divis&eacute; horizontalement \r\n      en trois zones.<br>\r\n      <br>\r\n      <b><font size=\"3\">24 Pions </font></b>(12 de chaque couleur)<br>\r\n      </font><font face=\"Arial, Helvetica, sans-serif\"> </font></td>\r\n  </tr>\r\n  <tr> \r\n    <td height=\"50\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<table width=\"760\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n  <tr>\r\n    <td>\r\n      <div align=\"center\"><font face=\"Arial\" size=\"2\"><b><font face=\"Arial\" size=\"5\" color=\"#FF0000\"><b><i>REGLE \r\n        DU JEU:</i></b></font></b></font></div>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    <td><font face=\"Arial, Helvetica, sans-serif\" size=\"3\"><b>But du jeu<br>\r\n      </b> </font><font face=\"Arial, Helvetica, sans-serif\" size=\"2\"> Installer \r\n      ses pions au fond du camp de l'adversaire.</font></td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<table width=\"760\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n  <tr>\r\n    <td width=\"550\"><font size=\"3\" face=\"Arial, Helvetica, sans-serif\"><b>Disposition \r\n      du jeu<br>\r\n      </b> </font><font size=\"2\" face=\"Arial, Helvetica, sans-serif\"> Les deux \r\n      bandes frontales du damier, comprenant chacune quatre rang&eacute;es de \r\n      17 cases, forment les camps des deux joueurs. Ceux-ci placent 9 pions sur \r\n      las cases noirs de leur premi&egrave;re rang&eacute;e, et les 3 pions restants \r\n      sur 3 cases noirs de leur choix, sur la seconde rang&eacute;e.<br>\r\n      </font></td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\" width=\"550\">&nbsp;</td>\r\n    <td width=\"210\" height=\"25\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<table width=\"760\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n  <tr> \r\n    <td width=\"420\"><font face=\"Arial, Helvetica, sans-serif\" size=\"2\"><b><font size=\"3\">D&eacute;placement \r\n      des pions<br>\r\n      </font> </b> Les pions se d&eacute;placent en avan&ccedil;ant d'une case, \r\n      en diagonale, lorsque la case vis&eacute;e est libre. Si cette case est \r\n      occup&eacute;e par un pion ami ou adverse, le pion en d&eacute;placement \r\n      le saute (sans le prendre) progressant ainsi de deux cases. IL est interdit \r\n      de reculer un pion.</font></td>\r\n  </tr>\r\n \r\n  <tr> \r\n    <td width=\"420\" height=\"25\">&nbsp;</td>\r\n    <td width=\"140\" height=\"25\">&nbsp;</td>\r\n    <td width=\"200\" height=\"25\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<table width=\"760\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n  <tr>\r\n    <td width=\"600\"><font face=\"Arial, Helvetica, sans-serif\" size=\"2\"><b><font size=\"3\">D&eacute;roulement \r\n      de la partie<br>\r\n      </font></b><font size=\"3\"> </font> Les blancs jouant en premier, leur attribution \r\n      est tir&eacute;e au sort. A chaque tour, les joueurs d&eacute;placent l'un \r\n      apr&egrave;s l'autre un pion vers le camp adverse. Lorsque la progression \r\n      est r&eacute;alis&eacute;e par saut d'un ou plusieurs autres pions, un d&eacute;placement \r\n      suppl&eacute;mentaire est imm&eacute;diatement accord&eacute; au pion avanc&eacute;.<br>\r\n      <br>\r\n      <br>\r\n      Aucun pion ne peut franchir la limite du camp adverse tant que tout les \r\n      pions amis n'ont pas quitt&eacute; leur propre camp. Lorsque tous les pions \r\n      d'une couleur ont franchi la limite du camp ennemi, ces pions ont la possibilit&eacute; \r\n      de reculer, en ob&eacute;issant aux m&ecirc;me r&egrave;gles de d&eacute;placement.</font></td>\r\n  </tr>\r\n  <tr>\r\n    <td width=\"600\" height=\"25\">&nbsp;</td>\r\n    <td width=\"160\" height=\"25\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<font face=\"Arial, Helvetica, sans-serif\" size=\"2\"> <b></b></font> \r\n<table width=\"760\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n  <tr>\r\n    <td><font size=\"3\" face=\"Arial, Helvetica, sans-serif\"><b>Fin de partie<br>\r\n      </b> </font><font size=\"2\" face=\"Arial, Helvetica, sans-serif\"> Lorsqu'un \r\n      joueur a r&eacute;ussi &ccedil;&agrave; placer neuf pions sur la premi&egrave;re \r\n      rang&eacute;e du camp de son adversaire, et trois pions sur la seconde rang&eacute;e, \r\n      il gagne et interrompt la partie.</font></td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"50\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<font face=\"Arial, Helvetica, sans-serif\" size=\"2\"><b><font size=\"3\"> </font><font face=\"Arial, Helvetica, sans-serif\" size=\"2\"><b></b></font></b></font> \r\n<table width=\"760\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n  <tr>\r\n    <td>\r\n      <div align=\"center\"><font face=\"Arial, Helvetica, sans-serif\" size=\"3\"><b>Plateau<a name=\"Plateau\"></a> \r\n        de jeu</b> (taille r&eacute;elle 30 x 30 cm)</font></div>\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"10\"></td>\r\n  </tr>\r\n  <tr>\r\n    <td height=\"25\">&nbsp;</td>\r\n  </tr>\r\n</table>\r\n<font face=\"Arial, Helvetica, sans-serif\" size=\"2\"><b><font size=\"3\"> </font></b></font>\r\n\r\n</body>\r\n</html>");
	lblNewLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
	add(lblNewLabel, BorderLayout.WEST);
	
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setViewportBorder(null);
	scrollPane.setToolTipText("");
	scrollPane.setViewportView(lblNewLabel);
	add(scrollPane, BorderLayout.EAST);
	
	
	
	  }

	}


