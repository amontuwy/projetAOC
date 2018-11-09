package aoc.back;

import java.util.concurrent.Future;

import aoc.front.ObservateurGenerateur;

public interface GenerateurAsync {

	void attach (ObservateurGenerateur obs);
	void detach (ObservateurGenerateur obs);
	Future<Integer> getValue();
}
