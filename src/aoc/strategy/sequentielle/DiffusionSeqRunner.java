package aoc.strategy.sequentielle;

import java.util.List;
import java.util.concurrent.Future;

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
		System.out.println("----------Diffusion Sequentielle-------------------");
	}

}