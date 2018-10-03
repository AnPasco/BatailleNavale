package batailleNavale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PlacerBatViking {
	private final JLabel jLabelTitre;
	private final JLabel jLabelListeBat;
	private final JPanel jPanelPlacerBat;
	private final JPanel jPanelGauche;
	private final JPanel jPanelDroite;
	private final JPanel jPanelBas;
	private final JPanel jPanelGaucheListeBat;
	private final Partie partie;
	private final String nomJoueur;
	private List<Bateaux> listeBateaux;
	private final JButton jBValider;
	private final JButton jBReinitialiser;
	private final JPanel jPanelBouton;
	private final GrilleGraphique grilleGraphique;

	public PlacerBatViking(Partie partie) {
		this.partie = partie;

		// MA FENETRE
		JFrame maFenetre = new JFrame();
		maFenetre.setTitle("Placer Bateau");
		maFenetre.setSize(500, 500);
		maFenetre.setDefaultCloseOperation(3);
		maFenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// INITIALISATION GRILLE GRAPHIQUE
		if (this.partie.isaJ1DeJouer()) {
			this.grilleGraphique = new GrilleGraphique(partie.getPlateau1());
			this.nomJoueur = this.partie.getNomJoueur1();
		} else {
			this.grilleGraphique = new GrilleGraphique(partie.getPlateau2());
			this.nomJoueur = this.partie.getNomJoueur2();
		}

		// TITRE PRINCIPAL
		this.jLabelTitre = new JLabel(this.nomJoueur + " le VIKING place tes bateaux !");
		this.jLabelTitre.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelTitre.setFont(new Font("Arial Black", Font.BOLD, 30));

		// CREATION LISTE BATEAUX
		this.listeBateaux = new ArrayList<>(5);

		this.listeBateaux.add(new Bateaux("Drakkar Commandant", 3, partie));
		this.listeBateaux.add(new Bateaux("Drakkar D'élite", 3, partie));
		this.listeBateaux.add(new Bateaux("Drakkar", 3, partie));
		this.listeBateaux.add(new Bateaux("Petit Drakkar", 2, partie));
		this.listeBateaux.add(new Bateaux("Mini Drakkar", 2, partie));

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
				int batNum = 0;
				boolean toutBatPlacer = true;
				while (batNum < listeBateaux.size() && toutBatPlacer) {
					toutBatPlacer = listeBateaux.get(batNum).isBateauPlacer();
					batNum++;
				}
				if (toutBatPlacer) {
					partie.setaJ1DeJouer(!partie.isaJ1DeJouer());

					if (partie.isaJ1DeJouer()) {
						partie.setToutBateauPlace(true);
					}

					fermerFenetre(maFenetre);

				}

			}
		});

		// BOUTON REINITIALISER
		this.jBReinitialiser = new JButton("Réinitialiser");
		this.jBReinitialiser.setHorizontalAlignment(JLabel.CENTER);

		this.jBReinitialiser.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				grilleGraphique.reinitialiserGrille();
				for (int batNum = 0; batNum < listeBateaux.size(); batNum++) {
					listeBateaux.get(batNum).reinitialiserBat();
				}
			}
		});

		// JPANEL BOUTON
		this.jPanelBouton = new JPanel();

		// ADD BOUTON AU JPANEL BOUTON
		jPanelBouton.add(jBValider);
		jPanelBouton.add(jBReinitialiser);

		// JLABEL MSG LISTE BAT
		this.jLabelListeBat = new JLabel("Selectionner les bateaux : ");
		this.jLabelListeBat.setAlignmentX(Component.CENTER_ALIGNMENT);

		// JPANEL AFFICHAGE LISTE BAT
		this.jPanelGaucheListeBat = new JPanel();
		this.jPanelGaucheListeBat.setLayout(new BoxLayout(this.jPanelGaucheListeBat, BoxLayout.PAGE_AXIS));

		// ADD
		jPanelGaucheListeBat.add(jLabelListeBat, BorderLayout.NORTH);

		for (int batNum = 0; batNum < this.listeBateaux.size(); batNum++) {
			Bateaux bateauProvisoire = this.listeBateaux.get(batNum);
			JLabel bat = new JLabel(bateauProvisoire.toString());
			bateauProvisoire.setNomBat(bat);
			final int batNumFinal = batNum;
			final Cursor cursor;
			bat.setAlignmentX(Component.CENTER_ALIGNMENT);
			bat.setPreferredSize(new Dimension(200, 200));
			bat.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					bat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					bat.setForeground(Color.RED);
					if (partie.getBatSelec() == null) {
						partie.setBatSelec(bateauProvisoire);
					}

				}
			});

			jPanelGaucheListeBat.add(bat, BorderLayout.CENTER);
			jPanelGaucheListeBat.add(jPanelBouton, BorderLayout.SOUTH);
			jPanelGauche.add(jPanelGaucheListeBat);
		}

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

	public void fermerFenetre(JFrame maFenetre) {
		if (partie.isModeSolo()) {
			System.out.println("mose solo");
		} else {
			if (partie.isToutBateauPlace()) {
				this.partie.getPlateau2().reinitialiserPlateau();
				this.partie.getPlateau1().reinitialiserPlateau();
				new GameViking(partie);

			} else {
				new PlacerBatViking(partie);
			}
		}

		maFenetre.dispose();
	}

}
