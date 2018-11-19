package aoc.front;

import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.interfacies.GenerateurAsync;

public class Afficheur implements ObservateurGenerateur{

	@Override
	public void update(GenerateurAsync generateur) { // notre générateur ici, c'est le canal
		generateur.getValue();
	}

}
