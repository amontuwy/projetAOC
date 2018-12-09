package aoc.strategy.causale;

import java.util.ArrayList;
import java.util.List;

import aoc.Main;
import aoc.back.GenerateurImpl;
import aoc.strategy.AlgoDiffusion;


public class DiffusionCausale implements AlgoDiffusion {
	private GenerateurImpl gen;
	private List<DiffusionCausaleThreadManager> diffusionCausaleThreads;

	
	public DiffusionCausale(GenerateurImpl gen) {
		super();
		this.gen = gen;
		
		this.diffusionCausaleThreads = new ArrayList<>();
		for(int i=0; i<Main.NB_VALUES_GEN; i++) {
			this.diffusionCausaleThreads.add(new DiffusionCausaleThreadManager(gen, i));
		}
	}
	
	@Override
	public void configure() {
		// TODO Auto-generated method stub
	}

	@Override
	public void execute() {	
		GenerateurImpl tmpGen = new GenerateurImpl();
		tmpGen.setValue(this.gen.getValue());
		
		for(DiffusionCausaleThreadManager diffusionCausaleThread : diffusionCausaleThreads) {
			diffusionCausaleThread.addMementoGen(tmpGen);
			diffusionCausaleThread.sendRunner();
		}
	}
}
