package aoc.back;

import java.util.concurrent.Future;

import aoc.front.ObservateurGenerateur;

public interface Generateur {
	
	void attach (ObservateurGenerateur obs);
	void detach (ObservateurGenerateur obs);
	Future<Integer> getValue();
}
