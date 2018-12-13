package aoc.proxy;

import java.util.concurrent.Callable;

import aoc.back.interfacies.Generateur;
import aoc.proxy.interfacies.ObservateurGenerateurAsync;
/**
 * @author Angelique Montuwy, Antoine Posnic
 * Classe du monde asynchrone implementant Callable. Objet qui est mis en attente et invoque par le scheduler. Il permet l'appel a la valeur du generateur synchrone depuis le monde asynchrone. 
 */
public class GetValue implements Callable<Integer> {
	/**
	 * Necessite un generateur synchrone sur lequel appeler la valeur.
	 */
	Generateur gen;
	
	/**
	 * Constructeur du callable
	 * @param gen: Generateur
	 */
	public GetValue(Generateur gen) {
		this.gen = gen;
	}

	@Override
	/**
	 * Realise l'appel synchrone au generateur une fois que le Callable est traite par le scheduler.
	 */
	public Integer call() throws Exception {
		return this.gen.getValue();
	}
}
