package aoc.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import aoc.back.GenerateurImpl;


public class DiffusionCausale implements AlgoDiffusion {

	private class DiffusionCauRunner extends Thread {
		Future<Object> future;
		
		public DiffusionCauRunner() {
			super();
		}
		
		public void setFuture(Future<Object> future) {
			this.future = future;
		}
		
		@Override
		public void run() {
			try {
				this.future.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("----------Diffusion Causal-------------------");
		}
		
	}

	private DiffusionCauRunner runner0;
	private DiffusionCauRunner runner1;
	private DiffusionCauRunner runner2;
	
	private List<GenerateurImpl> mementoGenFor0;
	private List<GenerateurImpl> mementoGenFor1;
	private List<GenerateurImpl> mementoGenFor2;
	
	private GenerateurImpl gen;
	
	
	public DiffusionCausale(GenerateurImpl gen) {
		super();
		this.runner0 = new DiffusionCauRunner();
		this.runner1 = new DiffusionCauRunner();
		this.runner2 = new DiffusionCauRunner();
		
		this.mementoGenFor0 = new ArrayList<GenerateurImpl>();
		this.mementoGenFor1 = new ArrayList<GenerateurImpl>();
		this.mementoGenFor2 = new ArrayList<GenerateurImpl>();
		
		this.gen = gen;
	}
	
	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}
	
	private void sendRunner(DiffusionCauRunner runner, int indexObs, List<GenerateurImpl> listGen) {
		if(!runner.isAlive() && (listGen.size() > 0)) {
			switch(indexObs) {
			case 0 : 
				this.runner0 = new DiffusionCauRunner();
				break;
			case 1 : 
				this.runner1 = new DiffusionCauRunner();
				break;
			case 2 : 
				this.runner2 = new DiffusionCauRunner();
				break;
				
			}
			
			GenerateurImpl currGen = listGen.get(0);
						
			Future<Object> future;
			future = this.gen.getListobs().get(indexObs).update(currGen);
			
			
			runner.setFuture(future);
			runner.start();

			listGen.remove(0);
		}
		
	}

	@Override
	public void execute() {	
		GenerateurImpl tmpGen = new GenerateurImpl();
		tmpGen.setValue(this.gen.getValue());
		
		this.mementoGenFor0.add(tmpGen);
		this.mementoGenFor1.add(tmpGen);
		this.mementoGenFor2.add(tmpGen);
		
		
		this.sendRunner(this.runner0, 0, this.mementoGenFor0);
		this.sendRunner(this.runner1, 1, this.mementoGenFor1);
		this.sendRunner(this.runner2, 2, this.mementoGenFor2);
		
	}


}
