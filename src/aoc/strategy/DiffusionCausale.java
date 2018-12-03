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
	
	private void sendRunner0() {
		if(!this.runner0.isAlive()) {
			this.runner0 = new DiffusionCauRunner();

			GenerateurImpl currGen = this.mementoGenFor0.get(0);
						
			Future<Object> future;
			future = this.gen.getListobs().get(0).update(currGen);
			
			
			this.runner0.setFuture(future);
			this.runner0.start();

			this.mementoGenFor0.remove(0);
		}
	}

	private void sendRunner1() {
		if(!this.runner1.isAlive()) {
			this.runner1 = new DiffusionCauRunner();

			GenerateurImpl currGen = this.mementoGenFor1.get(0);
						
			Future<Object> future;
			future = this.gen.getListobs().get(1).update(currGen);
			
			
			this.runner1.setFuture(future);
			this.runner1.start();

			this.mementoGenFor1.remove(0);
		}
		
	}
	private void sendRunner2() {
		if(!this.runner2.isAlive()) {
			this.runner2 = new DiffusionCauRunner();

			GenerateurImpl currGen = this.mementoGenFor2.get(0);
						
			Future<Object> future;
			future = this.gen.getListobs().get(2).update(currGen);
			
			
			this.runner2.setFuture(future);
			this.runner2.start();

			this.mementoGenFor2.remove(0);
		}
		
	}

	@Override
	public void execute() {	
		GenerateurImpl tmpGen = new GenerateurImpl();
		tmpGen.setValue(this.gen.getValue());
		
		this.mementoGenFor0.add(tmpGen);
		this.mementoGenFor1.add(tmpGen);
		this.mementoGenFor2.add(tmpGen);
		
		
		this.sendRunner0();
		this.sendRunner1();
		this.sendRunner2();
		
	}


}
