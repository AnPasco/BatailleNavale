package batailleNavale;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class GrilleGraphique extends JPanel {
	private final static int LARGEUR = 10;
	private final static int LONGUEUR = 10;
	private final Plateau plateau;

	public GrilleGraphique(Plateau plateau) {
		this.setLayout(new GridLayout(LARGEUR + 1, LONGUEUR + 1));
		this.plateau = plateau;

		for (int ligne = 0; ligne < GrilleGraphique.LARGEUR + 1; ligne++) {
			for (int colonne = 0; colonne < GrilleGraphique.LONGUEUR + 1; colonne++) {
				if (ligne == 0 && colonne == 0) {
					JPanel vide = new JPanel();
					this.add(vide);
				} else if (ligne == 0) {
					JLabel entete = new JLabel(String.valueOf(colonne));
					entete.setHorizontalAlignment(SwingConstants.CENTER);
					this.add(entete);
				} else if (colonne == 0) {
					JLabel entete = new JLabel(String.valueOf((char) ('A' + ligne - 1)));
					entete.setHorizontalAlignment(SwingConstants.CENTER);
					this.add(entete);
				} else {
					this.add(this.plateau.getPlateau()[ligne - 1][colonne - 1]);
				}

			}
		}
	}

	public void reinitialiserGrille() {
		for (int ligne = 0; ligne < GrilleGraphique.LARGEUR + 1; ligne++) {
			for (int colonne = 0; colonne < GrilleGraphique.LONGUEUR + 1; colonne++) {
				if (ligne != 0 && colonne != 0) {
					this.plateau.getPlateau()[ligne - 1][colonne - 1].reinitialiserCase();
				}

			}
		}
	}
}
