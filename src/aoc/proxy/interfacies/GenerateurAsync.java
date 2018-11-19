package aoc.proxy.interfacies;

import java.util.concurrent.Future;

import aoc.front.interfacies.ObservateurGenerateur;

public interface GenerateurAsync {

	void attach (ObservateurGenerateur obs);
	void detach (ObservateurGenerateur obs);
	
	//pourquoi ici getvalue ne prend pas de parametre alors ?
	Future<Integer> getValue(ObservateurGenerateur obs);
}
