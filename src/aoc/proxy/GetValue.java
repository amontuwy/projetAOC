package aoc.proxy;

import java.util.concurrent.Callable;

import aoc.back.interfacies.Generateur;
import aoc.proxy.interfacies.ObservateurGenerateurAsync;

public class GetValue implements Callable<Integer> {

	Generateur gen;
	ObservateurGenerateurAsync canal;
	
	public GetValue(Generateur gen, ObservateurGenerateurAsync canal) {
		this.gen = gen;
		this.canal=canal;
	}


	@Override
	public Integer call() throws Exception {
		return this.gen.getValue(this.canal);
	}
}
