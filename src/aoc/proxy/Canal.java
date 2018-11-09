package aoc.proxy;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.MinimalHTMLWriter;

import aoc.back.Generateur;import aoc.back.GenerateurAsync;
import aoc.front.ObservateurGenerateur;
import aoc.front.ObservateurGenerateurAsync;

public class Canal implements ObservateurGenerateurAsync, GenerateurAsync {
	private ScheduledExecutorService schExecSv = new ScheduledThreadPoolExecutor(4);
	Generateur gen;
	ObservateurGenerateur obs;

	public Canal(Generateur gen, ObservateurGenerateur obs) {
		super();
		this.gen = gen;
		this.obs = obs;
	}

	@Override
	public void attach(ObservateurGenerateur obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void detach(ObservateurGenerateur obs) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Future<Integer> getValue() {
		return this.schExecSv.schedule(new GetValue(), 500, TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<Object> update(Generateur gen/*why*/) {
		return this.schExecSv.schedule(new Update(), 500, TimeUnit.MILLISECONDS);
	}

}
