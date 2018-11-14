package aoc.proxy.interfacies;

import java.util.concurrent.Future;

import aoc.front.interfacies.ObservateurGenerateur;

public interface GenerateurAsync {

	void attach (ObservateurGenerateur obs);
	void detach (ObservateurGenerateur obs);
	Future<Integer> getValue();
}
