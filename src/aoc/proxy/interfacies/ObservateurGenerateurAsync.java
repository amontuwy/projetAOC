package aoc.proxy.interfacies;

import java.util.concurrent.Future;

import aoc.back.interfacies.Generateur;

public interface ObservateurGenerateurAsync {
	Future<Object> update (Generateur gen);
}
