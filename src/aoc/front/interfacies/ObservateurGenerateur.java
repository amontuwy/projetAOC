package aoc.front.interfacies;

import aoc.back.interfacies.Generateur;
import aoc.proxy.interfacies.GenerateurAsync;

public interface ObservateurGenerateur {
	void update (GenerateurAsync canal);
}
