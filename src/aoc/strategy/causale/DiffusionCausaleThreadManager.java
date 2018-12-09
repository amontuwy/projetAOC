package aoc.strategy.causale;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import aoc.back.GenerateurImpl;

public class DiffusionCausaleThreadManager {
	private Thread runner;
	private List<GenerateurImpl> mementoGen;
	
	private GenerateurImpl gen;
	private int indObserver;

	public DiffusionCausaleThreadManager(GenerateurImpl gen, int indObserver) {
		super();
		this.gen = gen;
		this.indObserver = indObserver;
		this.runner = new Thread();
		this.mementoGen = new ArrayList<GenerateurImpl>();
	}
	
	void sendRunner() {
		if(!this.runner.isAlive()) {
			GenerateurImpl currGen = this.mementoGen.get(0);
			Future<Object> future = this.gen.getListobs().get(this.indObserver).update(currGen);
			
			this.runner = new Thread(new DiffusionCausalRunner(future));
			this.runner.start();

			this.mementoGen.remove(0);
		}
	}
	
	public void addMementoGen(GenerateurImpl gen) {
		this.mementoGen.add(gen);
	}
}
