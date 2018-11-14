package aoc.proxy;

import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import aoc.back.interfacies.Generateur;
import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.interfacies.GenerateurAsync;
import aoc.proxy.interfacies.ObservateurGenerateurAsync;

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
		return this.schExecSv.schedule(new GetValue(this.gen, this), 500, TimeUnit.MILLISECONDS);
	}

	@Override
	public Future<Object> update(Generateur gen) {
		this.gen = gen;
		return this.schExecSv.schedule(new Update(this.obs, this), 500, TimeUnit.MILLISECONDS);
	}

}
