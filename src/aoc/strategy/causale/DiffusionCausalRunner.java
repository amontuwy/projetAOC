package aoc.strategy.causale;

import java.util.concurrent.Future;

class DiffusionCausalRunner implements Runnable {
		Future<Object> future;
		
		public DiffusionCausalRunner(Future<Object> future) {
			super();
			this.future = future;
		}
		
		@Override
		public void run() {
			try {
				this.future.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("----------Diffusion Causale-------------------");
		}
		
	}