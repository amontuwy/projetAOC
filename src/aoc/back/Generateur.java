package aoc.back;

import aoc.front.ObservateurGenerateur;

public interface Generateur {
	
	void attach (ObservateurGenerateur obs);
	void detach (ObservateurGenerateur obs);
	Integer getValue();
}
