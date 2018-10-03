package batailleNavale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameStandard {
	private final JLabel jLabelTitre;
	private final JLabel jLabelListeBat;
	private final JLabel jLabelBat1J1;
	private final JLabel jLabelBat2J1;
	private final JLabel jLabelBat3J1;
	private final JLabel jLabelBat4J1;
	private final JLabel jLabelBat5J1;
	private final JLabel jLabelBat1J2;
	private final JLabel jLabelBat2J2;
	private final JLabel jLabelBat3J2;
	private final JLabel jLabelBat4J2;
	private final JLabel jLabelBat5J2;
	private final JPanel jPanelPlacerBat;
	private final JPanel jPanelGauche;
	private final JPanel jPanelDroite;
	private final JPanel jPanelBas;
	private final JPanel jPanelGaucheListeBat;
	private final JPanel jPanelBouton;
	private final JPanel jPanelScore;
	private final Partie partie;
	private final String nomJoueur;
	private final JButton jBValider;
	private final GrilleGraphique grilleGraphique;
	private final Plateau plateau;
	private final JLabel jLScore;
	private final JPanel jPanelBatCouler;
	private final JPanel jPanelBatCouler2;
	private final JPanel jPanelScoreEtCouler;
	private Bateaux bateaux;

	public GameStandard(Partie partie) {
		this.partie = partie;

		// MA FENETRE
		JFrame maFenetre = new JFrame();
		maFenetre.setTitle("GAME");
		maFenetre.setSize(500, 500);
		maFenetre.setDefaultCloseOperation(3);
		maFenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// INITIALISATION GRILLE GRAPHIQUE
		if (this.partie.isaJ1DeJouer()) {
			this.plateau = partie.getPlateau2();
			this.nomJoueur = this.partie.getNomJoueur1();
			this.grilleGraphique = new GrilleGraphique(this.plateau);
			this.partie.setGame1(this);
		} else {
			this.plateau = partie.getPlateau1();
			this.nomJoueur = this.partie.getNomJoueur2();
			this.grilleGraphique = new GrilleGraphique(this.plateau);
			this.partie.setGame2(this);
		}

		// TITRE PRINCIPAL
		this.jLabelTitre = new JLabel(this.nomJoueur + " à toi de jouer !");
		this.jLabelTitre.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelTitre.setFont(new Font("Arial Black", Font.BOLD, 30));

		// CREATION PANEL GENERAL
		this.jPanelPlacerBat = new JPanel();
		this.jPanelPlacerBat.setLayout(new BorderLayout());

		////// PANEL DE GAUCHE//////

		// CREATION
		this.jPanelGauche = new JPanel();
		this.jPanelGauche.setLayout(new BorderLayout());
		this.jPanelGauche.setPreferredSize(new Dimension(200, maFenetre.getWidth()));

		// BOUTON VALIDER
		this.jBValider = new JButton("Valider");
		this.jBValider.setHorizontalAlignment(JLabel.CENTER);

		this.jBValider.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (plateau.isCaseSelect()) {
					if (partie.getScoreJ1() == 50 || partie.getScoreJ2() == 50) {
						new Victoire(partie);
						maFenetre.dispose();
					} else {
						partie.setaJ1DeJouer(!partie.isaJ1DeJouer());
						plateau.setCaseSelect(false);
						new GameStandard(partie);
						maFenetre.dispose();
					}

				}

			}
		});

		// JPANEL GENE CENTRE
		this.jPanelScoreEtCouler = new JPanel();
		this.jPanelScoreEtCouler.setLayout(new BorderLayout());

		// JPANEL BAT COULER
		this.jPanelBatCouler = new JPanel();
		this.jPanelBatCouler.setLayout(new GridLayout(5, 1));
		
		this.jPanelBatCouler2 = new JPanel();
		this.jPanelBatCouler2.setLayout(new GridLayout(5, 1));

		this.jLabelBat1J1 = new JLabel("Porte Avion");
		this.jLabelBat1J1.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelBat2J1 = new JLabel("Croiseur");
		this.jLabelBat2J1.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelBat3J1 = new JLabel("Destroyeur");
		this.jLabelBat3J1.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelBat4J1 = new JLabel("Sous-Marin");
		this.jLabelBat4J1.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelBat5J1 = new JLabel("Torpilleur");
		this.jLabelBat5J1.setHorizontalAlignment(JLabel.CENTER);
		
		this.jLabelBat1J2 = new JLabel("Porte Avion");
		this.jLabelBat1J2.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelBat2J2 = new JLabel("Croiseur");
		this.jLabelBat2J2.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelBat3J2 = new JLabel("Destroyeur");
		this.jLabelBat3J2.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelBat4J2 = new JLabel("Sous-Marin");
		this.jLabelBat4J2.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelBat5J2 = new JLabel("Torpilleur");
		this.jLabelBat5J2.setHorizontalAlignment(JLabel.CENTER);

		if (partie.isaJ1DeJouer()) {
			if (!partie.isModifEffectuer()) {
				this.jLabelBat1J1.setVisible(false);
			}
			if (!partie.isModifEffectuer1()) {
				this.jLabelBat2J1.setVisible(false);
			}
			if (!partie.isModifEffectuer2()) {
				this.jLabelBat3J1.setVisible(false);
			}
			if (!partie.isModifEffectuer3()) {
				this.jLabelBat4J1.setVisible(false);
			}
			if (!partie.isModifEffectuer4()) {
				this.jLabelBat5J1.setVisible(false);
			}

			this.jPanelBatCouler.add(jLabelBat1J1);
			this.jPanelBatCouler.add(jLabelBat2J1);
			this.jPanelBatCouler.add(jLabelBat3J1);
			this.jPanelBatCouler.add(jLabelBat4J1);
			this.jPanelBatCouler.add(jLabelBat5J1);
		} else {

			if (!partie.isModifEffectuer5()) {
				this.jLabelBat1J2.setVisible(false);
			}
			if (!partie.isModifEffectuer6()) {
				this.jLabelBat2J2.setVisible(false);
			}
			if (!partie.isModifEffectuer7()) {
				this.jLabelBat3J2.setVisible(false);
			}
			if (!partie.isModifEffectue8()) {
				this.jLabelBat4J2.setVisible(false);
			}
			if (!partie.isModifEffectuer9()) {
				this.jLabelBat5J2.setVisible(false);
			}

			this.jPanelBatCouler2.add(jLabelBat1J2);
			this.jPanelBatCouler2.add(jLabelBat2J2);
			this.jPanelBatCouler2.add(jLabelBat3J2);
			this.jPanelBatCouler2.add(jLabelBat4J2);
			this.jPanelBatCouler2.add(jLabelBat5J2);
		}

		// JPANEL BOUTON
		this.jPanelBouton = new JPanel();

		// ADD BOUTON AU JPANEL BOUTON
		jPanelBouton.add(jBValider);

		// JLABEL TEXTE BAT COULER
		this.jLabelListeBat = new JLabel("Bateau(x) coulé(s) : ");
		this.jLabelListeBat.setAlignmentX(Component.CENTER_ALIGNMENT);

		// JPANEL AFFICHAGE LISTE BAT
		this.jPanelGaucheListeBat = new JPanel();
		this.jPanelGaucheListeBat.setLayout(new BoxLayout(this.jPanelGaucheListeBat, BoxLayout.PAGE_AXIS));

		// JLABEL SCORE
		if (this.partie.isaJ1DeJouer()) {
			this.jLScore = new JLabel("Score : " + partie.getScoreJ1());
		} else {
			this.jLScore = new JLabel("Score : " + partie.getScoreJ2());
		}
		this.jLScore.setAlignmentX(Component.CENTER_ALIGNMENT);

		// JPANEL SCORE
		this.jPanelScore = new JPanel();
		this.jPanelScore.add(jLScore);

		// ADD
		if(partie.isaJ1DeJouer()) {
			jPanelScoreEtCouler.add(jPanelBatCouler, BorderLayout.NORTH);
		}else {
			jPanelScoreEtCouler.add(jPanelBatCouler2, BorderLayout.NORTH);
		}
		
		jPanelScoreEtCouler.add(jPanelScore, BorderLayout.SOUTH);

		jPanelGaucheListeBat.add(jLabelListeBat, BorderLayout.NORTH);
		jPanelGaucheListeBat.add(jPanelScoreEtCouler, BorderLayout.CENTER);
		jPanelGaucheListeBat.add(jPanelBouton, BorderLayout.SOUTH);
		jPanelGauche.add(jPanelGaucheListeBat);

		////// PANEL DE DROITE//////
		this.jPanelDroite = new JPanel();
		this.jPanelDroite.setPreferredSize(new Dimension(100, maFenetre.getWidth()));

		////// PANEL DU BAS//////
		this.jPanelBas = new JPanel();
		this.jPanelBas.setPreferredSize(new Dimension(maFenetre.getWidth(), 100));

		// ADD AU JPANEL PRINCIPAL
		this.jPanelPlacerBat.add(grilleGraphique, BorderLayout.CENTER);
		this.jPanelPlacerBat.add(jLabelTitre, BorderLayout.NORTH);
		this.jPanelPlacerBat.add(jPanelGauche, BorderLayout.WEST);
		this.jPanelPlacerBat.add(jPanelDroite, BorderLayout.EAST);
		this.jPanelPlacerBat.add(jPanelBas, BorderLayout.SOUTH);

		maFenetre.getContentPane().add(this.jPanelPlacerBat);
		maFenetre.setVisible(true);
	}

	// PASSAGE AUTRE JOUEUR

	public void addBatCouler(Bateaux bateaux) {
		if(partie.isaJ1DeJouer()) {
			if (bateaux.getNom().equals("Porte Avion")) {
				this.jLabelBat1J1.setVisible(true);
				partie.setModifEffectuer(true);
			} else {
				if (bateaux.getNom().equals("Croiseur")) {
					this.jLabelBat2J1.setVisible(true);
					partie.setModifEffectuer1(true);
				} else {
					if (bateaux.getNom().equals("Destroyeur")) {
						this.jLabelBat3J1.setVisible(true);
						partie.setModifEffectuer2(true);

					} else {
						if (bateaux.getNom().equals("Sous-Marin")) {
							this.jLabelBat4J1.setVisible(true);
							partie.setModifEffectuer3(true);

						} else {
							if (bateaux.getNom().equals("Torpilleur")) {
								this.jLabelBat5J1.setVisible(true);
								partie.setModifEffectuer4(true);

							}
						}
					}
				}
			}
			
		}else {
			if (bateaux.getNom().equals("Porte Avion")) {
				this.jLabelBat1J2.setVisible(true);
				partie.setModifEffectuer5(true);
			} else {
				if (bateaux.getNom().equals("Croiseur")) {
					this.jLabelBat2J2.setVisible(true);
					partie.setModifEffectuer6(true);
				} else {
					if (bateaux.getNom().equals("Destroyeur")) {
						this.jLabelBat3J2.setVisible(true);
						partie.setModifEffectuer7(true);

					} else {
						if (bateaux.getNom().equals("Sous-Marin")) {
							this.jLabelBat4J2.setVisible(true);
							partie.setModifEffectue8(true);

						} else {
							if (bateaux.getNom().equals("Torpilleur")) {
								this.jLabelBat5J2.setVisible(true);
								partie.setModifEffectuer9(true);

							}
						}
					}
				}
			}
		}
	

	}

	public String getNomJoueur() {
		return this.nomJoueur;
	}

}
