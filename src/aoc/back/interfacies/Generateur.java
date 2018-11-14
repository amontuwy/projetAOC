package aoc.back.interfacies;

import java.util.concurrent.Future;

import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.interfacies.GenerateurAsync;
import aoc.proxy.interfacies.ObservateurGenerateurAsync;

public interface Generateur {
	
	void attach (ObservateurGenerateurAsync canal);
	void detach (ObservateurGenerateurAsync canal);
	Future<Integer> getValue(GenerateurAsync canal);
}
