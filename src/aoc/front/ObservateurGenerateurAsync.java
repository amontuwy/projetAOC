package aoc.front;

import java.util.concurrent.Future;

import aoc.back.Generateur;

public interface ObservateurGenerateurAsync {
	Future<Object> update (Generateur gen);
}
