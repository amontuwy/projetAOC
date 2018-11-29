package aoc.strategy;

import aoc.back.GenerateurImpl;


public class DiffusionCausale implements AlgoDiffusion {
GenerateurImpl gen;
	
	public DiffusionCausale(GenerateurImpl gen) {
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
		System.out.println("-------------Diffusion Causale-------------------");
		
	}

}
