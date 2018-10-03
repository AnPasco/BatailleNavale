package batailleNavale;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Regle {
	private final JFrame maFenetre;
	private final JLabel jLabelTitre;
	private final JLabel jLabelTitreRegle1;
	private final JLabel jLabelRegle1;
	private final JPanel jPanelRegle1;
	private final JPanel jPanelGeneral;
	private final JLabel jLabelTitreRegle2;
	private final JPanel jPanelRegle2;
	private final JLabel jLabelRegle2;
	private final JLabel jLabelTitreRegle3;
	private final JLabel jLabelRegle3;
	private final JPanel jPanelRegle3;
	private final JPanel jPanelMilieu;
	private final JPanel jPanelButton;
	private final JButton jButtonQuitter;

	public Regle() {
		this.maFenetre = new JFrame();
		this.maFenetre.setTitle("Bataille Navale");
		this.maFenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.maFenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// TITRE
		this.jLabelTitre = new JLabel("Règles");
		this.jLabelTitre.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelTitre.setFont(new Font("Arial", Font.BOLD, 35));

		// TITRE REGLE 1
		this.jLabelTitreRegle1 = new JLabel("Le joueur possède :");
		this.jLabelTitreRegle1.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelTitreRegle1.setFont(new Font("Futura", Font.TRUETYPE_FONT, 25));

		// JLABEL REGLE 1
		this.jLabelRegle1 = new JLabel(
				"Une grille de jeu numérotée de 1 à 10 horizontalement et de A à J verticalement."
						+ " Il possède en fonction du mode de jeu plusieurs bateaux, le plus souvent : 1 porte avion, 1 croiseur, 1 destroyeur, 1 sous-marin et 1 torpilleur.");
		this.jLabelRegle1.setHorizontalAlignment(JLabel.CENTER);

		// JPANEL REGLE 1
		this.jPanelRegle1 = new JPanel();
		this.jPanelRegle1.setLayout(new GridLayout(2, 1));

		this.jPanelRegle1.add(jLabelTitreRegle1);
		this.jPanelRegle1.add(jLabelRegle1);

		// TITRE 2
		this.jLabelTitreRegle2 = new JLabel("Comment jouer ?");
		this.jLabelTitreRegle2.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelTitreRegle2.setFont(new Font("Futura", Font.TRUETYPE_FONT, 25));

		// JLABEL REGLE 2
		this.jLabelRegle2 = new JLabel(
				"Au début du jeu, chaque joueur place à sa guise tous les bateaux sur sa grille de façon stratégique."
						+ " Une fois tous les bateaux en jeu, la partie peut commencer.. Un à un, les joueurs se tire dessus pour détruire les navires ennemis.");
		this.jLabelRegle2.setHorizontalAlignment(JLabel.CENTER);

		// JPANEL REGLE 2
		this.jPanelRegle2 = new JPanel();
		this.jPanelRegle2.setLayout(new GridLayout(2, 1));

		this.jPanelRegle2.add(jLabelTitreRegle2);
		this.jPanelRegle2.add(jLabelRegle2);

		// TITRE 3
		this.jLabelTitreRegle3 = new JLabel("Comment gagner ?");
		this.jLabelTitreRegle3.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelTitreRegle3.setFont(new Font("Futura", Font.TRUETYPE_FONT, 25));

		// JLABEL REGLE 3
		this.jLabelRegle3 = new JLabel(
				"Une partie de bataille navale se termine lorsque l’un des joueurs n’a plus de navires.");

		this.jLabelRegle3.setHorizontalAlignment(JLabel.CENTER);

		// JPANEL REGLE 3
		this.jPanelRegle3 = new JPanel();
		this.jPanelRegle3.setLayout(new GridLayout(2, 1));

		this.jPanelRegle3.add(jLabelTitreRegle3);
		this.jPanelRegle3.add(jLabelRegle3);

		// JBUTTON QUITTER
		this.jButtonQuitter = new JButton("Quitter");
		this.jButtonQuitter.setHorizontalAlignment(JLabel.CENTER);

		this.jButtonQuitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				maFenetre.dispose();

			}
		});

		// JPANEL BUTTON
		this.jPanelButton = new JPanel();
		this.jPanelButton.add(jButtonQuitter);
		
		// PANEL GENERAL + PANEL MILIEU
		this.jPanelMilieu = new JPanel();
		this.jPanelMilieu.setLayout(new GridLayout(3, 1));

		this.jPanelMilieu.add(jPanelRegle1);
		this.jPanelMilieu.add(jPanelRegle2);
		this.jPanelMilieu.add(jPanelRegle3);

		this.jPanelGeneral = new JPanel();
		this.jPanelGeneral.setLayout(new BorderLayout());

		this.jPanelGeneral.add(jLabelTitre, BorderLayout.NORTH);
		this.jPanelGeneral.add(jPanelMilieu, BorderLayout.CENTER);
		this.jPanelGeneral.add(jPanelButton, BorderLayout.SOUTH);

		this.maFenetre.getContentPane().add(jPanelGeneral);
		this.maFenetre.setVisible(true);

	}
}
