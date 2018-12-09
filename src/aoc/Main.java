package aoc;
import aoc.back.GenerateurImpl;
import aoc.front.Afficheur;
import aoc.proxy.Canal;
import aoc.strategy.causale.DiffusionCausale;
import aoc.swing.CommAfficheur;
import aoc.swing.Fenetre;

public class Main {
	public static final int NB_VALUES_GEN=3;

	public static void main(String[] args) {

		//c'est pas ouf d'utiliser generateur impl
		GenerateurImpl gen = new GenerateurImpl();
		gen.setAlg(new DiffusionCausale(gen));

		Fenetre fen = new Fenetre(gen);
		CommAfficheur comm = new CommAfficheur(fen);
		
		for(int i=0; i<Main.NB_VALUES_GEN; i++) {
			Afficheur aff = new Afficheur(i);
			
			Canal canal = new Canal();
			canal.attach(aff);
			
			gen.attach(canal);
			aff.addObserver(comm);
		}
		
		gen.addObserver(comm);
		gen.run();
		
	}
}
