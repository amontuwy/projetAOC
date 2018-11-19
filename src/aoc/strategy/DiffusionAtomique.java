package aoc.strategy;

import aoc.back.GenerateurImpl;

public class DiffusionAtomique implements AlgoDiffusion {
	GenerateurImpl gen;
	
	public DiffusionAtomique(GenerateurImpl gen) {
		super();
		this.gen = gen;
	}

	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {
		gen.getListobs().forEach(obs->obs.update(gen));
	}

}
