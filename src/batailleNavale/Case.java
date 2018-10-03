package batailleNavale;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Case extends JButton {
	private final Plateau plateau;
	private Bateaux bateaux;
	private final int coorY;
	private final int coorX;
	private final Partie partie;
	private boolean occup;
	private boolean dejaJouer;

	public Case(Plateau plateau, int coorY, int coorX, Partie partie) {
		this.plateau = plateau;
		this.coorY = coorY;
		this.coorX = coorX;
		this.partie = partie;
		this.dejaJouer = false;
		this.occup = false;

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (partie.isToutBateauPlace()) {
					if (!plateau.isCaseSelect()) {
						if (!dejaJouer) {

							if (occup) {
								setBackground(Color.RED);
								bateaux.toucher();
							} else {
								setBackground(Color.BLUE);
							}
							dejaJouer = true;
							plateau.setCaseSelect(true);

						}
					}

				} else {
					if (partie.getBatSelec() != null) {
						bateaux = partie.getBatSelec();
						if (bateaux.getaPlacer() <= bateaux.getTaille() - 1) {
							checkPosition();
						}
						if (bateaux.getaPlacer() == bateaux.getTaille() - 1) {
							bateaux.setBateauPlacer(true);
						}
					}
				}
			}
		});

	}

	public void changementCouleur() {
		this.setBackground(Color.GREEN);
	}

	public void checkPosition() {

		if (!this.occup) {

			// A partir du 2ieme emplacement
			if (this.bateaux.commencerAPlacer()) {

				// Pour emplacement 2ieme emplacement
				if (this.bateaux.getaPlacer() == 1) {
					if (this.bateaux.getPositionCoord()[this.bateaux.getaPlacer() - 1]
							.coord2Valide(new Coordonee(this.coorX, this.coorY))) {

						if (this.bateaux.getPositionCoord()[this.bateaux.getaPlacer() - 1].getCoordX() == this.coorX) {
							this.bateaux.setHorizontal(false);
						} else {
							this.bateaux.setHorizontal(true);
						}

						placerFinal();
					}
				} else {

					if (this.bateaux.getPositionCoord()[this.bateaux.getaPlacer() - 1]
							.coord3Valide(this.bateaux.isHorizontal(), new Coordonee(this.coorX, this.coorY))) {
						placerFinal();
					}
				}

			}
			// Premier emplacement
			else {
				placerFinal();
			}
		}
	}

	public void placerFinal() {
		this.bateaux.addCoord(new Coordonee(this.coorX, this.coorY));
		bateaux.placerBat();
		changementCouleur();
		this.occup = true;
	}

	public void reinitialiserCase() {
		this.occup = false;
		this.setBackground(null);
	}

}
