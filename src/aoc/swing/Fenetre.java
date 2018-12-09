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

public class Fenetre extends JFrame {
	private JButton buttonAtom = new JButton("Diffusion Atomique");
	private JButton buttonSequ = new JButton("Diffusion Séquentielle");
	private JButton buttonCaus = new JButton("Diffusion Causale");

	JLabel generateur = new JLabel("", JLabel.CENTER);
	List<JLabel> canaux = new ArrayList<>();

	JLabel labelG = new JLabel("Générateur ", JLabel.CENTER);

	JLabel choose = new JLabel("Choix de la cohérence :");
	GenerateurImpl gen;

	public Fenetre (GenerateurImpl gen) {
		this.gen = gen;
		this.setTitle (" Observeur Asynchrone AOC ");
		this.setSize (800, 400);
		this.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		this.setLocationRelativeTo ( null );
		this.setVisible(true);
		this.setLayout(new GridLayout(3,4,10,10));

		this.add(labelG);
		for(int i=0; i<Main.NB_VALUES_GEN; i++) {
			this.add(new JLabel("Canal "+i, JLabel.CENTER));
		}

		this.add(generateur);
		for(int i=0; i<Main.NB_VALUES_GEN; i++) {
			JLabel canal = new JLabel("", JLabel.CENTER);
			canaux.add(canal);
			this.add(canal);
		}

		this.add(choose);
		this.add(buttonAtom);
		this.add(buttonSequ);
		this.add(buttonCaus);

		setButtonColor(buttonCaus);
		
		generateur.setOpaque(true);
		generateur.setBackground(Color.white);
		
		buttonAtom.addActionListener(new AtomListener());
		buttonSequ.addActionListener(new SequListener());
		buttonCaus.addActionListener(new CausListener());
	}

	public void clearLabel(){
		for(JLabel canal:canaux) {
			canal.setText("");
		}
	}

	public void setCanalText(String text, int indCanal) {
		canaux.get(indCanal).setText(text);
	}

	public void setValue(JLabel label, String text) {
		label.setText(text);
	}

	public void setButtonColor(JButton button) {
		buttonAtom.setBackground(Color.GRAY);
		buttonSequ.setBackground(Color.GRAY);
		buttonCaus.setBackground(Color.GRAY);

		button.setBackground(Color.GREEN);
	}

	class SequListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
			gen.setAlg(new DiffusionSequentielle(gen));
			setButtonColor(buttonSequ);
		}
	}

	class CausListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
			gen.setAlg(new DiffusionCausale(gen));
			setButtonColor(buttonCaus);
		}
	}

	class AtomListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
			gen.setAlg(new DiffusionAtomique(gen));
			setButtonColor(buttonAtom);
		}
	}

	public void setGenerateurText(String text){
		this.generateur.setText(text);
	}
}
