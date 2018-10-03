package batailleNavale;

public class Plateau {
	private final Partie partie;
	private final int colonne;
	private final int ligne;
	private Case[][] plateau;
	private boolean caseSelect;

	public Plateau(Partie partie, int colonne, int ligne) {
		this.partie = partie;
		this.colonne = colonne;
		this.ligne = ligne;
		this.plateau = new Case[ligne][colonne];
		this.caseSelect = false;
		newPlateau();
	}

	public boolean isCaseSelect() {
		return caseSelect;
	}

	public void setCaseSelect(boolean caseSelect) {
		this.caseSelect = caseSelect;
	}

	public Case[][] getPlateau() {
		return plateau;
	}

	public void newPlateau() {
		for (int ligne = 0; ligne < this.ligne; ligne++) {
			for (int colonne = 0; colonne < this.colonne; colonne++) {
				this.plateau[ligne][colonne] = new Case(this, ligne, colonne, partie);
			}
		}
	}

	public void reinitialiserPlateau() {
		for (int ligne = 0; ligne < this.ligne; ligne++) {
			for (int colonne = 0; colonne < this.colonne; colonne++) {
				this.plateau[ligne][colonne].setBackground(null);
			}
		}
	}
}
