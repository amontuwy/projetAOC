package aoc.proxy;

import java.util.concurrent.Callable;

import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.interfacies.GenerateurAsync;

/**
 * @author Angelique Montuwy, Antoine Posnic
 * Classe du monde asynchrone implementant Callable. Objet qui est mis en attente et invoque par le scheduler. Il permet la notification de l'observateur synchrone depuis le monde asynchrone. 
 */
public class Update implements Callable<Object> {
	/**
	 * Necessite un observateur synchrone sur lequel notifier du changement de valeur.
	 */
	ObservateurGenerateur obs;
	/**
	 * Necessite un generateur asynchrone sur lequel l'observateur pourra requeter pour obtenir la valeur modifiee.
	 */
	GenerateurAsync canal;

	/**
	 * Constructeur du Callable
	 * @param obs : ObservateurGenerateur
	 * @param canal: GenerateurAsync
	 */
	public Update(ObservateurGenerateur obs, GenerateurAsync canal) {
		this.obs=obs;
		this.canal=canal;
	}

	/**
	 * Realise la notification synchrone sur l'afficheur une fois que le Callable est traite par le scheduler.
	 */
	@Override
	public Object call() throws Exception {
		this.obs.update(this.canal);
		return null;
	}
	

}
