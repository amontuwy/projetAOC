package aoc.swing;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Fenetre extends JFrame {
	private JButton buttonAtom = new JButton("Diffusion Atomique");
	private JButton buttonSequ = new JButton("Diffusion Séquentielle");
	private JButton buttonCaus = new JButton("Diffusion Causale");

	JLabel canal1 = new JLabel("v1", JLabel.CENTER);
	JLabel canal2 = new JLabel("v2", JLabel.CENTER);
	JLabel canal3 = new JLabel("v3", JLabel.CENTER);
	JLabel canal4 = new JLabel("v4", JLabel.CENTER);
	
	JLabel labelC1 = new JLabel("Canal 1", JLabel.CENTER);
	JLabel labelC2 = new JLabel("Canal 2", JLabel.CENTER);
	JLabel labelC3 = new JLabel("Canal 3", JLabel.CENTER);
	JLabel labelC4 = new JLabel("Canal 4", JLabel.CENTER);
	
//  labelC1.setVerticalTextAlignment(SwingConstants.BOTTOM);
//	labelC2.setVerticalAlignment(JLabel.BOTTOM);
//	labelC3.setVerticalAlignment(JLabel.BOTTOM);
//	labelC4.setVerticalAlignment(JLabel.BOTTOM);
//	
	JLabel choose = new JLabel("Choix de la cohérence :");

	public Fenetre () {
		this.setTitle (" Observeur Asynchrone AOC ");
		this.setSize (800, 400);
		this.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		this.setLocationRelativeTo ( null );
		this.setVisible(true);
		this.setLayout(new GridLayout(3,4,10,10));
		this.add(labelC1);
		this.add(labelC2);
		this.add(labelC3);
		this.add(labelC4);
		this.add(canal1);
		this.add(canal2);
		this.add(canal3);
		this.add(canal4);
		this.add(choose);
		this.add(buttonAtom);
		this.add(buttonSequ);
		this.add(buttonCaus);
		buttonAtom.addActionListener ( new AtomListener());
		buttonSequ.addActionListener ( new SequListener());
		buttonCaus.addActionListener ( new CausListener());
	}

	public void clearLabel(){
		canal1.setText("");
		canal2.setText("");
		canal3.setText("");
		canal4.setText("");
	}

	class SequListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
		}
	}

	class CausListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
		}
	}

	class AtomListener implements ActionListener {
		public void actionPerformed ( ActionEvent arg0 ) {
			clearLabel();
		}
	}
}
