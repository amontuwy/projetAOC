package aoc.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import aoc.back.GenerateurImpl;


public class DiffusionSequentielle implements AlgoDiffusion {

	private class DiffusionSeqRunner extends Thread{
		List <Future> futureList;
		
		public DiffusionSeqRunner() {
			this.futureList = new ArrayList<Future>();
		}
		
		public void setFutureList(List<Future> futureList) {
			this.futureList = futureList;
		}
		
		@Override
		public void run() {
			System.out.println(this.isAlive());
			futureList.forEach(f->{
				try {
					f.get();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			System.out.println("----------Diffusion Sequentielle-------------------");
		}
		
	}
	
	private DiffusionSeqRunner runner;
	private GenerateurImpl gen;
	
	public DiffusionSequentielle(GenerateurImpl gen) {
		super();
		this.runner = new DiffusionSeqRunner();
		this.gen = gen;
	}
	
	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void execute() {		
		if(!this.runner.isAlive()) {
			this.runner = new DiffusionSeqRunner();
			GenerateurImpl genClone = new GenerateurImpl();
			genClone.setValue(gen.getValue());
			
			List <Future> futureList = new ArrayList<Future>();
			gen.getListobs().forEach(obs->futureList.add(obs.update(genClone)));
			runner.setFutureList(futureList);
			runner.start();
		}else {
		}
	}

}
