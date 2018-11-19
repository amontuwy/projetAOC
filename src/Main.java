import aoc.back.GenerateurImpl;
import aoc.back.interfacies.Generateur;
import aoc.front.Afficheur;
import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.Canal;

public class Main {

	public static void main(String[] args) {
		//Fenetre fenetre = new Fenetre();
		Generateur gen = new GenerateurImpl();
		ObservateurGenerateur aff1 = new Afficheur();
		ObservateurGenerateur aff2 = new Afficheur();
		ObservateurGenerateur aff3 = new Afficheur();
		Canal canal1 = new Canal(aff1);
		Canal canal2 = new Canal(aff2);
		Canal canal3 = new Canal(aff3);
		
		gen.attach(canal1);
		gen.attach(canal2);
		gen.attach(canal3);
	

	}

}
