package aoc.swing;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import aoc.Main;
import aoc.back.GenerateurImpl;
import aoc.strategy.DiffusionAtomique;
import aoc.strategy.causale.DiffusionCausale;
import aoc.strategy.sequentielle.DiffusionSequentielle;

/**
 * 
 * @author Angelique Montuwy, Antoine Posnic
 * Classe permettant l'affichage graphique des valeurs du generateur et des afficheurs.
 * Offre de selection un des 3 algorithmes de diffusion.
 */
public class Fenetre extends JFrame {
	/**
	 * Boutons de selection d'un des 3 algorithmes
	 */
	private JButton buttonAtom = new JButton("Diffusion Atomique");
	private JButton buttonSequ = new JButton("Diffusion Sequentielle");
	private JButton buttonCaus = new JButton("Diffusion Causale");

	/**
	 * JLabel destine a l'affichage de la valeur du generateur.
	 */
	JLabel generateur = new JLabel("", JLabel.CENTER);
	/**
	 * Liste de JLabel destines a l'affichage de la valeur des afficheurs.
	 */
	List<JLabel> canaux = new ArrayList<>();

	/**
	 * Titre du generateur
	 */
	JLabel labelG = new JLabel("Generateur ", JLabel.CENTER);

	JLabel choose = new JLabel("Choix de la coherence :");
	GenerateurImpl gen;

	/**
	 * Constructeur de la fenetre d'affichage pour un generateur et un certain nombre d'afficheurs (definis dans le Main).
	 * @param gen: GenerateurImpl
	 */
	public Fenetre (GenerateurImpl gen) {
		this.gen = gen;
		this.setTitle (" Observeur Asynchrone AOC ");
		this.setSize (800, 400);
		this.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		this.setLocationRelativeTo ( null );
		this.setVisible(true);
		this.setLayout(new GridLayout(3,4,10,10));

		this.add(labelG);
		
		/**
		 * Definition d'autant de titres d'afficheur que demande dans le main.
		 */
		
		for(int i=0; i<Main.NB_VALUES_AFF; i++) {
			this.add(new JLabel("Afficheur "+i, JLabel.CENTER));
		}

		this.add(generateur);
		/**
		 * Creation d'autant de JLabel destines a l'affiachage des valeurs des afficheurs que d'afficheurs demandes dans le main.
		 */
		for(int i=0; i<Main.NB_VALUES_AFF; i++) {
			JLabel canal = new JLabel("", JLabel.CENTER);
			canaux.add(canal);
			this.add(canal);
		}

		this.add(choose);
		this.add(buttonAtom);
		this.add(buttonSequ);
		this.add(buttonCaus);

		setButtonColor(buttonAtom);
		
		generateur.setOpaque(true);
		generateur.setBackground(Color.white);
		
		buttonAtom.addActionListener(new AtomListener());
		buttonSequ.addActionListener(new SequListener());
		buttonCaus.addActionListener(new CausListener());
	}

	/**
	 * Efface la valeur de tous les afficheurs
	 */
	public void clearLabel(){
		for(JLabel canal:canaux) {
			canal.setText("");
		}
	}

	/**
	 * Modifie la valeur affichee dans le JLabel correspondant a l'afficheur d'indice indCanal par le texte passe en parametre.
	 * @param text: string
	 * @param indCanal: int 
	 */
	public void setCanalText(String text, int indCanal) {
		canaux.get(indCanal).setText(text);
	}
	
	/**
	 * Modifie la valeur affichee dans le JLabel correspondant au generateur par le texte passe en parametre.
	 * @param text: string
	 */
	public void setGenerateurText(String text){
		this.generateur.setText(text);
	}

	/**
	 * Passe en vert le bouton correspondant a l'agorithme de diffusion actuellement utilise.
	 * @param button: JButton
	 */
	public void setButtonColor(JButton button) {
		buttonAtom.setBackground(Color.GRAY);
		buttonSequ.setBackground(Color.GRAY);
		buttonCaus.setBackground(Color.GRAY);

		button.setBackground(Color.GREEN);
	}

	/**
	 * Listener permettant d'utiliser un algorithme de diffusion sequentielle sur le generateur associe a la fenetre.
	 */
	class SequListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
			gen.setAlg(new DiffusionSequentielle(gen));
			setButtonColor(buttonSequ);
		}
	}

	/**
	 * Listener permettant d'utiliser un algorithme de diffusion causale sur le generateur associe a la fenetre.
	 */
	class CausListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
			gen.setAlg(new DiffusionCausale(gen));
			setButtonColor(buttonCaus);
		}
	}

	/**
	 * Listener permettant d'utiliser un algorithme de diffusion atomique sur le generateur associe a la fenetre.
	 */
	class AtomListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
			gen.setAlg(new DiffusionAtomique(gen));
			setButtonColor(buttonAtom);
		}
	}

	
}
