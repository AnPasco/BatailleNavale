package batailleNavale;

public class Partie {
	private String nomJoueur1;
	private String nomJoueur2;
	private boolean aJ1DeJouer;
	private boolean toutBateauPlace;
	private Plateau plateau1;
	private Plateau plateau2;
	private Bateaux batSelec;
	private boolean modeSolo;
	private int scoreJ1;
	private int scoreJ2;
	private GameStandard game1;
	private GameStandard game2;
	private GameViking game1V;
	private GameViking game2V;
	private boolean modeViking;
	private boolean modifEffectuer;
	private boolean modifEffectuer1;
	private boolean modifEffectuer2;
	private boolean modifEffectuer3;
	private boolean modifEffectuer4;
	private boolean modifEffectuer5;
	private boolean modifEffectuer6;
	private boolean modifEffectuer7;
	private boolean modifEffectue8;
	private boolean modifEffectuer9;
	
	public Partie() {

		this.plateau1 = new Plateau(this, 10, 10);
		this.plateau2 = new Plateau(this, 10, 10);
		this.modeSolo = true;
		this.aJ1DeJouer = true;
		this.scoreJ1 = 0;
		this.scoreJ2 = 0;
		this.toutBateauPlace = false;
		this.modifEffectuer = false;
		this.modifEffectuer1 = false;
		this.modifEffectuer2 = false;
		this.modifEffectuer3 = false;
		this.modifEffectuer4 = false;
		this.modeViking = false;
		
		
	}

	public String getNomJoueur1() {
		return nomJoueur1;
	}

	public void setNomJoueur1(String nomJoueur1) {
		this.nomJoueur1 = nomJoueur1;
	}

	public String getNomJoueur2() {
		return nomJoueur2;
	}

	public boolean isModifEffectuer() {
		return modifEffectuer;
	}

	public void setModifEffectuer(boolean modifEffectuer) {
		this.modifEffectuer = modifEffectuer;
	}

	public void setNomJoueur2(String nomJoueur2) {
		this.nomJoueur2 = nomJoueur2;
	}

	public boolean isaJ1DeJouer() {
		return aJ1DeJouer;
	}

	public void setaJ1DeJouer(boolean aJ1DeJouer) {
		this.aJ1DeJouer = aJ1DeJouer;
	}

	public boolean isToutBateauPlace() {
		return toutBateauPlace;
	}

	public void setToutBateauPlace(boolean toutBateauPlace) {
		this.toutBateauPlace = toutBateauPlace;
	}

	public Plateau getPlateau1() {
		return plateau1;
	}

	public Plateau getPlateau2() {
		return plateau2;
	}

	public Bateaux getBatSelec() {
		return batSelec;
	}

	public void setBatSelec(Bateaux batSelec) {
		this.batSelec = batSelec;
	}
	
	public boolean isModeSolo() {
		return modeSolo;
	}

	public void setModeSolo(boolean modeSolo) {
		this.modeSolo = modeSolo;
	}

	public boolean isModeViking() {
		return modeViking;
	}

	public void setModeViking(boolean modeViking) {
		this.modeViking = modeViking;
	}

	public int getScoreJ1() {
		return scoreJ1;
	}

	public void setScoreJ1() {
		this.scoreJ1 = this.scoreJ1 + 10;
	}

	public int getScoreJ2() {
		return scoreJ2;
	}

	public void setScoreJ2() {
		this.scoreJ2 = this.scoreJ2 + 10;
	}

	public GameStandard getGame1() {
		return game1;
	}

	public void setGame1(GameStandard game1) {
		this.game1 = game1;
	}

	public GameStandard getGame2() {
		return game2;
	}

	public void setGame2(GameStandard game2) {
		this.game2 = game2;
	}

	public boolean isModifEffectuer1() {
		return modifEffectuer1;
	}

	public void setModifEffectuer1(boolean modifEffectuer1) {
		this.modifEffectuer1 = modifEffectuer1;
	}

	public boolean isModifEffectuer2() {
		return modifEffectuer2;
	}

	public void setModifEffectuer2(boolean modifEffectuer2) {
		this.modifEffectuer2 = modifEffectuer2;
	}

	public boolean isModifEffectuer3() {
		return modifEffectuer3;
	}

	public void setModifEffectuer3(boolean modifEffectuer3) {
		this.modifEffectuer3 = modifEffectuer3;
	}

	public boolean isModifEffectuer4() {
		return modifEffectuer4;
	}

	public void setModifEffectuer4(boolean modifEffectuer4) {
		this.modifEffectuer4 = modifEffectuer4;
	}
	

	public boolean isModifEffectuer5() {
		return modifEffectuer5;
	}

	public void setModifEffectuer5(boolean modifEffectuer5) {
		this.modifEffectuer5 = modifEffectuer5;
	}
	

	public boolean isModifEffectuer6() {
		return modifEffectuer6;
	}

	public boolean isModifEffectuer7() {
		return modifEffectuer7;
	}

	public boolean isModifEffectue8() {
		return modifEffectue8;
	}

	public boolean isModifEffectuer9() {
		return modifEffectuer9;
	}

	public void setModifEffectuer6(boolean modifEffectuer6) {
		this.modifEffectuer6 = modifEffectuer6;
	}

	public void setModifEffectuer7(boolean modifEffectuer7) {
		this.modifEffectuer7 = modifEffectuer7;
	}

	public void setModifEffectue8(boolean modifEffectue8) {
		this.modifEffectue8 = modifEffectue8;
	}

	public void setModifEffectuer9(boolean modifEffectuer9) {
		this.modifEffectuer9 = modifEffectuer9;
	}

	public GameViking getGame1V() {
		return game1V;
	}

	public void setGame1V(GameViking game1v) {
		game1V = game1v;
	}

	public GameViking getGame2V() {
		return game2V;
	}

	public void setGame2V(GameViking game2v) {
		game2V = game2v;
	}

	public GameStandard getJeuCourant() {
		if(this.isaJ1DeJouer()){
			return this.game1;
		}else {
			return this.game2;
		}
	}
	
	public GameViking getJeuCourantViking() {
		if(this.isaJ1DeJouer()){
			return this.game1V;
		}else {
			return this.game2V;
		}
	}
	
	
}
