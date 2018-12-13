package aoc.strategy.causale;

import java.util.ArrayList;
import java.util.List;

import aoc.Main;
import aoc.back.GenerateurImpl;
import aoc.strategy.AlgoDiffusion;


/**
 * @author Angelique Montuwy, Antoine Posnic
 * Algorithme de notification des observateurs asynchrones du Generateur selon une coherence causale.
 * Coherence causale: tous les observateurs sont notifies de toutes les valeurs prises par le generateur, tandis que celui-ci continue de s'incrementer. 
 * Algorithme non-bloquant et multi-thread.
 */
public class DiffusionCausale implements AlgoDiffusion {
	/**
	 * Generateur synchrone sur lequel s'excerce l'algorithme de diffusion
	 */
	private GenerateurImpl gen;
	/**
	 * Liste des gestionnaires de thread, un thread etant attribue a la notification de chaque observateur.
	 */
	private List<DiffusionCausaleThreadManager> diffusionCausaleThreads;

	/**
	 * Constructeur de l'algorithme de diffusion pour une implementation de generateur donnee.
	 * Autant de gestionnaires de thread (et donc de threads) sont construits que de canaux dans le systeme. 
	 * @param gen: GenerateurImpl
	 */
	public DiffusionCausale(GenerateurImpl gen) {
		super();
		this.gen = gen;
		
		this.diffusionCausaleThreads = new ArrayList<>();
		for(int i=0; i<Main.NB_VALUES_AFF; i++) {
			this.diffusionCausaleThreads.add(new DiffusionCausaleThreadManager(gen.getListobs().get(i)));
		}
	}

	@Override
	/**
	 * Copie le generateur courant et le passe aux gestionnaires de threads associes a chaque observateur (canal).
	 */
	public void execute() {	
		GenerateurImpl tmpGen = new GenerateurImpl();
		tmpGen.setValue(this.gen.getValue());
		
		for(DiffusionCausaleThreadManager diffusionCausaleThread : diffusionCausaleThreads) {
			diffusionCausaleThread.addMementoGen(tmpGen);
			diffusionCausaleThread.sendRunner();
		}
		System.out.println("----------Diffusion Causale-------------------");
	}
}
