package aoc.strategy.sequentielle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import aoc.back.GenerateurImpl;
import aoc.strategy.AlgoDiffusion;

/**
 * @author Angelique Montuwy, Antoine Posnic
 * Algorithme de notification des observateurs asynchrones du Generateur selon une coherence sequentielle.
 * Coherence sequentielle: tous les observateurs sont notifies d'une meme sous ensemble des valeurs prises par le generateur, tandis que celui-ci continue de s'incrementer. 
 * Algorithme non-bloquant pour le generateur et uni-thread pour assurer la coherence des valeurs entre tous les observateurs.
 */

public class DiffusionSequentielle implements AlgoDiffusion {
	/**
	 * Thread utilise pour notifier l'ensemble des observateurs du generateur de sa valeur a un instant t.
	 */
	private Thread runner;
	/**
	 * Generateur synchrone sur lequel s'excerce l'algorithme de diffusion
	 */
	private GenerateurImpl gen;
	
	/**
	 * Constructeur de l'algorithme de diffusion pour une implementation de generateur donnee.
	 * Un thread est cree pour pouvoir notifier les observateurs d'une copie du generateur, afin qu'ils en voient tous la meme valeur. 
	 * @param gen: GenerateurImpl
	 */
	public DiffusionSequentielle(GenerateurImpl gen) {
		super();
		this.runner = new Thread();
		this.gen = gen;
	}
	
	@Override
	/**
	 * Si le thread est libre, copie le generateur courant et notifie les observateurs du generateur avec cette copie.
	 * Puis lance dans le thread l'attente de la resolution de tous les update des observateurs (diffusuion atomique sur la copie du generateur).
	 */
	public void execute() {		
		if(!this.runner.isAlive()) {
			GenerateurImpl genClone = new GenerateurImpl();
			genClone.setValue(gen.getValue());
			
			List <Future<Object>> futureList = new ArrayList<Future<Object>>();
			gen.getListobs().forEach(obs->futureList.add(obs.update(genClone)));

			runner = new Thread(new DiffusionSeqRunner(futureList));
			runner.start();
		}
		System.out.println("----------Diffusion Sequentielle-------------------");
	}

}
