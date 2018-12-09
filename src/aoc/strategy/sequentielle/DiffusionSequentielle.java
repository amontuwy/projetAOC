package aoc.strategy.sequentielle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import aoc.back.GenerateurImpl;
import aoc.strategy.AlgoDiffusion;


public class DiffusionSequentielle implements AlgoDiffusion {
	private Thread runner;
	private GenerateurImpl gen;
	
	public DiffusionSequentielle(GenerateurImpl gen) {
		super();
		this.runner = new Thread();
		this.gen = gen;
	}
	
	@Override
	public void configure() {
		// TODO Auto-generated method stub
	}

	@Override
	public void execute() {		
		if(!this.runner.isAlive()) {
			GenerateurImpl genClone = new GenerateurImpl();
			genClone.setValue(gen.getValue());
			
			List <Future<Object>> futureList = new ArrayList<Future<Object>>();
			gen.getListobs().forEach(obs->futureList.add(obs.update(genClone)));

			runner = new Thread(new DiffusionSeqRunner(futureList));
			runner.start();
		}
	}

}
