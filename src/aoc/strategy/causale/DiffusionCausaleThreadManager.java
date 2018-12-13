package aoc.strategy.causale;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import aoc.back.GenerateurImpl;
import aoc.proxy.interfacies.ObservateurGenerateurAsync;

/**
 * 
 * @author Angelique Montuwy, Antoine Posnic
 * Classe assurant la gestion d'un thread associe a un observateur (canal).
 */
public class DiffusionCausaleThreadManager {
	/** 
	 * Thread associe a l'observateur
	 */
	private Thread runner;
	/**
	 * Liste de copies de generateur dont il faut notifier l'observateur
	 */
	private List<GenerateurImpl> mementoGen;
	/**
	 * Observateur que le thread va notifier
	 */
	private ObservateurGenerateurAsync obs;

	/**
	 * Constructeur du gestionnaire de thread pour un observateur donne
	 * @param i: ObservateurGenerateurAsync
	 */
	public DiffusionCausaleThreadManager(ObservateurGenerateurAsync i) {
		super();
		this.obs = i;
		this.runner = new Thread();
		this.mementoGen = new ArrayList<GenerateurImpl>();
	}
	/**
	 * Si le thread est disponible, utilise le thread pour notifier l'observateur de la valeur de la copie de generateur en tete de liste (la copie la plus ancienne). Puis supprime cette copie de generateur. 
	 */
	void sendRunner() {
		if(!this.runner.isAlive()) {
			GenerateurImpl currGen = this.mementoGen.get(0);
			Future<Object> future = obs.update(currGen);
			
			this.runner = new Thread(new DiffusionCausalRunner(future));
			this.runner.start();

			this.mementoGen.remove(0);
		}
	}
	
	/**
	 * Ajoute dans la liste une version de GenerateurImpl dont il faudra notifier l'observateur a un moment donne.
	 * @param gen : GenerateurImpl
	 */
	public void addMementoGen(GenerateurImpl gen) {
		this.mementoGen.add(gen);
	}
}
