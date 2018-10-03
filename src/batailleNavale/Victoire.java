package batailleNavale;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Victoire {
	private final JFrame maFenetre;
	private final JButton jBNewPartie;
	private final JButton jBQuitter;
	private final JLabel jLTexteVictoire;
	private final JPanel jPanelBouton;
	private Partie partie;
	private final JPanel jPanelGeneral;

	public Victoire(Partie partie) {
		maFenetre = new JFrame();
		maFenetre.setTitle("Victoire");
		maFenetre.setSize(500, 500);
		maFenetre.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		maFenetre.setExtendedState(JFrame.MAXIMIZED_BOTH);

		// INITIALISATION TEXTE VICTOIRE
		if (partie.getScoreJ1() == 50) {
			this.jLTexteVictoire = new JLabel(partie.getNomJoueur1() + " est le grand vainqueur ! ");
		} else {
			this.jLTexteVictoire = new JLabel(partie.getNomJoueur2() + " est le grand vainqueur ! ");
		}
		this.jLTexteVictoire.setHorizontalAlignment(JLabel.CENTER);
		this.jLTexteVictoire.setFont(new Font("Arial Black", Font.BOLD, 30));

		// BOUTON QUITTER
		this.jBQuitter = new JButton("Quitter");
		this.jBQuitter.setHorizontalAlignment(JLabel.CENTER);

		this.jBQuitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				maFenetre.dispose();
			}
		});

		// BOUTON NEW PARTIE
		this.jBNewPartie = new JButton("Nouvelle partie");
		this.jBNewPartie.setHorizontalAlignment(JLabel.CENTER);

		this.jBNewPartie.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PageDeb();
				maFenetre.dispose();
			}
		});

		// PANEL BOUTON
		this.jPanelBouton = new JPanel();
		
		this.jPanelBouton.add(jBNewPartie);
		this.jPanelBouton.add(jBQuitter);
		
		//PANEL GENERAL
		this.jPanelGeneral = new JPanel();
		this.jPanelGeneral.setLayout(new BorderLayout());

		this.jPanelGeneral.add(jLTexteVictoire, BorderLayout.CENTER);
		this.jPanelGeneral.add(jPanelBouton, BorderLayout.SOUTH);
		
		maFenetre.getContentPane().add(this.jPanelGeneral);
		maFenetre.setVisible(true);
	}

}
