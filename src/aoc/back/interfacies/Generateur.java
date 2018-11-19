package aoc.back.interfacies;

import aoc.proxy.interfacies.ObservateurGenerateurAsync;

public interface Generateur {
	
	void attach (ObservateurGenerateurAsync observateur);
	void detach (ObservateurGenerateurAsync observateur);
	
	Integer getValue(ObservateurGenerateurAsync canal);
}
