package aoc.strategy.sequentielle;

import java.util.List;
import java.util.concurrent.Future;
/**
 * @author Angelique Montuwy, Antoine Posnic
 * Classe assurant le bloquage du thread de notification des observateurs tant que ces derniers n'ont pas resolu leur update (stockes dans la liste de future).
 */
class DiffusionSeqRunner implements Runnable {
	List <Future<Object>> futureList;

	public DiffusionSeqRunner(List<Future<Object>> futureList) {
		this.futureList = futureList;
	}

	@Override
	public void run() {
		futureList.forEach(f->{
			try {
				f.get();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
	}

}