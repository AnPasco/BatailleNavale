package batailleNavale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PageDeb {
	private final JFrame maFenetre;
	private final JLabel jLabelTitre;
	private final JLabel jLabelQtsIA;
	private final JLabel jLabelQtsMDJ;
	private final JLabel jLabelQtsCommentaire;
	private final JLabel jLabelJoueur2;
	private final JLabel jLabelJoueur1;
	private final JLabel jLabelMenu;
	private final JLabel jLabelExplicationStandardTitre;
	private final JLabel jLabelExpStanPA;
	private final JLabel jLabelExpStanCroiseur;
	private final JLabel jLabelExpStanDestroyeur;
	private final JLabel jLabelExpStanSM;
	private final JLabel jLabelExpStanTorpilleur;
	private final JLabel jLabelExplicationViking;
	private final JLabel jLabelExpVikDrakkar;
	private final JLabel jLabelExpVikDrakkar2;
	private final JLabel jLabelExpVikDrakkar3;
	private final JLabel jLabelExpVikDrakkar4;
	private final JLabel jLabelExpVikDrakkar5;
	private final JLabel jLabelTexteIA;
	private final JPanel jPanelGeneralVik;
	private final JPanel jPanelGeneralStandard;
	private final JPanel jPanelDroite;
	private final JPanel jPanelTitreEtMenu;
	private final JPanel jPanelTotal;
	private final JPanel jPanelBouton;
	private final JPanel jPanelIA;
	private final JPanel jPanelMDJ;
	private final JPanel jPanelCOM;
	private final JPanel jPanelMilieu;
	private final JPanel jPanelJ1;
	private final JPanel jPanelJ2;
	private final JPanel jPanelIANonDispo;
	private final JButton jButtonLancerPartie;
	private final JButton jButtonAfficherRegle;
	private final JRadioButton jRadioButtonOuiIA;
	private final JRadioButton jRadioButtonNonIA;
	private final JRadioButton jRadioButtonChoixStandard;
	private final JRadioButton jRadioButtonChoixViking;
	private final JRadioButton jRadioButtonOuiCom;
	private final JRadioButton jRadioButtonNonCom;
	private final ButtonGroup buttonGroupMDJ;
	private final ButtonGroup buttonGroupIA;
	private final ButtonGroup buttonGroupCOM;
	private final JTextField jTextFieldJoueur1;
	private final JTextField jTextFieldJoueur2;
	private final Partie partie;
	private PlacerBatStandard fenetrePlacerBatStandard;
	private PlacerBatViking fenetrePlacerBatViking;
	private JOptionPane erreur;
	private Regle fenetreRegle;

	public PageDeb() {
		this.maFenetre = new JFrame();
		this.maFenetre.setTitle("Bataille Navale");
		this.maFenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.maFenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.partie = new Partie();

		// TITRE
		this.jLabelTitre = new JLabel("Bataille Navale");
		this.jLabelTitre.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelTitre.setFont(new Font("Arial", Font.BOLD, 35));

		// MENU
		this.jLabelMenu = new JLabel("Menu");
		this.jLabelMenu.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelMenu.setFont(new Font("Futura", Font.TRUETYPE_FONT, 25));

		// jPANEL TITRE + MENU
		this.jPanelTitreEtMenu = new JPanel();
		this.jPanelTitreEtMenu.setLayout(new BorderLayout());

		this.jPanelTitreEtMenu.add(jLabelTitre, BorderLayout.NORTH);
		this.jPanelTitreEtMenu.add(jLabelMenu, BorderLayout.SOUTH);

		// JOUEUR 1
		this.jLabelJoueur1 = new JLabel("Nom joueur 1 : ");
		this.jTextFieldJoueur1 = new JTextField(20);

		this.jPanelJ1 = new JPanel();

		this.jPanelJ1.add(jLabelJoueur1);
		this.jPanelJ1.add(jTextFieldJoueur1);

		// JOUEUR 2
		this.jLabelJoueur2 = new JLabel("Nom joueur 2 : ");
		this.jTextFieldJoueur2 = new JTextField(20);

		this.jPanelJ2 = new JPanel();

		this.jPanelJ2.add(jLabelJoueur2);
		this.jPanelJ2.add(jTextFieldJoueur2);

		// TEXTE IA NON DISPO

		this.jLabelTexteIA = new JLabel("IA non disponible, coming soon ... Si vous lancer le jeu, la fenetre se fermera !");
		this.jLabelTexteIA.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelTexteIA.setForeground(Color.RED);
		this.jLabelTexteIA.setVisible(false);

		// JPANEL TEXTE IA NON DISPO

		this.jPanelIANonDispo = new JPanel();
		this.jPanelIANonDispo.add(jLabelTexteIA);
		
		// QTS IA
		this.jLabelQtsIA = new JLabel("Veux tu jouer contre une IA ?");
		this.jLabelQtsIA.setHorizontalAlignment(JLabel.CENTER);

		this.buttonGroupIA = new ButtonGroup();

		this.jRadioButtonOuiIA = new JRadioButton("Oui");
		this.jRadioButtonNonIA = new JRadioButton("Non", true);
		this.jRadioButtonNonIA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jPanelMilieu.remove(jPanelIANonDispo);
				jPanelMilieu.add(jPanelJ2);
				maFenetre.revalidate();
				maFenetre.repaint();
			}
		});

		this.jRadioButtonOuiIA.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jPanelMilieu.add(jPanelIANonDispo);
				jLabelTexteIA.setVisible(true);
				jPanelMilieu.remove(jPanelJ2);
				maFenetre.revalidate();
				maFenetre.repaint();
			}
		});

		// ADD IA BUTTON GROUP
		this.buttonGroupIA.add(jRadioButtonOuiIA);
		this.buttonGroupIA.add(jRadioButtonNonIA);

		// JPANEL IA
		this.jPanelIA = new JPanel();

		this.jPanelIA.add(jLabelQtsIA);
		this.jPanelIA.add(jRadioButtonOuiIA);
		this.jPanelIA.add(jRadioButtonNonIA);

		////// JLABEL EXPLICATION STANDARD //////
		this.jLabelExplicationStandardTitre = new JLabel("Bateaux présents en standard : ");
		this.jLabelExplicationStandardTitre.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelExplicationStandardTitre.setFont(new Font("Arial", Font.TRUETYPE_FONT, 20));

		this.jLabelExpStanPA = new JLabel("1# Porte-Avion");
		this.jLabelExpStanPA.setHorizontalAlignment(JLabel.CENTER);

		this.jLabelExpStanCroiseur = new JLabel("2# Croiseur");
		this.jLabelExpStanCroiseur.setHorizontalAlignment(JLabel.CENTER);

		this.jLabelExpStanDestroyeur = new JLabel("3# Destroyeur");
		this.jLabelExpStanDestroyeur.setHorizontalAlignment(JLabel.CENTER);

		this.jLabelExpStanSM = new JLabel("4# Sous-Marin");
		this.jLabelExpStanSM.setHorizontalAlignment(JLabel.CENTER);

		this.jLabelExpStanTorpilleur = new JLabel("5# Torpilleur");
		this.jLabelExpStanTorpilleur.setHorizontalAlignment(JLabel.CENTER);

		this.jPanelGeneralStandard = new JPanel();
		this.jPanelGeneralStandard.setLayout(new GridLayout(8, 1));
		this.jPanelGeneralStandard.setPreferredSize(new Dimension(300, maFenetre.getWidth()));

		this.jPanelGeneralStandard.add(jLabelExplicationStandardTitre);
		this.jPanelGeneralStandard.add(jLabelExpStanPA);
		this.jPanelGeneralStandard.add(jLabelExpStanCroiseur);
		this.jPanelGeneralStandard.add(jLabelExpStanDestroyeur);
		this.jPanelGeneralStandard.add(jLabelExpStanSM);
		this.jPanelGeneralStandard.add(jLabelExpStanTorpilleur);

		this.jPanelDroite = new JPanel();
		this.jPanelDroite.setLayout(new GridLayout());

		this.jPanelDroite.add(jPanelGeneralStandard);

		//// JLABEL EXPLICATION VIKING ////
		this.jLabelExplicationViking = new JLabel("Bateaux présents en viking : ");
		this.jLabelExplicationViking.setHorizontalAlignment(JLabel.CENTER);
		this.jLabelExplicationViking.setFont(new Font("Arial", Font.TRUETYPE_FONT, 20));

		this.jLabelExpVikDrakkar = new JLabel("1# Drakkar Commandant");
		this.jLabelExpVikDrakkar.setHorizontalAlignment(JLabel.CENTER);

		this.jLabelExpVikDrakkar2 = new JLabel("2# Drakkar D'élite");
		this.jLabelExpVikDrakkar2.setHorizontalAlignment(JLabel.CENTER);

		this.jLabelExpVikDrakkar3 = new JLabel("3# Drakkar");
		this.jLabelExpVikDrakkar3.setHorizontalAlignment(JLabel.CENTER);

		this.jLabelExpVikDrakkar4 = new JLabel("4# Petit Drakkar");
		this.jLabelExpVikDrakkar4.setHorizontalAlignment(JLabel.CENTER);

		this.jLabelExpVikDrakkar5 = new JLabel("5# Mini Drakkar");
		this.jLabelExpVikDrakkar5.setHorizontalAlignment(JLabel.CENTER);

		this.jPanelGeneralVik = new JPanel();
		this.jPanelGeneralVik.setLayout(new GridLayout(8, 1));
		this.jPanelGeneralVik.setPreferredSize(new Dimension(300, maFenetre.getWidth()));

		this.jPanelGeneralVik.add(jLabelExplicationViking);
		this.jPanelGeneralVik.add(jLabelExpVikDrakkar);
		this.jPanelGeneralVik.add(jLabelExpVikDrakkar2);
		this.jPanelGeneralVik.add(jLabelExpVikDrakkar3);
		this.jPanelGeneralVik.add(jLabelExpVikDrakkar4);
		this.jPanelGeneralVik.add(jLabelExpVikDrakkar5);

		// QTS MODE DE JEU
		this.jLabelQtsMDJ = new JLabel("Quel mode de jeu ?");

		this.buttonGroupMDJ = new ButtonGroup();

		this.jRadioButtonChoixStandard = new JRadioButton("Standard", true);
		this.jRadioButtonChoixViking = new JRadioButton("Viking");

		this.jRadioButtonChoixStandard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jPanelDroite.remove(jPanelGeneralVik);
				jPanelDroite.add(jPanelGeneralStandard);
				maFenetre.revalidate();
				maFenetre.repaint();

			}
		});

		this.jRadioButtonChoixViking.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				jPanelDroite.remove(jPanelGeneralStandard);
				jPanelDroite.add(jPanelGeneralVik);
				maFenetre.revalidate();
				maFenetre.repaint();

			}
		});

		this.buttonGroupMDJ.add(jRadioButtonChoixStandard);
		this.buttonGroupMDJ.add(jRadioButtonChoixViking);

		this.jPanelMDJ = new JPanel();

		this.jPanelMDJ.add(jLabelQtsMDJ);
		this.jPanelMDJ.add(jRadioButtonChoixStandard);
		this.jPanelMDJ.add(jRadioButtonChoixViking);

		// QTS COMMENTAIRE
		this.jLabelQtsCommentaire = new JLabel("Veux-tu les commentaires ?");

		this.buttonGroupCOM = new ButtonGroup();

		this.jRadioButtonOuiCom = new JRadioButton("Oui", true);
		this.jRadioButtonNonCom = new JRadioButton("Non");

		this.buttonGroupCOM.add(jRadioButtonOuiCom);
		this.buttonGroupCOM.add(jRadioButtonNonCom);

		this.jPanelCOM = new JPanel();

		this.jPanelCOM.add(jLabelQtsCommentaire);
		this.jPanelCOM.add(jRadioButtonOuiCom);
		this.jPanelCOM.add(jRadioButtonNonCom);
		// BOUTON REGLE

		this.jButtonAfficherRegle = new JButton("Règles");
		this.jButtonAfficherRegle.setHorizontalAlignment(JLabel.CENTER);
		this.jButtonAfficherRegle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fenetreRegle = new Regle();

			}
		});

		// BOUTON LANCER LA PARTIE
		this.jButtonLancerPartie = new JButton("Lancer la partie");
		this.jButtonLancerPartie.setHorizontalAlignment(JLabel.CENTER);
		this.jButtonLancerPartie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (jRadioButtonNonIA.isSelected()) {
					if (jTextFieldJoueur1.getText().isEmpty() || jTextFieldJoueur2.getText().isEmpty()) {
						erreur = new JOptionPane();
						JOptionPane.showMessageDialog(null, "Il manque des selections !", "Information",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						if (jRadioButtonChoixStandard.isSelected()) {
							partie.setModeSolo(false);
							partie.setNomJoueur1(jTextFieldJoueur1.getText());
							partie.setNomJoueur2(jTextFieldJoueur2.getText());
							fenetrePlacerBatStandard = new PlacerBatStandard(partie);
							maFenetre.dispose();
						} else {

							partie.setModeSolo(false);
							partie.setNomJoueur1(jTextFieldJoueur1.getText());
							partie.setNomJoueur2(jTextFieldJoueur2.getText());
							fenetrePlacerBatViking = new PlacerBatViking(partie);
							partie.setModeViking(true);
							maFenetre.dispose();

						}
					}
				} else {
					if (jTextFieldJoueur1.getText().isEmpty()) {
						erreur = new JOptionPane();
						JOptionPane.showMessageDialog(null, "Il manque des selections !", "Information",
								JOptionPane.INFORMATION_MESSAGE);
					} else {
						if (jRadioButtonChoixViking.isSelected()) {
							partie.setModeSolo(true);
							partie.setNomJoueur1(jTextFieldJoueur1.getText());
							maFenetre.dispose();
						} else {
							partie.setModeSolo(true);
							partie.setNomJoueur1(jTextFieldJoueur1.getText());
							maFenetre.dispose();
						}
					}

				}
			}

		});

		// ADD BOUTON AU JPANEL BOUTON
		this.jPanelBouton = new JPanel();
		this.jPanelBouton.add(jButtonLancerPartie);
		this.jPanelBouton.add(jButtonAfficherRegle);

		// CREATION DE JPANEL TOTAL
		this.jPanelTotal = new JPanel();
		this.jPanelTotal.setLayout(new BorderLayout());

		// CREATION DU JPANEL MILIEU
		this.jPanelMilieu = new JPanel();
		this.jPanelMilieu.setLayout(new GridLayout(6, 2));

		// ADD AU JPANEL MILIEU
		this.jPanelMilieu.add(jPanelMDJ);
		this.jPanelMilieu.add(jPanelCOM);
		this.jPanelMilieu.add(jPanelIA);
		this.jPanelMilieu.add(jPanelJ1);
		this.jPanelMilieu.add(jPanelJ2);
		this.jPanelMilieu.add(jPanelIANonDispo);
		

		// ADD AU JPANEL TOTAL
		this.jPanelTotal.add(jPanelTitreEtMenu, BorderLayout.NORTH);
		this.jPanelTotal.add(jPanelDroite, BorderLayout.EAST);
		this.jPanelTotal.add(jPanelBouton, BorderLayout.SOUTH);
		this.jPanelTotal.add(jPanelMilieu, BorderLayout.CENTER);

		// ADD FENETRE
		this.maFenetre.getContentPane().add(jPanelTotal);
		this.maFenetre.setVisible(true);

	}

	public static void main(String[] args) {
		new PageDeb();

	}

}
