package aoc.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
