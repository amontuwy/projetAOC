package aoc.strategy.causale;

import java.util.concurrent.Future;
/**
 * @author Angelique Montuwy, Antoine Posnic
 * Classe assurant le bloquage du thread associe a chaque observateur tant que ce dernier n'a pas resolu son update (retourne par future).
 */
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
		}
		
	}