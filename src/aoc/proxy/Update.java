package aoc.proxy;

import java.util.concurrent.Callable;

import aoc.front.interfacies.ObservateurGenerateur;
import aoc.proxy.interfacies.GenerateurAsync;

public class Update implements Callable<Object> {
	
	ObservateurGenerateur obs;
	GenerateurAsync canal;

	public Update(ObservateurGenerateur obs, GenerateurAsync canal) {
		this.obs=obs;
		this.canal=canal;
	}

	@Override
	public Object call() throws Exception {
		this.obs.update(this.canal);
		return null;
	}
	

}
