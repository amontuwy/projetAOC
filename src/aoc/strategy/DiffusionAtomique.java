package aoc.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import aoc.back.GenerateurImpl;

/**
 * @author Angelique Montuwy, Antoine Posnic
 * Algorithme de notification des observateurs asynchrones du Generateur selon une coherence atomique.
 * Coherence atomique : tous les observateurs sont notifies de toutes les valeurs prises par le generateur. Celui-ci ne peut s'incrementer que quand tous les observateurs ont lu sa valeur. 
 * Algorithme bloquant pour le generateur et uni-thread pour assurer la coherence des valeurs entre tous les observateurs.
 */

public class DiffusionAtomique implements AlgoDiffusion {
	/**
	 * Generateur synchrone sur lequel s'excerce l'algorithme de diffusion
	 */
	GenerateurImpl gen;
	
	/**
	 * Constructeur de l'algorithme de diffusion pour une implementation de generateur donnee.
	 * @param gen: GenerateurImpl
	 */
	public DiffusionAtomique(GenerateurImpl gen) {
		super();
		this.gen = gen;
	}


	@Override
	/**
	 * Tous les observateurs sont notifies et on stocke dans un tableau les futures renvoyes par ses notifications.
	 * Puis on attend que tous les futures soient resolus (ce qui a pour effet de bloquer l'ecriture dans le generateur, qui attend le retour de cette methode).
	 */
	public void execute() {
		List <Future> futureList = new ArrayList<Future>();
		gen.getListobs().forEach(obs->futureList.add(obs.update(gen)));
		futureList.forEach(f->{
			try {
				f.get();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		System.out.println("----------Diffusion Atomique-------------------");
	}

}
