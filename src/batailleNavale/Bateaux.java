package batailleNavale;

import java.awt.Color;

import javax.swing.JLabel;

public class Bateaux {
	private String nom;
	private int taille;
	private boolean horizontal;
	private int aPlacer;
	private JLabel jLabelNomBat;
	private Coordonee[] positionCoord;
	private final Partie partie;
	private boolean bateauPlacer;
	private int partBatToucher;
	private boolean couler;

	public Bateaux(String nom, int taille, Partie partie) {
		this.nom = nom;
		this.taille = taille;
		this.partie = partie;
		this.aPlacer = 0;
		this.bateauPlacer = false;
		this.partBatToucher = 0;
		this.positionCoord = new Coordonee[taille];
		this.couler = false;

	}

	// GETTERS & SETTERS

	public String getNom() {
		return nom;
	}

	public JLabel getNomBat() {
		return jLabelNomBat;
	}

	public void setNomBat(JLabel nomBat) {
		this.jLabelNomBat = nomBat;
	}

	public int getTaille() {
		return taille;
	}

	public boolean isCouler() {
		return couler;
	}

	public void setCouler(boolean couler) {
		this.couler = couler;
	}

	public int getaPlacer() {
		return aPlacer;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public Coordonee[] getPositionCoord() {
		return positionCoord;
	}

	public void setHorizontal(boolean value) {
		this.horizontal = value;
	}

	public boolean isBateauPlacer() {
		return bateauPlacer;
	}

	public void setBateauPlacer(boolean bateauPlacer) {
		this.bateauPlacer = bateauPlacer;
	}

	// AJOUTER PART BAT
	public void ajouterPartBat() {
		this.aPlacer++;
	}

	// PLACER BAT
	public void placerBat() {
		ajouterPartBat(); // ON UTILISE AJOUTER PART BAT
		if (this.aPlacer <= this.taille) { // SI LE NBR DE BAT A PLACER EST INF A LA TAILLE DU BAT ALORS ...
			this.jLabelNomBat.setText(this.nom + " (" + this.aPlacer + "/" + this.taille + ")"); // ACTUALISE
		}
		if (this.aPlacer == this.taille) {
			this.partie.setBatSelec(null);
		}
	}

	public void addCoord(Coordonee coord) {
		boolean placeOccup = true;
		int compteur = 0;
		while (placeOccup) {
			if (this.positionCoord[compteur] == null) {
				this.positionCoord[compteur] = coord;
				placeOccup = false;
			} else {
				compteur++;
			}
		}
	}

	public boolean commencerAPlacer() {
		return (this.positionCoord[0] != null);
	}

	public void reinitialiserBat() {
		this.aPlacer = 0;
		this.bateauPlacer = false;
		this.positionCoord = new Coordonee[taille];
		this.jLabelNomBat.setForeground(Color.BLACK);
		this.jLabelNomBat.setText(this.nom + " (" + this.aPlacer + "/" + this.taille + ")");

	}

	public void toucher() {
		this.partBatToucher++;
		if (this.partBatToucher == this.taille) {
			this.couler();
		}
	}

	public void couler() {
		if (!partie.isModeViking()) {
			if (partie.isaJ1DeJouer()) {
				this.partie.getJeuCourant().addBatCouler(this);
				this.partie.setScoreJ1();
				this.setCouler(true);

			} else {
				this.partie.getJeuCourant().addBatCouler(this);
				this.partie.setScoreJ2();
				this.setCouler(true);
			}
		} else {
			if (partie.isaJ1DeJouer()) {
				this.partie.getJeuCourantViking().addBatCouler(this);
				this.partie.setScoreJ1();
				this.setCouler(true);

			} else {
				this.partie.getJeuCourantViking().addBatCouler(this);
				this.partie.setScoreJ2();
				this.setCouler(true);
			}
		}

	}

	@Override
	public String toString() {
		return (this.nom + " (" + this.aPlacer + "/" + this.taille + ")");
	}

}
