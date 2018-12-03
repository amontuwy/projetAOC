import aoc.back.GenerateurImpl;
import aoc.front.Afficheur;
import aoc.proxy.Canal;
import aoc.strategy.DiffusionAtomique;
import aoc.strategy.DiffusionCausale;
import aoc.strategy.DiffusionSequentielle;
import aoc.swing.CommAfficheur;
import aoc.swing.Fenetre;

public class Main {

	public static void main(String[] args) {

		//c'est pas ouf d'utiliser generateur impl
		GenerateurImpl gen = new GenerateurImpl();
		gen.setAlg(new DiffusionCausale(gen));
		
		Afficheur aff1 = new Afficheur(1);
		Afficheur aff2 = new Afficheur(2);
		Afficheur aff3 = new Afficheur(3);
		
		Canal canal1 = new Canal();
		canal1.attach(aff1);
		Canal canal2 = new Canal();
		canal2.attach(aff2);
		Canal canal3 = new Canal();
		canal3.attach(aff3);
		
		gen.attach(canal1);
		gen.attach(canal2);
		gen.attach(canal3);
		
		Fenetre fen = new Fenetre(gen);
		
		CommAfficheur comm = new CommAfficheur(fen);
		aff1.addObserver(comm);
		aff2.addObserver(comm);
		aff3.addObserver(comm);
		gen.addObserver(comm);
		gen.run();
		
	}

}
