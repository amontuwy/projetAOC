import aoc.back.GenerateurImpl;
import aoc.back.interfacies.Generateur;
import aoc.front.Afficheur;
import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.Canal;
import aoc.strategy.AlgoDiffusion;
import aoc.strategy.DiffusionAtomique;
import aoc.strategy.DiffusionCausale;
import aoc.strategy.DiffusionSequentielle;

public class Main {

	public static void main(String[] args) {

		//c'est pas ouf d'utiliser generateur impl
		GenerateurImpl gen = new GenerateurImpl();
		gen.setAlg(new DiffusionSequentielle(gen));
		
		ObservateurGenerateur aff1 = new Afficheur(1);
		ObservateurGenerateur aff2 = new Afficheur(2);
		ObservateurGenerateur aff3 = new Afficheur(3);
		
		Canal canal1 = new Canal();
		canal1.attach(aff1);
		Canal canal2 = new Canal();
		canal2.attach(aff2);
		Canal canal3 = new Canal();
		canal3.attach(aff3);
		
		gen.attach(canal1);
		gen.attach(canal2);
		gen.attach(canal3);
		
		gen.run();
		
	}

}
