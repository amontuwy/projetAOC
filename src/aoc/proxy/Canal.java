package aoc.proxy;

import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import aoc.back.interfacies.Generateur;
import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.interfacies.GenerateurAsync;
import aoc.proxy.interfacies.ObservateurGenerateurAsync;


/**
 * @author Angelique Montuwy, Antoine Posnic
 * La classe canal est a l'interface des mondes synchones et asynchrones. Un canal est observateur du point de vue du generateur synchrone, et generateur du point de vue des afficheurs synchrones.
 * Le canal joue donc le double role de generateur asynchrone et d'observateur asynchrone par l'implementation des interfaces GenerateurAsync et ObservateurGenerateurAsync.
 */
public class Canal implements ObservateurGenerateurAsync, GenerateurAsync {
	/**
	 * Ensemble de threads disponibles pour l'execution asynchrone du pattern observateur/generateur entre le generateur synchrone et les afficheurs synchrones.
	 */
	private ScheduledExecutorService schExecSv = new ScheduledThreadPoolExecutor(10);
	/**
	 * Generateur rendu asynchrone par le recours au canal.  
	 */
	Generateur gen;
	/**
	 * Observateur rendu asynchonre par le recours au canal.
	 */
	ObservateurGenerateur obs; 

	/**
	 * Constructeur de canal.
	 */
	public Canal() {

	}

	@Override
	/**
	 * Attache un observateur synchrone au generateur asynchrone qu'est le canal. 
	 */
	public void attach(ObservateurGenerateur obs) {
		this.obs=obs;
		
	}

	@Override
	/**
	 * Detache l'observateur du generateur asynchrone qu'est le canal. 
	 */
	public void detach(ObservateurGenerateur obs) {
		this.obs=null;
		
	}

	@Override
	/**
	 * Met en attente ("schedule") l'appel au getValue du generateur synchrone afin de rendre l'appel au generateur asynchrone du point de vue de l'observateur. L'execution est realisee avec au moins un delai compris entre 0s et 3s.
	 */
	public Future<Integer> getValue() {
		return this.schExecSv.schedule(new GetValue(this.gen), new Random().nextInt(3000), TimeUnit.MILLISECONDS);
	}

	@Override
	/**
	 * Met en attente ("schedule") l'appel au update de l'observateur synchrone afin de rendre l'appel a l'observateur asynchrone du point de vue du generateur. L'execution est realisee avec au moins un delai compris entre 0s et 3s.
	 */
	public Future<Object> update(Generateur gen) {
		this.gen = gen;
		return this.schExecSv.schedule(new Update(this.obs, this), new Random().nextInt(3000), TimeUnit.MILLISECONDS);
	}


}
