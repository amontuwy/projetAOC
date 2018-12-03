package aoc.swing;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import aoc.back.GenerateurImpl;
import aoc.strategy.DiffusionAtomique;
import aoc.strategy.DiffusionCausale;
import aoc.strategy.DiffusionSequentielle;

public class Fenetre extends JFrame {
	private JButton buttonAtom = new JButton("Diffusion Atomique");
	private JButton buttonSequ = new JButton("Diffusion Séquentielle");
	private JButton buttonCaus = new JButton("Diffusion Causale");

	JLabel generateur = new JLabel("", JLabel.CENTER);
	JLabel canal1 = new JLabel("", JLabel.CENTER);
	JLabel canal2 = new JLabel("", JLabel.CENTER);
	JLabel canal3 = new JLabel("", JLabel.CENTER);
	
	JLabel labelG = new JLabel("Générateur ", JLabel.CENTER);
	JLabel labelC1 = new JLabel("Canal 1", JLabel.CENTER);
	JLabel labelC2 = new JLabel("Canal 2", JLabel.CENTER);
	JLabel labelC3 = new JLabel("Canal 3", JLabel.CENTER);

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
		this.add(labelC1);
		this.add(labelC2);
		this.add(labelC3);
		
		this.add(generateur);
		this.add(canal1);
		this.add(canal2);
		this.add(canal3);
		
		this.add(choose);
		this.add(buttonAtom);
		this.add(buttonSequ);
		this.add(buttonCaus);
		generateur.setOpaque(true);
		generateur.setBackground(Color.white);
		buttonAtom.addActionListener ( new AtomListener());
		buttonSequ.addActionListener ( new SequListener());
		buttonCaus.addActionListener ( new CausListener());
	}

	public void clearLabel(){
		canal1.setText("");
		canal2.setText("");
		canal3.setText("");
	}
	
	public void setValue(JLabel label, String text) {
		label.setText(text);
	}

	class SequListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
			gen.setAlg(new DiffusionSequentielle(gen));
		}
	}

	class CausListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
			gen.setAlg(new DiffusionCausale(gen));
		}
	}

	class AtomListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
			gen.setAlg(new DiffusionAtomique(gen));
		}
	}
}
